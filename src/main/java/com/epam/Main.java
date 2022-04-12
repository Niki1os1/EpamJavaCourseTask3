package com.epam;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.xml.stream.XMLStreamException;

import com.epam.domain.Plant;
import com.epam.xml.PlantXmlReader;
import com.epam.xml.PlantXmlValidator;
import com.epam.xml.PlantXmlWriter;

public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {
        PlantXmlValidator validator = new PlantXmlValidator("greenhouse.xml");
     if (validator.validate()) {
            PlantXmlReader reader = new PlantXmlReader();
            List<Plant> plants = reader.read("greenhouse.xml");
//            Random random = new Random();
//            for (Plant plant : plants) {
//                plant.setCost((long) (plant.getCost() * (1 + random.nextInt(100)/100.0)));
//            }
//            Collections.sort(vauchers);
            Collections.sort(plants, new Comparator<Plant>() {
                @Override
                public int compare(Plant o1, Plant o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            });
            for (Plant plant : plants) {
                System.out.println(plant);
            }
            PlantXmlWriter writer = new PlantXmlWriter();
            writer.write(plants, "plants-new.xml");
        } else {
            System.out.println(validator.getError());
        }
    }
}