package src.main.java.traffic.controller;

import src.main.java.traffic.interfaces.Queue;

public class Driver
{
    public static void main(String[] args)
    {
        // LightController myLightController = new LightController();

        // myLightController.startCycle(null);
        Queue<Integer> myQueue = new Queue<Integer>();

        for (int i = 0; i < 5; i++)
        {
            myQueue.enqueue(i);
        }

        if (myQueue.getNumberOfElements() == 5)
        {
            System.out.println("test passed");
        }
        
    }
}