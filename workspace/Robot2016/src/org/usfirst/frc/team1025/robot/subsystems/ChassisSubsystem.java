package org.usfirst.frc.team1025.robot.subsystems;

import org.usfirst.frc.team1025.robot.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team1025.robot.commands.Chassis.Chassis_Joystick;
import org.usfirst.frc.team1025.robot.ImpiLib;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class ChassisSubsystem extends Subsystem {
		
	    private Talon frontLeftMotor;
	    private Talon rearLeftMotor;
	    private Talon frontRightMotor;
	    private VictorSP  rearRightMotor;
	    public RobotDrive robotDrive;
	    
	   
	
	public ChassisSubsystem (){
		
		
		frontLeftMotor  = new Talon(RobotMap.PWM__CHASSIS__LEFT_FRONT_MOTOR);
        rearLeftMotor   = new Talon(RobotMap.PWM__CHASSIS__LEFT_REAR_MOTOR);
        frontRightMotor = new Talon(RobotMap.PWM__CHASSIS__RIGHT_FRONT_MOTOR);
        rearRightMotor  = new VictorSP(RobotMap.PWM__CHASSIS__RIGHT_REAR_MOTOR);
        
        robotDrive = new RobotDrive(frontLeftMotor,rearLeftMotor,frontRightMotor,rearRightMotor);
        
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight,true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight,true);
        
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new Chassis_Joystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void updateStatus() {
        
    }
    
    public void simpleDrive(double leftSpeed, double rightSpeed) {
        double leftPower = ImpiLib.clamp(leftSpeed, -1.0, 1.0);
        double rightPower = -ImpiLib.clamp(rightSpeed, -1.0, 1.0);
        frontLeftMotor.set(leftPower);
        rearLeftMotor.set(leftPower);
        frontRightMotor.set(rightPower);
        rearRightMotor.set(rightPower);
    }
    

	public void haloDrive(double straightAxis, double turnAxis) {
        double leftPower = straightAxis + turnAxis;
        double rightPower = straightAxis - turnAxis;
        simpleDrive(leftPower, rightPower);
		// TODO Auto-generated method stub
		
	}
    
    public void arcadeDrive(double y, double rotation) {
    	robotDrive.arcadeDrive(y, rotation);
    }
	
	public void mecanumDrive_Polar(double magnitude, double direction, double rotation) {
		robotDrive.mecanumDrive_Polar(magnitude, direction, rotation);
	}

	public void mecanumDrive_Cartesian(double x, double y, double rotation, double gyro) {
		robotDrive.mecanumDrive_Cartesian(x, y, rotation, gyro);
	}

	public void stop() {
        frontLeftMotor.set(0.);
        frontRightMotor.set(0.);
        rearLeftMotor.set(0.);
        rearRightMotor.set(0.);		
	}



}

