package org.usfirst.frc.team1025.robot.commands;

import org.usfirst.frc.team1025.robot.Robot;
import org.usfirst.frc.team1025.robot.subsystems.AnalogSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PID_BasketArmDown extends Command {

    public PID_BasketArmDown() {
    	requires(Robot.analogSubsystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.analogSubsystem.basketArmDown();
    	Robot.isBasketArmDownCommandRunning = true;
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

    	return Math.abs(Robot.analogSubsystem.getSetpoint()) - Robot.analogSubsystem.getPosition() < 0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.isBasketArmDownCommandRunning = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
