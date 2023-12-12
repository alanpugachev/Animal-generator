package com.alanpugachev.Animalgenerator.services;

import com.alanpugachev.Animalgenerator.models.Animal;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;

public class Converter implements Writer {

    @Override
    public void writeAnAnimal(Animal animal) {
        try {
            Path namesSrc = Paths.get("src/main/resources/Names.txt");
            List<String> allNames = Files.readAllLines(namesSrc);
            String name = allNames.get(new Random().nextInt(allNames.size()));

            FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get(name + ".txt"),
                    StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            ByteBuffer byteBuffer = ByteBuffer.allocate((int) animal.getKindOfAnimal().length() + animal.getDescription().length() + 1);

            byteBuffer.put(animal.getKindOfAnimal().getBytes());
            byteBuffer.put("\n".getBytes());
            byteBuffer.put(animal.getDescription().getBytes());

            byteBuffer.rewind();
            //fileChannel.write(byteBuffer);
            System.out.println(fileChannel.write(byteBuffer));
            System.out.println(name + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
