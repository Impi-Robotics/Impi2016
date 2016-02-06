package org.usfirst.frc.team1025.robot.commands.BasketRoller;

import org.usfirst.frc.team1025.robot.ImpiLib;
import org.usfirst.frc.team1025.robot.Robot;
import org.usfirst.frc.team1025.robot.XboxController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Basket_Roller_Joystick_In extends Command {

	private static final double BUTTONS_JOYSTICK_DEADZONE = 0.05;
	
    public Basket_Roller_Joystick_In() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.basketrollerSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	XboxController buttonsController = Robot.oi.getButtonsController();
   	 
        double Speed = ImpiLib.signedSquare(ImpiLib.deadzone(buttonsController.getTriggerL(),BUTTONS_JOYSTICK_DEADZONE));
        
        Robot.basketrollerSubsystem.BasketRollerDrive(-Speed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.basketrollerSubsystem.BasketRollerDrive(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.basketrollerSubsystem.BasketRollerDrive(0.0);
    }
}
