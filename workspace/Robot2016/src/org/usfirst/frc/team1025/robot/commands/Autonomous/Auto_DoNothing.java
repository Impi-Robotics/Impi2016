package org.usfirst.frc.team1025.robot.commands.Autonomous;

import org.usfirst.frc.team1025.robot.commands.Chassis.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto_DoNothing extends CommandGroup {
    
    public  Auto_DoNothing() {
    	addSequential(new Chassis_DriveTimed(0., 0.));
    }
}
