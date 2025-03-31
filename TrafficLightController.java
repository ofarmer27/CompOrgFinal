public class TrafficLightController
{
    TrafficLight[][] lights = new TrafficLight[4][2];
    private int[][] lightTimers = new int[4][2];
    private int[][] trafficSensors = new int[4][2];

    int greenLightTime;
    int redLightTime;
    int yellowLightTime;

    String trafficLevel;

    public TrafficLightController()
    {
        // initialize all lights

        lights[0][0] = new TrafficLight("NORTH"); // NORTH
        lights[0][1] = new TrafficLight("NORTH");

        lights[1][0] = new TrafficLight("SOUTH"); // SOUTH
        lights[1][1] = new TrafficLight("SOUTH");

        lights[2][0] = new TrafficLight("EAST"); // EAST
        lights[2][1] = new TrafficLight("EAST");

        lights[3][0] = new TrafficLight("WEST"); // WEST
        lights[3][1] = new TrafficLight("WEST");
    }

    public void startCycle()
    {

        setLights("NORTH", "SOUTH", "green");

        while (true)
        {
            readSensors();

            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    updateLight(i, j);
                }
            }

            testPrint();

            waitFor(1);
        }
    }

    private void updateLight(int streetIndex, int laneIndex)
    {
        lightTimers[streetIndex][laneIndex]++;

        if (trafficSensors[streetIndex][laneIndex] == 1)
        {
            if (lights[streetIndex][laneIndex].getColor().equals("green"))
            {
                if (lightTimers[streetIndex][laneIndex] >= greenLightTime)
                {
                    lights[streetIndex][laneIndex].setColor("yellow");
                    lightTimers[streetIndex][laneIndex] = 0;
                }
            } else if (lights[streetIndex][laneIndex].getColor().equals("yellow"))
            {
                if (lightTimers[streetIndex][laneIndex] >= yellowLightTime)
                {
                    lights[streetIndex][laneIndex].setColor("red");
                    lightTimers[streetIndex][laneIndex] = 0;
                }
            } else if (lights[streetIndex][laneIndex].getColor().equals("red"))
            {
                if (lightTimers[streetIndex][laneIndex] >= redLightTime)
                {
                    lights[streetIndex][laneIndex].setColor("green");
                    lightTimers[streetIndex][laneIndex] = 0;
                }
            }
            trafficLevel = "traffic level: high";
        } else
        {
            if (lights[streetIndex][laneIndex].getColor().equals("green"))
            {
                if (lightTimers[streetIndex][laneIndex] >= greenLightTime)
                {
                    lights[streetIndex][laneIndex].setColor("yellow");
                    lightTimers[streetIndex][laneIndex] = 0;
                }
            } else if (lights[streetIndex][laneIndex].getColor().equals("yellow"))
            {
                if (lightTimers[streetIndex][laneIndex] >= yellowLightTime)
                {
                    lights[streetIndex][laneIndex].setColor("red");
                    lightTimers[streetIndex][laneIndex] = 0;
                }
            } else if (lights[streetIndex][laneIndex].getColor().equals("red"))
            {
                if (lightTimers[streetIndex][laneIndex] >= redLightTime)
                {
                    lights[streetIndex][laneIndex].setColor("green");
                    lightTimers[streetIndex][laneIndex] = 0;
                }
            }
            trafficLevel = "traffic level: low";
        }

        System.out.println(trafficLevel);
    }

    public void setLights(String dir1, String dir2, String color)
    {
        for (int i = 0; i < lights.length; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                if (lights[i][j].getDirection().contains(dir1) || lights[i][j].getDirection().contains(dir2))
                {
                    lights[i][j].setColor(color);
                }
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
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                System.out.println(lights[i][j].getDirection() + " ==> " + lights[i][j].getColor());
            }
        }

        System.out.println("--------------------");
    }

    public void setLightTimers(int redLightTime, int yellowLightTime, int greenLightTime)
    {
        this.greenLightTime = greenLightTime;
        this.redLightTime = redLightTime;
        this.yellowLightTime = yellowLightTime;
    }

    private void readSensors()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                if (lights[i][j].getColor().equals("green"))
                {
                    trafficSensors[i][j] = Math.random() < 0.7 ? 1 : 0;
                }
            }
        }
    }

}