package com.alanpugachev.Animalgenerator.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

@AllArgsConstructor
@Setter
@Getter
public class Animal {
    private String kindOfAnimal;
    private String description;

    public Animal() {
        /* for kind */
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("src/main/resources/Animals.txt"))) {
            MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            StringBuilder kind = new StringBuilder();

            /*
            Random rand = new Random(0);
            int position = rand.nextInt(byteBuffer.capacity());
            */


            for (int i = 0; i < byteBuffer.capacity(); i++) {
                kind.append((char) byteBuffer.get());
            }

            this.kindOfAnimal = String.valueOf(kind);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file with animals kind");
        }

        /* for description */
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("src/main/resources/Descriptions.txt"))) {
            MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            StringBuilder description = new StringBuilder();

            for (int i = 0; i < byteBuffer.capacity(); i++) {
                description.append((char) byteBuffer.get());
            }

            this.description = String.valueOf(description);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file with animals description");
        }
    }
}
