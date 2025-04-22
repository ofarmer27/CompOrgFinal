package src.main.java.traffic;


public class TrafficLightController 
{
    private String lineOne;
    private String lineTwo;
    
    
    /*
     * 
     * 2 - Eastbound 4 - Southbound 6 - Westbound 8 - Northbound
     * 
     * 5 - EB Left Turn 7 - SB Left Turn 1 - WB Left Turn 3 - NB Left Turn
     * 
     * 1 2 a 3 4 5 6 a 7 8
     * 
     * 
     */

    public TrafficLightController(String lineOne, String lineTwo) 
    {
        this.lineOne = lineOne;
        this.lineTwo = lineTwo;
        
        initializeQueues(lineOne, lineTwo);
    }

    public void startCycle(Boolean state) 
    {
        while (state == true) {

        }
    }
    
    public static void initializeQueues(String lineOne, String lineTwo)
    {
        
    }



}