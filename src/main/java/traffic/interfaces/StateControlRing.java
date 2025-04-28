package src.main.java.traffic.interfaces;

/* * 2 - Eastbound    5 - EB Left Turn 
     * 4 - Southbound   7 - SB Left Turn 
     * 6 - Westbound    1 - WB Left Turn 
     * 8 - Northbound   3 - NB Left Turn */
public class StateControlRing 
{
    public int numberOfLights;
    public int timer; 

    public SinglePhaseRing stateRingOne;
    public SinglePhaseRing stateRingTwo;


    public StateControlRing(String stateSequenceOne, String stateSequenceTwo)
    {
        initializeStateQueues(stateSequenceOne, stateSequenceTwo);
    }
    
    public void initializeStateQueues(String stateSequenceOne, String stateSequenceTwo) 
    {
        stateRingOne = new SinglePhaseRing();
        stateRingTwo = new SinglePhaseRing();

        for (int i = 0; i < stateSequenceOne.length(); i++) {

            stateRingOne.enqueue(new Light(stateSequenceOne.charAt(i)));
            stateRingTwo.enqueue(new Light(stateSequenceTwo.charAt(i)));
            numberOfLights += 2;
        }
    }


}
