package org.usfirst.frc.team1025.robot.subsystems;


import org.usfirst.frc.team1025.robot.ImpiLib;
import org.usfirst.frc.team1025.robot.RobotMap;
import org.usfirst.frc.team1025.robot.commands.Catapult.Catapult_Shoot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CatapultReturnSubsystem extends Subsystem {
    
	DigitalInput catapultLimitSwitch; 
	CANTalon catapultMotor;


	public CatapultReturnSubsystem (){
		
		catapultLimitSwitch = new DigitalInput(RobotMap.DIO__CATAPULT_LIMIT_SWITCH);
		catapultMotor = new CANTalon(RobotMap.CAN__CATAPULT_MOTOR);
		
	}
    public void initDefaultCommand() {
    	
     	
    }
    
    public void updateStatus() {
    	
    	
    	SmartDashboard.putData("Catapult Limit Switch", (DigitalInput) catapultLimitSwitch);
   
   }
    
    public void catapultDrive(double Speed){
        double catapultPower = ImpiLib.clamp(Speed, -1.0, 1.0); 
        catapultMotor.set(catapultPower);
    	
    }
    
    
    public boolean isLimitSwitchSet(){
    	
       return catapultLimitSwitch.get();
       
    }
    
    
    public void stop() {
    	
        catapultMotor.set(0.);
   
	}
       
}

