package com.alanpugachev.Animalgenerator.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
public class Generator implements Creatable {

    @Override
    public void generate() {

    }

    public void writeIntoFile () {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get("gen.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(26);

            for (int i = 0; i < byteBuffer.capacity(); i++) {
                byteBuffer.put((byte) i);
            }

            byteBuffer.rewind();
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
