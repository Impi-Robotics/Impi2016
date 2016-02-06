package org.usfirst.frc.team1025.robot.commands.Catapult;

import org.usfirst.frc.team1025.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Catapult_Reload extends Command {

    public Catapult_Reload() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.catapultreturnSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.catapultreturnSubsystem.catapultDriveOn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.catapultreturnSubsystem.catapultDriveOn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
    	if (Robot.catapultreturnSubsystem.isLimitSwitchSet()) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.catapultreturnSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	Robot.catapultreturnSubsystem.stop();
    }
}
