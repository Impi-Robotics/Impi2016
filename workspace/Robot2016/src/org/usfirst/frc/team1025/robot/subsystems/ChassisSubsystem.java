package org.usfirst.frc.team1025.robot.subsystems;

import org.usfirst.frc.team1025.robot.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team1025.robot.commands.Chassis.Chassis_Joystick;
import org.usfirst.frc.team1025.robot.ImpiLib;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ChassisSubsystem extends Subsystem {
		
	    private Talon frontLeftMotor;
	    private Victor rearLeftMotor;
	    private Talon frontRightMotor;
	    private Victor  rearRightMotor;
	    public RobotDrive robotDrive;
		
		private Encoder leftEncoder;
		private Encoder rightEncoder;
	    
		private static final double DRIVE_WHEEL_DIAMETER = 6.0;
		private static final double ENCODER_CYCLES_PER_REV = 250.0;
		private static final double DRIVE_ENCODER_INCH_PER_PULSE = (DRIVE_WHEEL_DIAMETER * 3.141592 / ENCODER_CYCLES_PER_REV);
	
	public ChassisSubsystem (){
		
		
		frontLeftMotor  = new Talon(RobotMap.PWM__CHASSIS__LEFT_FRONT_MOTOR);
        rearLeftMotor   = new Victor(RobotMap.PWM__CHASSIS__LEFT_REAR_MOTOR);
        frontRightMotor = new Talon(RobotMap.PWM__CHASSIS__RIGHT_FRONT_MOTOR);
        rearRightMotor  = new Victor(RobotMap.PWM__CHASSIS__RIGHT_REAR_MOTOR);
        
        robotDrive = new RobotDrive(frontLeftMotor,rearLeftMotor,frontRightMotor,rearRightMotor);
        
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight,true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight,true);
		
		leftEncoder = new Encoder(RobotMap.DIO__CHASSIS__LEFT_ENCODER_A, RobotMap.DIO__CHASSIS__LEFT_ENCODER_B);
        leftEncoder.setDistancePerPulse(DRIVE_ENCODER_INCH_PER_PULSE);
		rightEncoder = new Encoder(RobotMap.DIO__CHASSIS__RIGHT_ENCODER_A, RobotMap.DIO__CHASSIS__RIGHT_ENCODER_B);
        rightEncoder.setDistancePerPulse(DRIVE_ENCODER_INCH_PER_PULSE);
        
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new Chassis_Joystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void updateStatus() {
    	 SmartDashboard.putNumber("Chassis Left Encoder", getLeftEncoderDistance());
    	 SmartDashboard.putNumber("Chassis Right Encoder", getRightEncoderDistance());
    }
    
    
    public void simpleDrive(double leftSpeed, double rightSpeed) {
        double leftPower = ImpiLib.clamp(leftSpeed, -1.0, 1.0);
        double rightPower = ImpiLib.clamp(rightSpeed, -1.0, 1.0);
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

    public void resetEncoders() {
		rightEncoder.reset();
		leftEncoder.reset();
		
	}
	
	public double getLeftEncoderDistance() {
		return leftEncoder.getDistance();
	}
	
	public double getRightEncoderDistance() {
		return rightEncoder.getDistance();
	}

}