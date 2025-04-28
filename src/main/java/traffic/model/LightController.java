package src.main.java.traffic.model;

public class LightController {
    // char arrays that indicate traffic pattern
    private final Light[][] lights = new Light[4][3];

    private int cycleTimer;
    private int sensorCooldownTimer;
    int totalCycleTime;

    StateControlRing controlRing;

    public LightController(String stateSequenceOne, String stateSequenceTwo) 
    {

        controlRing = new StateControlRing(stateSequenceOne, stateSequenceTwo);

    }

    public void startCycle(int totalCycleTime) 
    {
        this.totalCycleTime = totalCycleTime;
        while (cycleTimer < totalCycleTime) {
            // evaluateTraffic void; setsLights; chooseAvailablePhase(determines queue proirity amongst available traffic options); 
            updateLights();
            testPrint();
            updateLights();
            waitFor(1);
            cycleTimer++;
            System.out.println(cycleTimer);
        }
    }

    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
    

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }


    private void setLights(String direction, String color) 
    {
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[i].length; j++) {
                if (lights[i][j].getDirection() == direction) {
                    lights[i][j].setColor(color);
                }
            }
        }
    }

    public void updateLights()
    {
        /* 
         * if neither light is on
         * 
         */
        Light current = controlRing.stateRingOne.peek();

    }

    private void testPrint() 
    {
        for (int i = 0; i < lights.length; i++) 
        {
            for (int j = 0; j < lights[i].length; j++) 
            {
     
            }
        }
    }
}