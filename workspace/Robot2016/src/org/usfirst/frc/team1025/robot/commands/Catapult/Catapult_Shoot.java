package org.usfirst.frc.team1025.robot.commands.Catapult;

import org.usfirst.frc.team1025.robot.Robot;
import org.usfirst.frc.team1025.robot.XboxController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Catapult_Shoot extends Command {

    public Catapult_Shoot() {
      
    	requires(Robot.catapultreturnSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
     
    }

    protected void execute() {
    	
    	XboxController driverController = Robot.oi.getDriverController();
    	
       	if ((Math.abs(driverController.getTriggerL()) > 0.2) && ((Math.abs(driverController.getTriggerR()) > 0.)))
    	{Robot.catapultreturnSubsystem.catapultDriveOn();}
    	else {Robot.catapultreturnSubsystem.stop();}

    }

    protected boolean isFinished() {
    	
    	if (Robot.catapultreturnSubsystem.isLimitSwitchSet()){
    		return true;
    	}
        return false;
    
    }


    protected void end() {
    	
    	Robot.catapultreturnSubsystem.stop();
    	
    	
    }

    protected void interrupted() {
    	
    	Robot.catapultreturnSubsystem.stop();
   
    }
}
