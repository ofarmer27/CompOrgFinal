package traffic.controller;

// import src.main.java.traffic.interfaces.LinkedCircularQueue;
// import src.main.java.traffic.interfaces.LinkedQueue;
import traffic.model.LightController;

public class Driver
{
    public static void main(String[] args)
    {
        String[] phaseStrings = { "12a34", "56a78" };
        LightController controller = new LightController(phaseStrings);
        controller.startCycle(60);







        
    }
}