import gpio.GPIOPin;
import java.io.IOException;

public class BasicBinary 
{
    private GPIOPin firstPlace;
    private GPIOPin secondPlace;
    private GPIOPin thirdPlace;

    public BasicBinary()
    {
        try
        {
            firstPlace = new GPIOPin("17"); //13th pin on RPP
            firstPlace.setDirection("out");
            secondPlace = new GPIOPin("22"); //15th pin on RPP
            secondPlace.setDirection("out");
            thirdPlace = new GPIOPin("23"); //16th place
            thirdPlace.setDirection("out");
        }
        catch (IOException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void countBinary()
    {
        try
        {
            ///000
            firstPlace.setValue(false);
            secondPlace.setValue(false);
            thirdPlace.setValue(false);
            Thread.sleep(500);

            ///001
            firstPlace.setValue(true);
            secondPlace.setValue(false);
            thirdPlace.setValue(false);
            Thread.sleep(500);

            ///010
            firstPlace.setValue(false);
            secondPlace.setValue(true);
            thirdPlace.setValue(false);
            Thread.sleep(500);

            ///011
            firstPlace.setValue(true);
            secondPlace.setValue(true);
            thirdPlace.setValue(false);
            Thread.sleep(500);

            ///100
            firstPlace.setValue(false);
            secondPlace.setValue(false);
            thirdPlace.setValue(true);
            Thread.sleep(500);

            ///110
            firstPlace.setValue(false);
            secondPlace.setValue(true);
            thirdPlace.setValue(true);
            Thread.sleep(500);

            ///111
            firstPlace.setValue(true);
            secondPlace.setValue(true);
            thirdPlace.setValue(true);
            Thread.sleep(500);

            firstPlace.unexport();
            secondPlace.unexport();
            thirdPlace.unexport();

            System.out.println("Binary count finished.");
        }
        catch (IOException | InterruptedException e)
        {
            System.out.println("Error: "+ e.getMessage());
        }

    }
}
