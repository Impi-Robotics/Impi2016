package org.usfirst.frc.team1025.robot.commands.Autonomous;

import org.usfirst.frc.team1025.robot.commands.Chassis.Chassis_DriveDistanceDumb;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_Drive_Forward extends CommandGroup {
    
    public  Auto_Drive_Forward() {
    	addSequential(new Chassis_DriveDistanceDumb(.5,120));
        
    }
}
