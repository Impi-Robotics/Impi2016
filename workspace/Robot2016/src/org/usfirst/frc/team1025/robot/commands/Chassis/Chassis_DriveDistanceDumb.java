package org.usfirst.frc.team1025.robot.commands.Chassis;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1025.robot.Robot;

public class Chassis_DriveDistanceDumb extends Command {
    
    private double speed;
    private double distance;
    
    public Chassis_DriveDistanceDumb(double speed, double distance) {
        requires(Robot.chassisSubsystem);
        setInterruptible(true);
        
        this.speed = speed;
        this.distance = distance;
    }

    protected void initialize() {
    	
        Robot.chassisSubsystem.resetEncoders();
    }

    protected void execute() {
    	
        Robot.chassisSubsystem.simpleDrive(speed, speed);
    }

    protected boolean isFinished() {
    	
    	return (Math.abs(Robot.chassisSubsystem.getLeftEncoderDistance() + Math.abs(Robot.chassisSubsystem.getRightEncoderDistance())/2) > Math.abs(distance));
    }

    protected void end() {
    	
        Robot.chassisSubsystem.stop();
    }

    protected void interrupted() {
    	
    	Robot.chassisSubsystem.stop();
    }
}