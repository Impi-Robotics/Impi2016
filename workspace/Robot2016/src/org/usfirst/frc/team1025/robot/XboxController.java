

package org.usfirst.frc.team1025.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XboxController extends Joystick {
    public Button buttonA;
    public Button buttonB;
    public Button buttonX;
    public Button buttonY;
    public Button buttonLeft;
    public Button buttonRight;
    public Button buttonSelect;
    public Button buttonStart;
    public Button buttonLeftStick;
    
    
    public Button buttonRightStick;
    
    public XboxController(int port) {
    	
        super(port);
    
        buttonA = new JoystickButton(this, 1);
        buttonB = new JoystickButton(this, 2);
        buttonX = new JoystickButton(this, 3);
        buttonY = new JoystickButton(this, 4);
        buttonLeft = new JoystickButton(this, 5);
        buttonRight = new JoystickButton(this, 6);
        buttonSelect = new JoystickButton(this, 7);
        buttonStart = new JoystickButton(this, 8);
        buttonLeftStick = new JoystickButton(this, 9);
        buttonRightStick = new JoystickButton(this, 10);
    }
    
      
   
    public double getLeftX() { //good
        return getRawAxis(0);
    }
    
    public double getLeftY() { //good
        return getRawAxis(1);
    }
    

    public double getRightX() { //good
        return getRawAxis(4);
    }
    
    public double getRightY() { //good 
        return getRawAxis(5);
    }
    
    public int getDpad() { //good
        return getPOV();  // THIS RETURNS AN ANGLE, IS -1 WHEN NOT PRESSED
    }
    
    public double getTriggerL() { //good //WAS 3, CHANGED TO 4 1/30/16, FIX
        return getRawAxis(4);
    }
    public double getTriggerR() { //good 
    	return getRawAxis(3);
    }
    
    //Mecanum Drive Polar
    
    public double getLeftStickMagnitude() {
    	return Math.sqrt(Math.pow(getRawAxis(0), 2) + Math.pow(getRawAxis(1), 2));
    }
    	
    public double getLeftStickDirectionRadians() {
    	return Math.atan2(getRawAxis(0), -getRawAxis(1));
    }
    
    public double getLeftStickDirectionDegrees() {
    	return Math.toDegrees(getLeftStickDirectionRadians());
    }

}
