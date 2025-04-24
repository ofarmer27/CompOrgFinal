package src.main.java.traffic.model;

import src.main.java.traffic.interfaces.Queue;
class TrafficSensor
{
    Queue<Integer> carQueue;
    /*
     * This class represents a Traffic Sensor.
     * A traffic sensor uses a queue, adding to the back when needed, allowing cars through at
     * a predetermined speed
     */

     public TrafficSensor()
    {
        carQueue = new Queue<Integer>();
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

    public int[] getQueueAsArray()
    {
        int[] queueArray = new int[carQueue.getNumberOfElements()];
        for (int i = 0; i < queueArray.length; i++)
        {
            queueArray[i] = carQueue.dequeue();
        }

        return queueArray;
    }


}
