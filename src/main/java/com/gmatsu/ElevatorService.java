package com.gmatsu;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author: gmatsu
 */
public class ElevatorService {

    private KieSession ksession;


    public ElevatorService(){
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        ksession = kc.newKieSession("searsTower");
        
    }


    public void initElevators(int numOfElevators){

    }

    /**
     * add elevators 1 by 1, with specific capacity
     * @param capacity
     */
    public void addElevator(int capacity) {
        

    }


    public void initFloors(int numFloors) {

    }
    

    public void run(){

    }



    public void elevatorRequest(int fromFloor, int toFloor){
            
    }

}
