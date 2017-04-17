package com.gmatsu;

import java.util.Scanner;
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


        Timer timer = new Timer();
        //hack to create a 'simulation'
        try {
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    //System.out.println("tick tock");
                    elevatorService.iterate();
                }
            },1,1000);


            
            String input = "";
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Enter a number: ");
            while (reader.hasNext()) {

                input = reader.next();
                if("exit".equals(input)) return;

                switch(input){
                    
                    case "where":
                        System.out.println("where");
                        elevatorService.whereAreTheElevators();
                        break;
                    case "who":
                        elevatorService.whoAreThePassengers();
                        break;
                    default :
                        System.out.println("int");
                        String[] req = input.split(",");
                        int from = Integer.parseInt(req[0]);
                        int to = Integer.parseInt(req[1]);
                        elevatorService.elevatorRequest(from,to);

                }

                System.out.println("next....");

            }


            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            timer.cancel();
        }

    }
}
