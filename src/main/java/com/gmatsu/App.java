package com.gmatsu;

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

        ElevatorService elevatorService = new ElevatorService();

        int numOfFloors = 10;
        elevatorService.initFloors(10);
        elevatorService.initElevators(5);
        elevatorService.addElevator(20);  //add a Larger elevator


        elevatorService.run(); //start engine



        //Add random requests
        elevatorService.elevatorRequest(1,2);
        elevatorService.elevatorRequest(1,3);
        elevatorService.elevatorRequest(2,4);
        elevatorService.elevatorRequest(3,5);
        elevatorService.elevatorRequest(5,2);

        //elevatorService  add Passenger Request(1,2)
        //elevatorService  add Passenger Request
        //elevatorService  add Passenger Request

        
        try {
        
            Thread.currentThread().join();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
