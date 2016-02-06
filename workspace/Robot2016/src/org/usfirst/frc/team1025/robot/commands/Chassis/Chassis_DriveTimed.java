package org.usfirst.frc.team1025.robot.commands.Chassis;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1025.robot.Robot;

public class Chassis_DriveTimed extends Command {
	
	private double speed;
	private double time;
	private Timer timer;

    public Chassis_DriveTimed(double speed, double time) {
        requires(Robot.chassisSubsystem);
        
        this.speed = speed;
        this.time = time;
        timer = new Timer();
    }

    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    protected void execute() {
        Robot.chassisSubsystem.simpleDrive(speed, speed);
    }

    protected boolean isFinished() {
    	return (timer.get() > time);
    }

    protected void end() {
    	Robot.chassisSubsystem.stop();
    }

    protected void interrupted() {
    	Robot.chassisSubsystem.stop();
    }
}
