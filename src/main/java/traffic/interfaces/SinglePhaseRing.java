package src.main.java.traffic.interfaces;

public class SinglePhaseRing 
    extends LinkedCircularQueue<Light>
{

    public SinglePhaseRing()
    {

    }

    public char determinePriority()
    {
        if (peek().sensor.getQueueLength() < peekNext().sensor.getQueueLength()) {
            // Priority is next Light, cycle
            return peekNext().getID();
        } else {
            return peek().getID();
            // Priority is current, extend by x 
        }

    }


}