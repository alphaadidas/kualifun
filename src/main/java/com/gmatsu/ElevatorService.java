package com.gmatsu;

import com.gmatsu.models.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.EntryPoint;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gmatsu
 */
public class ElevatorService {

    private KieSession ksession;

    private int elevatorCount = 0;
    private int numOfFloors = 1;

    public ElevatorService(){
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        this.ksession = kc.newKieSession("searsTower");
        
    }


    public void initElevators(int numOfElevators){

        for(int i = elevatorCount ; i < numOfElevators ; i++){
            Elevator elevator = new Elevator();
            elevator.setId(i);
            //elevator.setMinFloor(1); defaulting to 1 already
            elevator.setMaxFloor(numOfFloors);
            elevator.setCurrentFloor(1);
            //elevator.setMaxLoad(10); defaulting to 10
            elevator.setDirection(Direction.NONE);
            this.ksession.insert(elevator);
            
        }

        elevatorCount += numOfElevators;
    }

    /**
     * add elevators 1 by 1, with specific capacity
     * @param capacity
     */
    public void addElevator(int capacity) {


    }


    public void initFloors(int numFloors) {
       this.numOfFloors = numFloors;
    }
    

    public void start(){
        this.ksession.fireAllRules();
    }


    public void stop(){
        this.ksession.halt();
    }

    

    public void iterate(){
        //send command to increment all states 1 interval

        List<Elevator> elevators = new ArrayList<Elevator>();

        EntryPoint ep = this.ksession.getEntryPoint("IntervalStepStream");
        ep.insert(new Clock());

        this.ksession.fireAllRules();


        QueryResults queryResults = this.ksession.getQueryResults("FetchElevators");
        for (QueryResultsRow row : queryResults) {
            elevators.add((Elevator) row.get("$elevator"));
        }

        for (Elevator elevator: elevators){
            //System.out.println("Found Elevator:"+elevator.getId() + " on floor:"+elevator.getCurrentFloor());
        }
        
    }
    public void whereAreTheElevators(){
        List<Elevator> elevators = new ArrayList<Elevator>();
        QueryResults queryResults = this.ksession.getQueryResults("FetchElevators");
        for (QueryResultsRow row : queryResults) {
            elevators.add((Elevator) row.get("$elevator"));
        }

        for (Elevator elevator: elevators){
            System.out.println("Found Elevator:"+elevator.getId() + " on floor:"+elevator.getCurrentFloor());
        }
    }

    public void whoAreThePassengers(){
        List<Passenger> passengers = new ArrayList<>();

        QueryResults queryResults = this.ksession.getQueryResults("FetchPassengers");
        for (QueryResultsRow row : queryResults) {
            passengers.add((Passenger) row.get("$p"));
        }

        for (Passenger p : passengers){
            System.out.println(p);
        }
    }


    public void elevatorRequest(int fromFloor, int toFloor){
        //insert Request into Drools EntryPoint
        Request req = new Request();
        req.setToFloor(toFloor);
        req.setFromFloor(fromFloor);

        EntryPoint ep = this.ksession.getEntryPoint("RequestStream");
        ep.insert(req);

        this.ksession.fireAllRules();
    }

}
