package org.usfirst.frc.team1025.robot.commands;


import org.usfirst.frc.team1025.robot.commands.BasketArm.SetBasketArmSetpoint;
import org.usfirst.frc.team1025.robot.commands.BigArm.SetBigArmSetpoint;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BasketArmDown_BigArmDown extends CommandGroup {
    
    public  BasketArmDown_BigArmDown() {
     
    	addParallel(new SetBasketArmSetpoint(10));
    	addParallel(new SetBigArmSetpoint(10));
    }
}
