package com.gmatsu;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Taking the Drools Rule Engine Approach to Simulating Elevators.
 *
 * Each Elevator has a state,
 * Each Passenger has a State,
 * The Building is the StateFul Session Engine
 *
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        final ElevatorService elevatorService = new ElevatorService();

        int numOfFloors = 10;
        int numOfElevetors = 5;

        elevatorService.initFloors(numOfFloors);
        elevatorService.initElevators(numOfElevetors);
        elevatorService.addElevator(20);  //add a Larger elevator


        elevatorService.start(); //start engine


        //Add random requests
        elevatorService.elevatorRequest(1,2);
        elevatorService.elevatorRequest(1,3);
        elevatorService.elevatorRequest(2,4);
        elevatorService.elevatorRequest(3,5);
        elevatorService.elevatorRequest(5,2);



        //hack to create a 'simulation'
        try {
            new Timer().scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    elevatorService.iterate();
                }
            },1,1000);
            
            Thread.currentThread().join();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
