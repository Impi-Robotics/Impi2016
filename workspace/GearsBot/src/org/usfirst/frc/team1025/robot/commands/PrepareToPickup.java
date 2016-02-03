package org.usfirst.frc.team1025.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Make sure the robot is in a state to pickup soda cans. 
 */
public class PrepareToPickup extends CommandGroup {
    public  PrepareToPickup() {
        addParallel(new OpenClaw());
        addParallel(new SetWristSetpoint(0));
        addSequential(new SetElevatorSetpoint(0));
    }
}
