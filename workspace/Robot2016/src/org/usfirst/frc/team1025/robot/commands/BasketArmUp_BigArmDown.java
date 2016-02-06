package org.usfirst.frc.team1025.robot.commands;


import org.usfirst.frc.team1025.robot.commands.BasketArm.SetBasketArmSetpoint;
import org.usfirst.frc.team1025.robot.commands.BigArm.SetBigArmSetpoint;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BasketArmUp_BigArmDown extends CommandGroup {
    
    public  BasketArmUp_BigArmDown() {
     
    	addParallel(new SetBasketArmSetpoint(10));
    	addParallel(new SetBigArmSetpoint(-30));
    }
}
