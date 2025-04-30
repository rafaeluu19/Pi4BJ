package gpio;

import java.io.*;

public class GPIOPin {
    private final String pin;

    public GPIOPin(String pin) throws IOException 
    {
        this.pin = pin;
        exportPin();
    }

    //Enables GPIO pin (if not already exported)
    private void exportPin() throws IOException 
    {
        if (!new File("/sys/class/gpio/gpio" + pin).exists()) 
        {
            writeToFile("/sys/class/gpio/export", pin);
        }
        else
        {
            File directionFile = new File("/sys/class/gpio/gpio"+pin,"direction");
            if (!directionFile.canWrite())
            {
                throw new IOException("Permission denied for GPIO"+pin+"-try running as root or check if it's in use.");
            }
        }
    }

    //Sets "in" or "out mode"
    public void setDirection(String direction) throws IOException 
    {
        writeToFile("/sys/class/gpio/gpio" + pin + "/direction", direction);
    }

    //Sends high or low (true = 1, false = 0)
    public void setValue(boolean on) throws IOException 
    {
        writeToFile("/sys/class/gpio/gpio" + pin + "/value", on ? "1" : "0");
    }

    //Handles writing to Linux GPIO control files
    private void writeToFile(String path, String value) throws IOException 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) 
        {
            writer.write(value);
        }
    }

    //Cleans up the pin after use
    public void unexport() throws IOException 
    {
        writeToFile("/sys/class/gpio/unexport", pin);
    }
    
    //Returns the String value for the pin
    public String getPin() throws IOException
    {
        return pin;
    }
}
