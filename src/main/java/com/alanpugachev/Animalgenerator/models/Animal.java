package com.alanpugachev.Animalgenerator.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
public class Animal {
    private String kindOfAnimal;
    private String description;

    public Animal() {
        try {
            Path animalsPath = Paths.get("src/main/resources/Animals.txt");
            Path descriptionsPath = Paths.get("src/main/resources/Descriptions.txt");

            List<String> allAnimals = Files.readAllLines(animalsPath);
            List<String> allDescriptions = Files.readAllLines(descriptionsPath);

            this.kindOfAnimal = allAnimals.get(new Random().nextInt(allAnimals.size()));
            this.description = allDescriptions.get(new Random().nextInt(allDescriptions.size()));
        } catch (IOException e) {
            System.out.println("Cannot open animals/descriptions file");
        }
    }
}
