package org.example.hw2.Factory;

import org.example.hw2.Fox;
import org.example.hw2.Hunter;
import org.example.hw2.Rabbit;
import org.example.hw2.Tiger;

import java.awt.*;

public enum AnimalType {
    RABBIT(0.12, Rabbit.class, Color.ORANGE),
    FOX(0.1, Fox.class, Color.BLUE),
    HUNTER(0.05, Hunter.class, Color.RED),
    TIGER(0.05, Tiger.class, Color.BLACK);


    private double breedingProbability;

    private Class animalClass;

    private Color color;

    AnimalType(double breedingProbability, Class animalClass, Color color) {
        this.breedingProbability = breedingProbability;
        this.animalClass = animalClass;
        this.color = color;
    }

    public double getBreedingProbability() {
        return breedingProbability;
    }

    public Class getAnimalClass() {
        return animalClass;
    }

    public Color getColor() {
        return color;
    }
}
