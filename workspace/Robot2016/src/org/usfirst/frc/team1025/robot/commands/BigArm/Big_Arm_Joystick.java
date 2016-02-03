package org.usfirst.frc.team1025.robot.commands.BigArm;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1025.robot.Robot;
import org.usfirst.frc.team1025.robot.XboxController;

/**
 *
 */
public class Big_Arm_Joystick extends Command {

    
    public Big_Arm_Joystick() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.bigarmSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	XboxController buttonsController = Robot.oi.getButtonsController();
    	Robot.bigarmSubsystem.enable();
    	Robot.bigarmSubsystem.setSetpoint((buttonsController.getRightY() + 1.0) * 2.5); //check math
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.bigarmSubsystem.getPIDController().disable();
    	    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	Robot.bigarmSubsystem.getPIDController().disable();
    	
    }
}
