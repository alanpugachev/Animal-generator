package com.alanpugachev.Animalgenerator.controllers;

import com.alanpugachev.Animalgenerator.models.Animal;
import com.alanpugachev.Animalgenerator.services.Converter;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@AllArgsConstructor
public class Generator implements Runnable {
    private int amountOfAnimals;

    @Override
    public void run() {
        Converter animalConverter = new Converter();

        for (int i = 0; i < this.amountOfAnimals; i++) {
            Animal animal = new Animal();
            animalConverter.writeAnAnimal(animal);
        }
    }
}
