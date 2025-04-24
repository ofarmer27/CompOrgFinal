package src.main.java.traffic.model;


// a traffic light can have a direction (referenced by the TO direction: a north-south road is called south)
// 
class Light
{
    String direction; // N,S,E,W
    String color; // R,Y,G

    // default traffic light is red.
    public Light(String direction)
    {
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

    // gets the direction of the light. This will return the irection that the
    // street is going towards.
    // light direction cannot be changed after initialization.
    public String getDirection()
    {
        return this.direction;
    }

}