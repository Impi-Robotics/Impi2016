package org.usfirst.frc.team1025.robot.commands.BasketArm;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1025.robot.ImpiLib;
import org.usfirst.frc.team1025.robot.Robot;
import org.usfirst.frc.team1025.robot.XboxController;

/**
 *
 */
public class Basket_Arm_Joystick extends Command {


    
    public Basket_Arm_Joystick() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.basketarmSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	XboxController buttonsController = Robot.oi.getButtonsController();
    	Robot.basketarmSubsystem.enable();
    	Robot.basketarmSubsystem.setSetpoint((buttonsController.getLeftY() + 1.0) * 2.5); //check math
        
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
       	Robot.basketarmSubsystem.getPIDController().disable();
    	
    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
       	Robot.basketarmSubsystem.getPIDController().disable();
    	
    }
}
