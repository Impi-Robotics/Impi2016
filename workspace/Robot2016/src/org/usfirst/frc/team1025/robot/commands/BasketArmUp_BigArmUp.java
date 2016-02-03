package org.usfirst.frc.team1025.robot.commands;


import org.usfirst.frc.team1025.robot.commands.BasketArm.SetBasketArmSetpoint;
import org.usfirst.frc.team1025.robot.commands.BigArm.SetBigArmSetpoint;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BasketArmUp_BigArmUp extends CommandGroup {
    
    public  BasketArmUp_BigArmUp() {
    
    	addParallel(new SetBasketArmSetpoint(-30));
    	addParallel(new SetBigArmSetpoint(-30));
    }
}
