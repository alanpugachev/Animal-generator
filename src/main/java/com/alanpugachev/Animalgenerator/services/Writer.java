package com.alanpugachev.Animalgenerator.services;

import com.alanpugachev.Animalgenerator.models.Animal;

@FunctionalInterface
public interface Writer {
    public void writeAnAnimal(Animal animal);
}
