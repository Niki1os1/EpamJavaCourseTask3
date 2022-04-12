package com.epam.xml;

import com.epam.domain.Multiplying;
import com.epam.domain.Plant;
import com.epam.domain.Soil;
import com.epam.domain.growingTips.Lighting;
import com.epam.domain.growingTips.Temperature;
import com.epam.domain.growingTips.Watering;
import com.epam.domain.visualParameters.AveragePlantSize;
import com.epam.domain.visualParameters.LeafPresence;
import com.epam.domain.visualParameters.StemColor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class PlantXmlReader {
    public List<Plant> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            List<Plant> plants = new ArrayList<>();
            Plant plant = null;
            XMLInputFactory factory = XMLInputFactory.newInstance();
            reader = factory.createXMLStreamReader(is);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("plant".equals(tagName)) {
                            plant = new Plant();
                            plant.setIdentity(reader.getAttributeValue(null, "id"));
                        } else if ("name".equals(tagName)) {
                            plant.setName(reader.getElementText());
                        } else if ("soil".equals(tagName)) {
                            plant.setSoil(Soil.valueOf(reader.getElementText()));
                        } else if ("origin".equals(tagName)) {
                            plant.setOrigin(reader.getElementText());
                        } else if ("stemColor".equals(tagName)) {
                            StemColor stemColor = new StemColor();
                            stemColor.setElement(tagName);
                            stemColor.setValue(reader.getElementText());
                            plant.getVisualParameters().add(stemColor);
                        } else if ("leafPresence".equals(tagName)) {
                            LeafPresence leafPresence = new LeafPresence();
                            leafPresence.setElement(tagName);
                            leafPresence.setValue(reader.getElementText());
                            plant.getVisualParameters().add(leafPresence);
                        } else if ("averagePlantSize".equals(tagName)) {
                            AveragePlantSize averagePlantSize = new AveragePlantSize();
                            averagePlantSize.setElement(tagName);
                            averagePlantSize.setValue(reader.getElementText());
                            plant.getVisualParameters().add(averagePlantSize);
                        } else if ("temperature".equals(tagName)) {
                            Temperature temperature = new Temperature();
                            temperature.setElement(tagName);
                            temperature.setValue(reader.getElementText());
                            plant.getGrowingTips().add(temperature);
                        } else if ("lighting".equals(tagName)) {
                            Lighting lighting = new Lighting();
                            lighting.setElement(tagName);
                            lighting.setValue(reader.getElementText());
                            plant.getGrowingTips().add(lighting);
                        } else if ("watering".equals(tagName)) {
                            Watering watering = new Watering();
                            watering.setElement(tagName);
                            watering.setValue(reader.getElementText());
                            plant.getGrowingTips().add(watering);
                        } else if ("multiplying".equals(tagName)) {
                            plant.setMultiplying(Multiplying.valueOf(reader.getElementText()));
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("plant".equals(tagName)) {
                            plants.add(plant);
                        }
                        break;
                    }
                }
            }
            return plants;
        } catch (XMLStreamException | IOException e) {
            return null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}