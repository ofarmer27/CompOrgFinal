package traffic.model;
import traffic.controller.ApplicationDriver;
import traffic.interfaces.StateControlRing;
import traffic.controller.ApplicationDriver; 
public class LightController {
    // char arrays that indicate traffic pattern
    final String GREEN = "green";
    final String YELLOW = "yellow";
    final String RED = "red";
    final String BARRIER = "BARRIER";


    int timers[] = { 0, 0 };
    int simulateReadSensorCooldown = 5;
    int simulateReadSensorTimer = 0;  

    int greenLightLength;
    int yellowLightLength;

    int totalCycleLength = greenLightLength + yellowLightLength; 

    public StateControlRing controlRing;

    String topRingCurrentDirection;
    String botRingCurrentDirection;
    
    String topRingCurrentColor;
    String botRingCurrentColor; 

    public LightController(String[] stateSequences) 
    {

        controlRing = new StateControlRing(stateSequences);
        greenLightLength = 60;
        yellowLightLength = 5;
    }

    public void startCycle()
    {
        
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
                controlRing.rings[i].peek().simulateReadSensor();
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

        if (topRingCurrentDirection != BARRIER && botRingCurrentDirection != BARRIER) 
        {
            for (int i = 0; i < 2; i++) // for each light
            {
                // if green light up 
                if (timers[i] > greenLightLength)
                {
                    controlRing.rings[i].peek().setColor("yellow");
                    ApplicationDriver.TrafficLightPanel.color = "yellow"; 
                }
                else if (timers[i] > greenLightLength + yellowLightLength)
                {
                    controlRing.rings[i].peek().setColor("red");
                    controlRing.rings[i].cycle();
                }
            }
        } else 
        {
            controlRing.syncRingsAfterNextBarrier();
        }

    }
    
    private void testPrint() 
    {
        controlRing.printRingQueues();
        System.out.println();
    }
}