package org.usfirst.frc.team1025.robot.subsystems;

import org.usfirst.frc.team1025.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ClawSubsystem extends Subsystem {
    
	private DoubleSolenoid claw;
	private int currentStatus;
			
	public static final int kClosed = 0;
	public static final int kOpen = 1;
	
	public ClawSubsystem(){
		claw  = new DoubleSolenoid(RobotMap.PCM_MODULE_NUMBER, RobotMap.PCM__CLAW__CLAW_FORWARD, RobotMap.PCM__CLAW__CLAW_REVERSE);
	}

    public void initDefaultCommand() {
    }
	
    public void updateStatus() {
        // SmartDashboard.putNumber("Claw Status",  currentStatus);
    }
	
	public void openClaw() {
		claw.set(DoubleSolenoid.Value.kReverse);
		currentStatus = kOpen;
	}
	
	public void closeClaw() {
		claw.set(DoubleSolenoid.Value.kForward);
		currentStatus = kClosed;
	}
	
	public int getStatus() {
		return currentStatus;
	}
}
