package org.usfirst.frc.team1025.robot.commands.Claw;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1025.robot.Robot;
import org.usfirst.frc.team1025.robot.subsystems.ClawSubsystem;

public class Claw_Toggle extends Command {
	private int newPosition;

    public Claw_Toggle() {
        requires(Robot.clawSubsystem);
        setInterruptible(true);
    }

    protected void initialize() {
    	if (Robot.clawSubsystem.getStatus() == ClawSubsystem.kOpen) {
    		newPosition = ClawSubsystem.kClosed; 
    	} else {
    		newPosition = ClawSubsystem.kOpen;
    	}
    }

    protected void execute() {
    	if (newPosition == ClawSubsystem.kClosed) {
    		Robot.clawSubsystem.closeClaw();
    	} else {
    		Robot.clawSubsystem.openClaw();
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
