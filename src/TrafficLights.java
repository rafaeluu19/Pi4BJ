import gpio.GPIOPin;
import java.io.IOException;

public class TrafficLights 
{
    private GPIOPin pinG;
    private GPIOPin pinY;
    private GPIOPin pinR; 
    
    public TrafficLights()
    {
        try 
        {
            pinG = new GPIOPin("17"); // 13th pin on RPP
            pinG.setDirection("out");
            pinY = new GPIOPin("22"); // 15th pin on RPP
            pinY.setDirection("out");
            pinR = new GPIOPin("23"); // 16th pin on RPP
            pinR.setDirection("out");
        } 
        catch (IOException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void blinkTrafficLights()
    {
        try
        {
            System.out.println("Turning Green Light ON and OFF...");
            pinG.setValue(true); // LED ON
            pinG.pause(0); // Wait 1 second
            pinG.setValue(false); // LED OFF
            pinG.pause(0); // Wait 1 second

            System.out.println("Turning Yellow Light ON and OFF...");
            pinY.setValue(true); // LED ON
            pinY.pause(0); // Wait 1 second
            System.out.println("Turning OFF the LED...");
            pinY.setValue(false); // LED OFF
            pinY.pause(0); // Wait 1 second


            System.out.println("Turning Red Light ON and OFF...");
            pinR.setValue(true); // LED ON
            pinR.pause(0); // Wait 1 second
            System.out.println("Turning OFF the LED...");
            pinR.setValue(false); // LED OFF
            pinR.pause(0); // Wait 1 second

            pinG.unexport(); // Clean up
            pinY.unexport(); // Clean up
            pinR.unexport(); // Clean up
            System.out.println("GPIO pins unexported.");
        }
        catch (IOException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }  
    
    public void loopTrafficLights()
    {
        for(int i = 0; i < 10; i++)
        {
            try
            {
                System.out.println("Turning Green Light ON and OFF...");
                pinG.setValue(true); // LED ON
                pinG.pause(0); // Wait 1 second
                pinG.setValue(false); // LED OFF
                pinG.pause(0); // Wait 1 second

                System.out.println("Turning Yellow Light ON and OFF...");
                pinY.setValue(true); // LED ON
                pinY.pause(0); // Wait 1 second
                System.out.println("Turning OFF the LED...");
                pinY.setValue(false); // LED OFF
                pinY.pause(0); // Wait 1 second


                System.out.println("Turning Red Light ON and OFF...");
                pinR.setValue(true); // LED ON
                pinR.pause(0); // Wait 1 second
                System.out.println("Turning OFF the LED...");
                pinR.setValue(false); // LED OFF
                pinR.pause(0); // Wait 1 second
            }
            catch (IOException e) 
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
        try
        {
            pinG.unexport(); // Clean up
            pinY.unexport(); // Clean up
            pinR.unexport(); // Clean up
            System.out.println("GPIO pins unexported.");
        }
        catch (IOException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}