#Pi4BJ GPIO Library

This is a simple Java library that allows control of GPIO (General Purpose Input/Output) pins on a Raspberry Pi using the Linux sysfs interface. It is designed to be used in an educational setting with BlueJ. 

Features include
Export a GPIO pin for use
Setting pin direction (‘in’ or ‘out’)
Set output value (‘true’ for high, ‘false’ for low)
Unexport pin (reset the Raspberry Pi pins)
Handles basi file I/O exceptions and permission error

Installation
Place the ‘GPIOPin.java’ file inside the ‘gpio’ package.
Place the ‘gpio’ package in the same folder as the BlueJ project folder. 
Add the ‘gpio’ package and compile ‘GPIOPin.java’. 
