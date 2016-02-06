package org.usfirst.frc.team1025.robot.commands.ClimberArm;

import org.usfirst.frc.team1025.robot.Robot;
import org.usfirst.frc.team1025.robot.XboxController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Climber_Arm_Joystick extends Command {

    public Climber_Arm_Joystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climberarmSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	 XboxController buttonsController = Robot.oi.getButtonsController();
    	
    	 if(buttonsController.getDpad() == 0)
    			 {Robot.climberarmSubsystem.climberArmUp();}
    	 else if (buttonsController.getDpad() == 180)
    		     {Robot.climberarmSubsystem.climberArmDown();}
       
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.climberarmSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	Robot.climberarmSubsystem.stop();
    }
}
