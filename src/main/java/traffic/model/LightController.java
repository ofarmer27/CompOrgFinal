package src.main.java.traffic.model;

import src.main.java.traffic.interfaces.LinkedCircularQueue;

public class LightController {
    // char arrays that indicate traffic pattern
    private Light[][] lights = new Light[4][2];

    private int timer;

    private String stateSequenceOne;
    private String stateSequenceTwo;

    public LinkedCircularQueue<Character> stateRingOne = new LinkedCircularQueue<Character>();
    public LinkedCircularQueue<Character> stateRingTwo = new LinkedCircularQueue<Character>();
    
    /*
     * 
     * 2 - Eastbound    5 - EB Left Turn 
     * 4 - Southbound   7 - SB Left Turn 
     * 6 - Westbound    1 - WB Left Turn 
     * 8 - Northbound   3 - NB Left Turn
     * 
     * 1 2 a 3 4 a
     * 5 6 a 7 8 a
     */

    public LightController() {

        lights[0][0] = new Light("north");
        lights[0][1] = new Light("north");

        lights[1][0] = new Light("south");
        lights[1][1] = new Light("south");

        lights[2][0] = new Light("east");
        lights[2][1] = new Light("east");

        lights[3][0] = new Light("west");
        lights[3][1] = new Light("west");

    }

    public void startCycle() {
        initializeStateQueues(stateSequenceOne, stateSequenceTwo);

        while (true) {

            testPrint();
            waitFor(1);
            timer++; 
        }
    }

    private void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    // private void setLights(String direction, String color) {

    //     for (int i = 0; i < lights.length; i++) {
    //         for (int j = 0; j < lights[i].length; j++) {
    //             if (lights[i][j].getDirection() == direction) {
    //                 lights[i][j].setColor(color);
    //             }
    //         }
    //     }

    // }

    private void testPrint() {
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[i].length; j++) {
                System.out.print(lights[i][j].getColor() + " ");
            }
        }

        System.out.println();
    }

    public void initializeStateQueues(String stateSequenceOne, String stateSequenceTwo) {

        for (int i = 0; i < stateSequenceOne.length(); i++) {
            stateRingOne.enqueue(stateSequenceOne.charAt(i));
            stateRingTwo.enqueue(stateSequenceTwo.charAt(i));
        }

    }

    

}