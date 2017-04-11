package com.gmatsu.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gmatsu
 */
public class Elevator {


    //STATE :  OutOfOrder, Moving, Open, Closed

    //SERVICE_STATE :  InOrder / OutOfOrder
    //trip Count ,, init or reset after service
    //

    //ACTION_STATE : Moving, Stopped

    //DOOR_STATE: Opened, Closed

    //DIRECTION_STATE : UP | DOWN

    //current floor  : int

    //target Floors : int[]

    private int maxLoad = 10;
    private List<Passenger> passengers = new ArrayList<Passenger>();


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
}
