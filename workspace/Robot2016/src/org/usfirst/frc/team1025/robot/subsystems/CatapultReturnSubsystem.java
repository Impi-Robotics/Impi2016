package org.usfirst.frc.team1025.robot.subsystems;


import org.usfirst.frc.team1025.robot.RobotMap;
import org.usfirst.frc.team1025.robot.commands.Catapult.Catapult_Shoot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CatapultReturnSubsystem extends Subsystem {
    
	DigitalInput catapultLimitSwitch; 
	Relay catapultMotor;


	public CatapultReturnSubsystem (){
		
		catapultLimitSwitch = new DigitalInput(RobotMap.DIO__CATAPULT_LIMIT_SWITCH);
		catapultMotor = new Relay(RobotMap.DIO__CATAPULT_MOTOR);
		
	}
    public void initDefaultCommand() {
     	setDefaultCommand(new Catapult_Shoot());
    }
    
    public void updateStatus() {
   	// SmartDashboard.putNumber("Catapult Limit Switch", isSwitchSet());
   	// SmartDashboard.putNumber("Chassis Right Encoder", getRightEncoderDistance());
   }
    
    public void catapultDriveOn() {
    	
    	catapultMotor.set(Relay.Value.kOn);
    	   
    }
    
    
    public boolean isLimitSwitchSet(){
       return catapultLimitSwitch.get();
    }
    
    
    public void stop() {
    	
        catapultMotor.set(Relay.Value.kOff);
   
	}
       
}

