package traffic.interfaces;

public class TrafficSensor
{
    LinkedQueue<Integer> carQueue;
    /*
     * This class represents a Traffic Sensor.
     * A traffic sensor uses a queue, adding to the back when needed, allowing cars through at
     * a predetermined speed
     */

     public TrafficSensor()
    {
        carQueue = new LinkedQueue<Integer>();
    }

    public void simulateReadSensor()
    {
        int sensor = Math.random() < 0.5 ? 1 : 0;
        carQueue.enqueue(sensor);
    }

    public void carPasses()
    {
        carQueue.dequeue();
    }

    public int getQueueLength()
    {
        return carQueue.getNumberOfElements();
    }

}
