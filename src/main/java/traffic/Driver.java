package src.main.java.traffic;

public class Driver
{
    public static void main(String[] args)
    {
        // LightController myLightController = new LightController();

        // myLightController.startCycle(null);
        TrafficSensor mySensor = new TrafficSensor();

        for (int i = 0; i < 5; i++)
        {
            mySensor.simulateReadSensor();
        }

        int[] what = mySensor.getQueueAsArray();
        for (int i = 0; i < what.length; i++)
        {
            System.out.println(what[i]);
        }



    }
}