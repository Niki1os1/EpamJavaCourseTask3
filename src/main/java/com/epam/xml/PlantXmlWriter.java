package com.epam.xml;

import com.epam.domain.Plant;
import com.epam.domain.growingTips.GrowingTip;
import com.epam.domain.visualParameters.VisualParameter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class PlantXmlWriter {
    public void write(List<Plant> plants, String fileName) throws FileNotFoundException, XMLStreamException {
        XMLStreamWriter writer = null;
        try {
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            writer = factory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("plants");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xsi:schemaLocation", "greenhouse.xsd");
            for (Plant plant : plants) {
                writer.writeStartElement("plant");
                writer.writeAttribute("id", plant.getIdentity());
                writer.writeStartElement("name");
                writer.writeCData(plant.getName());
                writer.writeEndElement();
                writer.writeStartElement("soil");
                writer.writeCharacters(plant.getSoil().toString());
                writer.writeEndElement();
                writer.writeStartElement("origin");
                writer.writeCharacters(plant.getOrigin());
                writer.writeEndElement();
                writer.writeStartElement("visualParameters");
                for (VisualParameter visualParameter : plant.getVisualParameters()) {
                    writer.writeStartElement(visualParameter.getElement());
                    writer.writeCharacters(visualParameter.getValue());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeStartElement("growingTips");
                for (GrowingTip growingTip : plant.getGrowingTips()) {
                    writer.writeStartElement(growingTip.getElement());
                    writer.writeCharacters(growingTip.getValue());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeStartElement("multiplying");
                writer.writeCharacters(plant.getMultiplying().toString());
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}