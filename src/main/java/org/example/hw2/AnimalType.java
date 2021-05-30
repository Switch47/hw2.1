package org.example.hw2;

public enum AnimalType {
    RABBIT(0.08),
    FOX(0.02);

    private double breedingProbability;

    private Class animalClass;

    AnimalType(double breedingProbability) {
        this.breedingProbability = breedingProbability;
    }

    public double getBreedingProbability() {
        return breedingProbability;
    }

    public Class getAnimalClass() {
        return animalClass;
    }
}
