package com.gmatsu.models;

/**
 * @author gmatsu
 */
public class Passenger {

    private int id;

    private int fromFloor;
    private int toFloor;

    private Elevator myElevator;


    public Elevator getMyElevator() {
        return myElevator;
    }

    public void setMyElevator(Elevator myElevator) {
        this.myElevator = myElevator;
    }

    public int getToFloor() {
        return toFloor;
    }

    public void setToFloor(int toFloor) {
        this.toFloor = toFloor;
    }

    public int getFromFloor() {
        return fromFloor;
    }

    public void setFromFloor(int fromFloor) {
        this.fromFloor = fromFloor;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", fromFloor=" + fromFloor +
                ", toFloor=" + toFloor +
                ", myElevator=" + myElevator +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}
