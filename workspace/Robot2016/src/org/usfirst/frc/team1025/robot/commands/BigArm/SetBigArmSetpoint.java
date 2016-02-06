package org.usfirst.frc.team1025.robot.commands.BigArm;

import org.usfirst.frc.team1025.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import java.lang.Math;

/**
 *
 */
public class SetBigArmSetpoint extends Command {

	private double setpoint;
	
    public SetBigArmSetpoint(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.setpoint = setpoint;
    	requires(Robot.bigarmSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    	Robot.bigarmSubsystem.enable();
    	Robot.bigarmSubsystem.setSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
     	if (Robot.bigarmSubsystem.onTarget() || Math.abs(Robot.oi.buttonsController.getRightY()) > 0.2) {
    		return true;
    	}
        return false;
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																												
    
    }
}
