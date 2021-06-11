package org.example.hw2;

public interface Observable {

    void attach(Observer o);

    void detach(Observer o);

    void notifyObserver(int step, Field field);
}
