package src.main.java.traffic.model;

import src.main.java.traffic.interfaces.Light;
import src.main.java.traffic.interfaces.StateControlRing;

public class LightController {
    // char arrays that indicate traffic pattern

    int topTimer = 0;

    int greenLightLength; 

    StateControlRing controlRing;

    public LightController(String stateSequenceOne, String stateSequenceTwo) 
    {

        controlRing = new StateControlRing(stateSequenceOne, stateSequenceTwo);

    }

    public void startCycle(int greenLightLength) 
    {
        this.greenLightLength = greenLightLength;
        controlRing.stateRingOne.peek().setColor("green");
        controlRing.stateRingTwo.peek().setColor("green");
        while (true) 
        {
            updateLights();
            testPrint();
            waitFor(1);
            topTimer++;
        }
    }

    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
    

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void updateLights()
    {
        // simulate traffic sensors
        
        // if timer is up
        if (topTimer >= greenLightLength)
        {

            // if (controlRing.stateRingOne.determinePriority() == controlRing.stateRingOne.peekNext().getDirection())
            // {

            // }
            // else if (controlRing.stateRingOne.determinePriority() == controlRing.stateRingOne.peek().getDirection()) {

            // }

            // if (controlRing.stateRingOne.determinePriority() == controlRing.stateRingOne.peekNext().getDirection())
            // {

            // }

            controlRing.stateRingOne.peek().setColor("red");
            controlRing.stateRingTwo.peek().setColor("red");

            controlRing.stateRingOne.cycle();
            controlRing.stateRingTwo.cycle();

            // if both at barrier
            if (controlRing.stateRingOne.peek().getDirection() == "BARRIER"
                    && controlRing.stateRingTwo.peek().getDirection() == "BARRIER") {

                topTimer = 0;
            }
            // if top at barrier
            else if (controlRing.stateRingOne.peek().getDirection() == "BARRIER") {
                // cycle bottom twice
                // controlRing.stateRingTwo.cycle();
                controlRing.stateRingTwo.cycle();

                // cycle top once
                // controlRing.stateRingOne.cycle();

                topTimer = 0;
            }
            // if bottom at barrier
            else if (controlRing.stateRingTwo.peek().getDirection() == "BARRIER") {
                // cycle top twice
                controlRing.stateRingOne.cycle();
                // controlRing.stateRingOne.cycle();

                //cycle bottom once
                // controlRing.stateRingTwo.cycle();

                topTimer = 0;
            }

            controlRing.stateRingOne.peek().setColor("green");
            controlRing.stateRingTwo.peek().setColor("green");
            topTimer = 0;
        }


    }

    private void testPrint() 
    {
        System.out.println(controlRing.stateRingOne.peek().getDirection() + " " + controlRing.stateRingOne.peek().getColor());

        System.out.println(controlRing.stateRingOne.peek().getDirection() + " " + controlRing.stateRingTwo.peek().getColor());

        System.out.println(topTimer);

        for (int i = 0; i < controlRing.numberOfLights; i++)
        {
            System.out.println(controlRing.stateRingOne.peek().getDirection() + " " + controlRing.stateRingOne.peek().getColor());
            

            System.out.println(controlRing.stateRingTwo.peek().getDirection() + " " + controlRing.stateRingTwo.peek().getColor());


            controlRing.stateRingOne.cycle();
            controlRing.stateRingTwo.cycle();
        }

        System.out.println();
        
    }
}