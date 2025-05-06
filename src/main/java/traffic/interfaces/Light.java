package traffic.interfaces;

// a traffic light can have a direction (referenced by the TO direction: a north-south road is called south)
// 
public class Light
{
    String direction; // N,S,E,W
    String color; // R,Y,G
    char ID; 
    
    TrafficSensor sensor;


    // default traffic light is red.
    public Light(char ID)
    {
        sensor = new TrafficSensor();

        this.ID = ID; 
        this.color = "red";
        setDirectionByLetter(ID);
        
    }

    // return color "state" of the light. Red, Yellow, or Green
    public String getColor()
    {

        return this.color;
    }

    public char getID()
    {
        return this.ID; 
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

    private void setDirectionByLetter(char letter)
    {
        this.direction = getDirectionByLetter(letter);
    } 

    private String getDirectionByLetter(char letter)
    {
        switch (letter) {
            case 'a':
                return "BARRIER";
            case '1':
                return "WBLT";
            case '2':
                return "EB";
            case '3':
                return "NBLT";
            case '4':
                return "SB";
            case '5':
                return "EBLT";
            case '6':
                return "WB";
            case '7':
                return "SBLT";
            case '8':
                return "NB";
            default:
                return "invalid phase";
        }

    }
    
    public void simulateTraffic()
    {
        sensor.simulateReadSensor();
    }

}