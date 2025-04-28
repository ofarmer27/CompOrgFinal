package src.main.java.traffic.controller;

import src.main.java.traffic.interfaces.LinkedCircularQueue;
import src.main.java.traffic.interfaces.LinkedQueue;
import src.main.java.traffic.model.LightController;

public class Driver
{
    public static void main(String[] args)
    {
        LightController controller = new LightController();

        controller.initializeStateQueues("12a34", "56a78");
        controller.stateRingOne.printQueue();
        controller.stateRingOne.cycle();
        controller.stateRingOne.printQueue();
        controller.stateRingOne.cycle();
        controller.stateRingOne.printQueue();
        controller.stateRingOne.cycle();
        controller.stateRingOne.printQueue();
        controller.stateRingOne.cycle();
        
        
    }
}