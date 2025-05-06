package traffic.model;
import traffic.interfaces.StateControlRing;

public class LightController {
    // char arrays that indicate traffic pattern

    int topTimer = 0;
    int botTimer = 0;
    int simulateReadSensorCooldown = 5;
    int simulateReadSensorTimer = 0;  

    int greenLightLength; 

    StateControlRing controlRing;

    String topRingCurrentDirection;
    String botRingCurrentDirection;
    
    String topRingCurrentColor;
    String botRingCurrentColor; 

    public LightController(String stateSequenceOne, String stateSequenceTwo) 
    {

        controlRing = new StateControlRing(stateSequenceOne, stateSequenceTwo);

    }

    public void startCycle(int greenLightLength) 
    {
        this.greenLightLength = greenLightLength;
        controlRing.stateRingOne.peek().setColor("green");
        controlRing.stateRingTwo.peek().setColor("green");
        while (true) {
            updateLights();
            testPrint();
            waitFor(1);
            incrementTimers();
        }
    }
    
    private void incrementTimers()
    {
        topTimer++;
        botTimer++;
        simulateReadSensorTimer++;
    }

    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
    

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void simulateSensors()
    {
        if (simulateReadSensorTimer >= simulateReadSensorCooldown)
        {
            controlRing.stateRingOne.peek().simulateTraffic();
            controlRing.stateRingTwo.peek().simulateTraffic();
            simulateReadSensorTimer = 0; 
        }
        
    }

    public void updateLights()
    {
        simulateSensors();

        topRingCurrentColor = controlRing.stateRingOne.peek().getColor();
        topRingCurrentDirection = controlRing.stateRingOne.peek().getDirection();

        botRingCurrentColor = controlRing.stateRingTwo.peek().getColor();
        botRingCurrentDirection = controlRing.stateRingTwo.peek().getDirection();

        // if (topTimer >= greenLightLength) {
        //     controlRing.stateRingOne.peek().setColor("red");
        //     controlRing.stateRingTwo.peek().setColor("red");

        //     controlRing.stateRingOne.cycle();
        //     controlRing.stateRingTwo.cycle();

        //     if (controlRing.stateRingOne.peek().getDirection() == "BARRIER"
        //             && controlRing.stateRingTwo.peek().getDirection() == "BARRIER") {

        //         topTimer = 0;
        //     } else if (controlRing.stateRingOne.peek().getDirection() == "BARRIER") {
        //         controlRing.stateRingTwo.cycle();

        //         topTimer = 0;
        //     } else if (controlRing.stateRingTwo.peek().getDirection() == "BARRIER") {

        //         controlRing.stateRingOne.cycle();
        //         topTimer = 0;
        //     }

        //     controlRing.stateRingOne.peek().setColor("green");
        //     controlRing.stateRingTwo.peek().setColor("green");
        //     topTimer = 0;
        // }

    }

    private void testPrint() 
    {
        for (int i = 0; i < controlRing.numberOfLights; i++)
        {
            topRingCurrentColor = controlRing.stateRingOne.peek().getColor(); 
            topRingCurrentDirection = controlRing.stateRingOne.peek().getDirection();


            botRingCurrentColor = controlRing.stateRingTwo.peek().getColor(); 
            botRingCurrentDirection = controlRing.stateRingTwo.peek().getDirection();

            System.out.println(controlRing.stateRingOne.peek().getDirection() + " " + controlRing.stateRingOne.peek().getColor());
            System.out.println(controlRing.stateRingTwo.peek().getDirection() + " " + controlRing.stateRingTwo.peek().getColor());

            controlRing.stateRingOne.cycle();
            controlRing.stateRingTwo.cycle();
        }

        System.out.println();
        
    }
}