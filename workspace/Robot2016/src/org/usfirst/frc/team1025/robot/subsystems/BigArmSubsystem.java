package org.usfirst.frc.team1025.robot.subsystems;

import org.usfirst.frc.team1025.robot.Robot;
import org.usfirst.frc.team1025.robot.RobotMap;
import org.usfirst.frc.team1025.robot.commands.BigArm.Big_Arm_Joystick;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class BigArmSubsystem extends PIDSubsystem {
	
	private Potentiometer bigArmPot;
	private SpeedController bigArmMotor;
	
	private static final double kP_real = 1,
            kP_simulation = 0.05;

	
    // Initialize your subsystem here
    public BigArmSubsystem() {
    	
    	 super(kP_real, 0, 0);
         if (Robot.isSimulation()) { // Check for simulation and update PID values
             getPIDController().setPID(kP_simulation, 0, 0, 0);
         }
         setAbsoluteTolerance(2.5);

         bigArmMotor = new Victor(RobotMap.PWM__BIGARM_MOTOR);
         
         // Conversion value of potentiometer varies between the real world and simulation
         if (Robot.isReal()) {
             bigArmPot = new AnalogPotentiometer(RobotMap.ANALOG_BIGARM_POT, -270.0/5);
         } else {
        	 bigArmPot = new AnalogPotentiometer(RobotMap.ANALOG_BIGARM_POT); // Defaults to degrees
         }

 		// Let's show everything on the LiveWindow
     //    LiveWindow.addActuator("Arm", "Motor", (Victor) bigArmMotor);
     //    LiveWindow.addSensor("Arm", "Pot", (AnalogPotentiometer) bigArmPot);
      //   LiveWindow.addActuator("Arm", "PID", getPIDController());
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new Big_Arm_Joystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void updateStatus() {
    	
    	SmartDashboard.putData("Arm Angle", (AnalogPotentiometer) bigArmPot);
    }
    
   
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return bigArmPot.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	bigArmMotor.pidWrite(output);
    }
    

   public void stop() {
       bigArmMotor.set(0.);
     
	}
    
}
