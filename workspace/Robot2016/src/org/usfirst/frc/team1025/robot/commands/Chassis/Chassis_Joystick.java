package org.usfirst.frc.team1025.robot.commands.Chassis;


import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1025.robot.Robot;
import org.usfirst.frc.team1025.robot.ImpiLib;
import org.usfirst.frc.team1025.robot.XboxController;

public class Chassis_Joystick extends Command {
    
    private static final double DRIVER_JOYSTICK_DEADZONE = 0.05;

    public Chassis_Joystick() {
        requires(Robot.chassisSubsystem);
    }

    protected void initialize() {
    }
    
    protected void execute() {
    	 	 
      XboxController driverController = Robot.oi.getDriverController();
 
            double straightAxis = ImpiLib.signedSquare(ImpiLib.deadzone(driverController.getLeftY(),DRIVER_JOYSTICK_DEADZONE));
            double turnAxis = ImpiLib.signedSquare(ImpiLib.deadzone(driverController.getRightX(),DRIVER_JOYSTICK_DEADZONE));
            
         
            Robot.chassisSubsystem.haloDrive(straightAxis,turnAxis);
        
       
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.chassisSubsystem.simpleDrive(0.0, 0.0);
    }

    protected void interrupted() {
        Robot.chassisSubsystem.simpleDrive(0.0, 0.0);
    }
}
