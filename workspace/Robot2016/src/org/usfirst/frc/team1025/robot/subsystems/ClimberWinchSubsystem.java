package org.usfirst.frc.team1025.robot.subsystems;

import org.usfirst.frc.team1025.robot.ImpiLib;
import org.usfirst.frc.team1025.robot.RobotMap;
import org.usfirst.frc.team1025.robot.commands.ClimberWinch.Climber_Winch_Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimberWinchSubsystem extends Subsystem {
    

	Victor climberLeftMotor;
	Victor climberRightMotor;
	

	public ClimberWinchSubsystem (){
		
	
		climberLeftMotor = new Victor(RobotMap.PWM__CLIMBERWINCH__LEFT_MOTOR);
		climberRightMotor = new Victor(RobotMap.PWM__CLIMBERWINCH__RIGHT_MOTOR);
        
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new Climber_Winch_Joystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void updateStatus() {
   	// SmartDashboard.putNumber("Catapult Limit Switch", isSwitchSet());
   	// SmartDashboard.putNumber("Chassis Right Encoder", getRightEncoderDistance());
   }
    
    public void climberDrive(double leftSpeed, double rightSpeed) {
        double leftPower = ImpiLib.clamp(leftSpeed, -1.0, 1.0);
        double rightPower = -ImpiLib.clamp(rightSpeed, -1.0, 1.0);
        climberLeftMotor.set(leftPower);
        climberRightMotor.set(rightPower);
    }
    
    
    
    public void stop() {
        climberLeftMotor.set(0.);
        climberRightMotor.set(0.);	
	}
       
}

