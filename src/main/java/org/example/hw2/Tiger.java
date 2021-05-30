package org.example.hw2;

import org.example.hw2.Factory.Animal;

import java.util.Iterator;
import java.util.List;


public class Tiger extends Animal {


    private static final int FOOD_VALUE = 20;
    private int foodLevel;

    @Override
    public void initialize(boolean randomAge, Field field, Location location) {

        super.initialize(randomAge, field, location);
        foodLevel = RANDOM.nextInt(FOOD_VALUE);
    }

    @Override
    public void act(List<Animal> animal) {
        incrementAge();
        incrementHunger();
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
                    foodLevel = FOOD_VALUE;
                    return where;
                }
            }
            else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    foodLevel = FOOD_VALUE;
                    return where;
                }
            }
        }
        return null;
    }

    private void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }
    @Override
    public int getMaxAge() {
        return 80;
    }

    @Override
    protected double getBreedingProbability() {
        return 0.05;
    }

    @Override
    protected int getMaxLitterSize() {
        return 2;
    }

    @Override
    protected int getBreedingAge() {
        return 19;
    }

}
