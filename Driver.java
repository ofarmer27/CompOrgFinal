
public class Driver
{
    public static void main(String[] args)
    {
        TrafficLightController trafficLightController = new TrafficLightController();
        trafficLightController.setLightTimers(30, 5, 30);
        trafficLightController.startCycle();

    }
}