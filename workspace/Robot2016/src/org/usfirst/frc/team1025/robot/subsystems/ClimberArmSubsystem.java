package org.usfirst.frc.team1025.robot.subsystems;

import org.usfirst.frc.team1025.robot.ImpiLib;
import org.usfirst.frc.team1025.robot.RobotMap;
import org.usfirst.frc.team1025.robot.commands.ClimberArm.Climber_Arm_Joystick;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimberArmSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor climberMotor;
	
	public ClimberArmSubsystem(){
		climberMotor = new Victor(RobotMap.PWM__CLIMBER_MOTOR);
		
	}
	
	public void climberDrive(double speed) {
        double outputSpeed = ImpiLib.clamp(speed, -1.0, 1.0);
        climberMotor.set(outputSpeed);
    }
	
	public void climberArmUp(){
	 climberMotor.set(1.);
	}
	
	public void climberArmDown(){
	 climberMotor.set(-1.);
	}
	
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Climber_Arm_Joystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void updateStatus() {
   	// SmartDashboard.putNumber("Chassis Left Encoder", getLeftEncoderDistance());
   	// SmartDashboard.putNumber("Chassis Right Encoder", getRightEncoderDistance());
   }
    
    public void stop() {
        climberMotor.set(0.);
      
 	}
}

