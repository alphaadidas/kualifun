package com.gmatsu;

import com.gmatsu.models.Elevator;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author: gmatsu
 */
public class ElevatorService {

    private KieSession ksession;

    private int elevatorCount = 0;
    private int numOfFloors = 1;

    public ElevatorService(){
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        ksession = kc.newKieSession("searsTower");
        
    }


    public void initElevators(int numOfElevators){

        for(int i = elevatorCount ; i < numOfElevators ; i++){
            Elevator elevator = new Elevator();

            elevator.setId(i);
            //elevator.setMinFloor(1); defaulting to 1 already
            elevator.setMaxFloor(numOfFloors);
            //elevator.setMaxLoad(10); defaulting to 10
            ksession.insert(elevator);
            
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

        


    }


    public void iterate(){
        //send command to increment all states 1 interval
            

    }




    public void elevatorRequest(int fromFloor, int toFloor){
        //insert Request into Drools EntryPoint
        
    }

}
