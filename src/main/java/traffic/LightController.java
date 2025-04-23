package src.main.java.traffic;


public class LightController 
{
    // char arrays that indicate traffic pattern
    private char[] lineOne;
    private char[] lineTwo;
    
    Queue<Character> stateQueueOne = new Queue<Character>();
    Queue<Character> stateQueueTwo = new Queue<Character>();

    
    
    /*
     * 
     * 2 - Eastbound    5 - EB Left Turn 
     * 4 - Southbound   7 - SB Left Turn 
     * 6 - Westbound    1 - WB Left Turn 
     * 8 - Northbound   3 - NB Left Turn
     * 
     * 1 2 a 3 4 a
     * 5 6 a 7 8 a
     * 
     * 
     */

    public LightController(char[] lineOne, char[] lineTwo) 
    {
        this.lineOne = lineOne;
        this.lineTwo = lineTwo;

        initializeStateQueues(lineOne, lineTwo);

    }

    public void startCycle(Boolean on) 
    {
        while (on == true)
        {
            /* 
             * Check Sensors and create priority
             * advance states based on timers and priorities
             * 
             * 
             */

        }
    }
    
    public static void initializeStateQueues(char[] lineOne, char[] lineTwo)
    {
        for (int i = 0; i < lineOne.length; i++)
        {


        }

    }



}