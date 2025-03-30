public class TrafficLightController
{
    TrafficLight[] lights = new TrafficLight[8];
    public String trafficLevel;

    public TrafficLightController()
    {
        trafficLevel = "low";

        lights[0] = new TrafficLight("NORTH-1");
        lights[1] = new TrafficLight("NORTH-2");
        lights[2] = new TrafficLight("SOUTH-1");
        lights[3] = new TrafficLight("SOUTH-2");
        lights[4] = new TrafficLight("EAST-1");
        lights[5] = new TrafficLight("EAST-2");
        lights[6] = new TrafficLight("WEST-1");
        lights[7] = new TrafficLight("WEST-2");
    }

    // runs on timer
    public void highTrafficCycle()
    {
        while (trafficLevel == "HIGH")
        {
            // NORTH SOUTH TRAFFIC

            // set north and south green
            setLights("NORTH-1", "NORTH-2", "green");
            setLights("SOUTH-1", "SOUTH-2", "green");

            // set east and west red
            setLights("EAST-1", "EAST-2", "red");
            setLights("WEST-1", "WEST-2", "red");
            testPrint();
            waitFor(45); // 58 sec wait

            // begin 4 sec north south yellow
            setLights("NORTH-1", "NORTH-2", "yellow");
            setLights("SOUTH-1", "SOUTH-2", "yellow");

            testPrint();
            waitFor(4);

            // set north south red
            setLights("NORTH-1", "NORTH-2", "red");
            setLights("SOUTH-1", "SOUTH-2", "red");

            // BEGIN EAST WEST TRAFFIC

            // set east west green
            setLights("EAST-1", "EAST-2", "green");
            setLights("WEST-1", "WEST-2", "green");

            testPrint();
            waitFor(45);

            // begin east west yellow
            testPrint();
            setLights("EAST-1", "EAST-2", "yellow");
            setLights("WEST-1", "WEST-2", "yellow");
            waitFor(4);

        }

    }

    // runs on sensor
    public void lowTrafficCycle()
    {
        while (trafficLevel == "LOW")
        {

        }

    }

    public void setLights(String dir1, String dir2, String color)
    {
        for (int i = 0; i < lights.length; i++)
        {
            if (lights[i].getDirection().contains(dir1) || lights[i].getDirection().contains(dir2))
            {
                lights[i].setColor(color);
            }

        }
    }

    public void waitFor(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void testPrint()
    {
        for (int i = 0; i < lights.length; i++)
        {
            System.out.println(lights[i].getDirection() + " --> " + lights[i].getColor());

        }

        System.out.println("waiting");
        System.out.println("--------------------");
    }
}