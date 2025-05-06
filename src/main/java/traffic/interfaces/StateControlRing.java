package traffic.interfaces;

/* * 2 - Eastbound    5 - EB Left Turn 
     * 4 - Southbound   7 - SB Left Turn 
     * 6 - Westbound    1 - WB Left Turn 
     * 8 - Northbound   3 - NB Left Turn */
public class StateControlRing 
{
    public int numberOfLights;
    public int timer; 

    public SinglePhaseRing[] rings;

    public StateControlRing(String[] stateSequences)
    {
        rings = new SinglePhaseRing[2];
        initializeStateQueues(stateSequences);

    }
    
    public void initializeStateQueues(String[] stateSequences) 
    {
        rings[0] = new SinglePhaseRing();
        rings[1] = new SinglePhaseRing();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < stateSequences[0].length(); j++) {
                rings[0].enqueue(new Light(stateSequences[i].charAt(j)));
            }
        }
    }
    
    public void syncRingsAtNextBarrier()
    {
        for (int i = 0; i < 2; i++)
        {
            while(rings[i].peek().getDirection() != "BARRIER")
            {
                rings[i].cycle();
            }
            rings[i].cycle();
        }
    }

}
