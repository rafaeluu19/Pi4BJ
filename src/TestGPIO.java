import gpio.GPIOPin;
import java.io.IOException;

public class TestGPIO 
{
    private GPIO pin;

    public TestGPIO()
    {
        try
        {
            pin = new GPIOPin("17");
            pin.setDirection("Out");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void blink()
    {
        try
        {
            System.out.println("Turning ON the LED");
            pin.setValue(true);
            System.out.println("Turning OFF the LED");
            pin.setValue(false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void cleanUp()
    {
        try
        {
            pin.unexport();
        }
        catch (Exception e)
        {
            e.printStackTrace();    
        }
    }
}
