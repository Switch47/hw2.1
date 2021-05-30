package org.example.hw2;

import org.example.hw2.Factory.Animal;

import java.util.List;
import java.util.Random;

public class Rabbit extends Animal {



    /**
     * This is what the rabbit does most of the time - it runs around. Sometimes
     * it will breed or die of old age.
     *
     * @param animal A list to return newly born rabbits.
     */
    @Override
    public void act(List<Animal> animal) {
        incrementAge();
        if (isAlive()) {
            giveBirth(animal);
            // Try to move into a free location.
            Location newLocation = field.freeAdjacentLocation(location);
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }

    @Override
    protected double getBreedingProbability() {
        return 0.12;
    }

    @Override
    protected int getMaxLitterSize() {
        return 4;
    }

    @Override
    public int getMaxAge() {
        return 40;
    }

    @Override
    protected int getBreedingAge() {
        return 5;
    }

}

