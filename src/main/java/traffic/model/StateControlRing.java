package src.main.java.traffic.model;

import src.main.java.traffic.interfaces.LinkedCircularQueue;

/* * 2 - Eastbound    5 - EB Left Turn 
     * 4 - Southbound   7 - SB Left Turn 
     * 6 - Westbound    1 - WB Left Turn 
     * 8 - Northbound   3 - NB Left Turn */
public class StateControlRing 
{

    public LinkedCircularQueue<Light> stateRingOne;
    public LinkedCircularQueue<Light> stateRingTwo;


    public StateControlRing(String stateSequenceOne, String stateSequenceTwo)
    {
        initializeStateQueues(stateSequenceOne, stateSequenceTwo);
    }
    
    public void initializeStateQueues(String stateSequenceOne, String stateSequenceTwo) 
    {
        stateRingOne = new LinkedCircularQueue<Light>();
        stateRingTwo = new LinkedCircularQueue<Light>();

        for (int i = 0; i < stateSequenceOne.length(); i++) 
        {

            stateRingOne.enqueue(new Light(getPhaseByLetter(stateSequenceOne.charAt(i))));
            stateRingTwo.enqueue(new Light(getPhaseByLetter(stateSequenceOne.charAt(i))));

        }
    }

    public String getPhaseByLetter(char letter)
    {
        switch (letter) {
            case 'a':
                return "BARRIER";
            case '1':
                return "WBLT";
            case '2':
                return "EB";
            case '3':
                return "NBLT";
            case '4':
                return "SB";
            case '5':
                return "EBLT";
            case '6':
                return "WB";
            case '7':
                return "SBLT"; 
            case '8':
                return "NB";
            default:
                return "invalid phase";
        }

    }

}
