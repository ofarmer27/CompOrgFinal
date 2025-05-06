package traffic.model;
import traffic.interfaces.StateControlRing;

public class LightController {
    // char arrays that indicate traffic pattern


    int timers[] = { 0, 0 };
    int simulateReadSensorCooldown = 5;
    int simulateReadSensorTimer = 0;  

    int greenLightLength;
    int yellowLightLength;

    int totalCycleLength = greenLightLength + yellowLightLength; 

    StateControlRing controlRing;

    String topRingCurrentDirection;
    String botRingCurrentDirection;
    
    String topRingCurrentColor;
    String botRingCurrentColor; 

    public LightController(String[] stateSequences) 
    {

        controlRing = new StateControlRing(stateSequences);
        greenLightLength = 55;
        yellowLightLength = 5;
    }

    public void startCycle(int greenLightLength) 
    {
        this.greenLightLength = greenLightLength;
        controlRing.rings[0].peek().setColor("green");
        controlRing.rings[1].peek().setColor("green");

        while (true) {
            updateLights();
            testPrint();
            waitFor(1);
            incrementTimers();
        }
    }
    
    private void incrementTimers()
    {
        timers[0]++;
        timers[1]++; 
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
            for (int i = 0; i < 2; i++)
            {
                controlRing.rings[i].peek().simulateTraffic();
            }
            simulateReadSensorTimer = 0; 
        }
        
    }

    public void updateLights()
    {
        simulateSensors();

        topRingCurrentColor = controlRing.rings[0].peek().getColor();
        topRingCurrentDirection = controlRing.rings[0].peek().getDirection();

        botRingCurrentColor = controlRing.rings[1].peek().getColor();
        botRingCurrentDirection = controlRing.rings[1].peek().getDirection();

        if (topRingCurrentDirection != "BARRIER" && botRingCurrentDirection != "BARRIER") 
        {
            for (int i = 0; i < 2; i++) // for each light
            {
                // if green light up and priority is next light
                if (timers[i] > greenLightLength && controlRing.rings[i].determinePriority() == controlRing.rings[i].peekNext().getColor())
                {
                    // set yellow
                    // cycle
                }
                // green light up and priority is current light
                else if (timers[i] > greenLightLength && controlRing.rings[i].determinePriority() == controlRing.rings[i].peek().getColor())
                {
                    // add to green light time of this light and subtract from the other``
                }
                else if (timers[i] > yellowLightLength)
                {
                    //set red
                }
                
                // if priority is next for current light
                if (controlRing.rings[i].determinePriority() == controlRing.rings[i].peek().getDirection())
                {

                }
                else
                {

                }
            }
        } else 
        {
            controlRing.syncRingsAtNextBarrier();
        }
        // for each ring NTK: 
        // sensor priority
        // timer status
        // next priority
        // if either at barrier
        // 
        //  IF NEITHER AT BARRIER
        // for each ring
        //      if time up, and priotity is current light
        // extend by 10 continue until timer up, then switch

        //   
        //  IF ONE OR BOTH AT BARRIER
        // cycle each light until at next
        //  
        // 

    }
    
    

    
    
    private void testPrint() 
    {
        for (int i = 0; i < controlRing.numberOfLights; i++)
        {
            topRingCurrentColor = controlRing.rings[0].peek().getColor(); 
            topRingCurrentDirection = controlRing.rings[0].peek().getDirection();


            botRingCurrentColor = controlRing.rings[1].peek().getColor(); 
            botRingCurrentDirection = controlRing.rings[1].peek().getDirection();

            System.out.println(controlRing.rings[0].peek().getDirection() + " " + controlRing.rings[0].peek().getColor());
            System.out.println(controlRing.rings[1].peek().getDirection() + " " + controlRing.rings[1].peek().getColor());

            controlRing.rings[0].cycle();
            controlRing.rings[1].cycle();
        }

        System.out.println();
        
    }
}