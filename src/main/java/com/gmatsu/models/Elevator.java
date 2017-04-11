package com.gmatsu.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gmatsu
 */
public class Elevator {

    private int id;

    private int minFloor = 1; // just keep this at 1, not supporitng skyscrapers
    private int maxFloor = 1;

    private Direction direction;

    private int currentFloor;
    private int[] targetFloors;
    private boolean evaluating = false;

    //STATE :  OutOfOrder, Moving, Open, Closed

    //SERVICE_STATE :  InOrder / OutOfOrder
    //trip Count ,, init or reset after service
    //

    //ACTION_STATE : Moving, Stopped

    //DOOR_STATE: Opened, Closed

    

    private int maxLoad = 10;
    private List<Passenger> passengers = new ArrayList<Passenger>();

    
    public void disembardPassenger(Passenger p){
        System.out.println("Passenger leaving elevator");
    }

    public void loadPassenger(Passenger p){
        System.out.println("Passenger entering elevator, from: to: ");
    }

    

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isEvaluating() {
        return evaluating;
    }

    public void setEvaluating(boolean evaluating) {
        this.evaluating = evaluating;
    }
}
