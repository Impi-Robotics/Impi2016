package org.usfirst.frc.team1025.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1025.robot.ImpiLib;
import org.usfirst.frc.team1025.robot.RobotMap;
import org.usfirst.frc.team1025.robot.commands.BasketRoller.Basket_Roller_Joystick_In;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;


/**
 *
 */
public class BasketRollerSubsystem extends Subsystem {
	
		private Victor BasketRollerMotor;
	
	public BasketRollerSubsystem(){
		
		BasketRollerMotor = new Victor (RobotMap.PWM__BASKETROLLER__MOTOR);
	 }
    
    

    public void initDefaultCommand() {
    	
    setDefaultCommand(new Basket_Roller_Joystick_In());
    	
     }
    
    public void updateStatus() {
       
    	SmartDashboard.putData("Basket Roller", (Victor) BasketRollerMotor);
      }
    
    public void basketRollerDrive(double Speed){
        double rollerPower = ImpiLib.clamp(Speed, -1.0, 1.0); 
        BasketRollerMotor.set(rollerPower);
    	
      }
    public void stop(){
    	
    	BasketRollerMotor.set(0.);
      }

    }

