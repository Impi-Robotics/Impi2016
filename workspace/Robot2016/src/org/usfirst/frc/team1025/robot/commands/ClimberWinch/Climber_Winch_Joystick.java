package org.usfirst.frc.team1025.robot.commands.ClimberWinch;


import org.usfirst.frc.team1025.robot.Robot;
import org.usfirst.frc.team1025.robot.XboxController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Climber_Winch_Joystick extends Command {

    public Climber_Winch_Joystick() {
      
    	requires(Robot.climberwinchSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
     
    }

    protected void execute() {
    	
    	XboxController driverController = Robot.oi.getDriverController();
    	
       	if (driverController.getRawButton(5) && (driverController.getRawButton(6)))
    	{Robot.climberwinchSubsystem.climberDrive(1.0,1.0);}
    	else {Robot.climberwinchSubsystem.climberDrive(0.,0.);}

    }

    protected boolean isFinished() {
    	
    	return false;
    
    }


    protected void end() {
    	
    	Robot.catapultreturnSubsystem.stop();
    	
    	
    }

    protected void interrupted() {
    	
    	Robot.catapultreturnSubsystem.stop();
   
    }
}
