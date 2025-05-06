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
        rings[0] = new SinglePhaseRing();
        rings[1] = new SinglePhaseRing();
        initializeStateQueues(stateSequences);

    }
    
    public void initializeStateQueues(String[] stateSequences) 
    {
        for (int i = 0; i < 2; i++) 
        {
            for (int j = 0; j < stateSequences[i].length(); j++) 
            {
                rings[i].enqueue(new Light(stateSequences[i].charAt(j)));
            }
        }
    }
    
    public void syncRingsAfterNextBarrier()
    {
        for (int i = 0; i < 2; i++) {
            while (rings[i].peek().getDirection() != "BARRIER") {
                rings[i].cycle();
            }
            rings[i].cycle();
        }
    }
    
    public void printRingQueues()
    {
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < rings[i].getNumberOfElements(); j++ )
            {
                String color = rings[i].peek().getColor();
                String direction = rings[i].peek().getDirection();
                System.out.printf("Direction: %s\t\tColor %s\n", direction, color);
                rings[i].cycle();
            }
            System.out.println();
        }
    }

}
