package org.example.hw2;

import org.example.hw2.Factory.Animal;

import java.util.Iterator;
import java.util.List;

public class Hunter extends Animal {


    @Override
    public void initialize(boolean randomAge, Field field, Location location) {

        super.initialize(randomAge, field, location);

    }

    @Override
    public void act(List<Animal> animal) {
        incrementAge();
        if (isAlive()) {
            giveBirth(animal);
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if (newLocation == null) {
                // No food found - try to move to a free location.
                newLocation = field.freeAdjacentLocation(location);
            }
            // See if it was possible to move.
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }

    private Location findFood() {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    return where;
                }
            }
            else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    return where;
                }
            }
            else if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                if (tiger.isAlive()) {
                    tiger.setDead();
                    return where;
                }
            }
        }
        return null;
    }


    @Override
    public int getMaxAge() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected double getBreedingProbability() {
        return 0.009;
    }

    @Override
    protected int getMaxLitterSize() {
        return 2;
    }

    @Override
    protected int getBreedingAge() {
        return Integer.MAX_VALUE;
    }

}
