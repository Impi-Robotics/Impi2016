package org.usfirst.frc.team1025.robot.commands.BasketArm;

import org.usfirst.frc.team1025.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import java.lang.Math;

/**
 *
 */
public class SetBasketArmSetpoint extends Command {

	private double setpoint;
	
    public SetBasketArmSetpoint(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.setpoint = setpoint;
    	requires(Robot.basketarmSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    	Robot.basketarmSubsystem.enable();
    	Robot.basketarmSubsystem.setSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
     	if (Robot.basketarmSubsystem.onTarget() || Math.abs(Robot.oi.buttonsController.getLeftY()) > 0.2) {
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
