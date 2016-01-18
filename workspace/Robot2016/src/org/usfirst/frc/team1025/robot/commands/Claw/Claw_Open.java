package org.usfirst.frc.team1025.robot.commands.Claw;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1025.robot.Robot;

public class Claw_Open extends Command {

    public Claw_Open() {
    	requires(Robot.clawSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.clawSubsystem.openClaw();
    }

    protected boolean isFinished() {
         return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
