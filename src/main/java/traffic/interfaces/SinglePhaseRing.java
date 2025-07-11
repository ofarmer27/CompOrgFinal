package traffic.interfaces;

public class SinglePhaseRing 
    extends LinkedCircularQueue<Light>
{

    public String determinePriority()
    {
        if (peek().sensor.getQueueLength() < peekNext().sensor.getQueueLength()) {
            // Priority is next Light, cycle
            return peekNext().getDirection();
        } else {
            return peek().getDirection();
            // Priority is current, extend by x 
        }

    }


}