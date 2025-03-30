// a traffic light can have a direction (referenced by the TO direction: a north-south road is called south)
// 
public class TrafficLight
{
    String direction; // NSEW
    String color; // R,Y,G

    public TrafficLight(String direction)
    {
        this.color = "red";
        this.direction = direction;
    }

    public String getColor()
    {
        return this.color;
    }

    // setColor
    public void setColor(String color)
    {
        this.color = color;
    }

    // getDirection
    public String getDirection()
    {
        return this.direction;
    }
}