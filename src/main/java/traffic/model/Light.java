package src.main.java.traffic.model;


// a traffic light can have a direction (referenced by the TO direction: a north-south road is called south)
// 
class Light
{
    String direction; // N,S,E,W
    String color; // R,Y,G
    
    TrafficSensor sensor;


    // default traffic light is red.
    public Light(String direction)
    {
        sensor = new TrafficSensor();
        
        this.color = "red";
        this.direction = direction;
    }

    // return color "state" of the light. Red, Yellow, or Green
    public String getColor()
    {

        return this.color;
    }

    // sets color or "state" of the light. Red, Yellow, or Green
    public void setColor(String color)
    {
        this.color = color;
    }

    
    public String getDirection()
    {
        return this.direction;
    }

    public void simulateReadSensor()
    {
        sensor.simulateReadSensor();
    }


}