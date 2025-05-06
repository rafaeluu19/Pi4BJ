
import gpio.GPIOPin;
import java.io.IOException;

public class TestBlink 
{
    private GPIOPin pin; 
    
    public TestBlink()
    {
        try 
        {
            pin = new GPIOPin("17"); // BCM pin 17
            pin.setDirection("out");
        } 
        catch (IOException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void blinkLights()
    {
        try
        {
            System.out.println("Turning ON the LED...");
            pin.setValue(true); // LED ON
            Thread.sleep(1000); // Wait 1 second

            System.out.println("Turning OFF the LED...");
            pin.setValue(false); // LED OFF

            pin.unexport(); // Clean up
            System.out.println("GPIO pin unexported.");
        }
        catch (IOException | InterruptedException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }    
}