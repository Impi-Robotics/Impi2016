package org.usfirst.frc.team1025.robot.subsystems;

import org.usfirst.frc.team1025.robot.Robot;
import org.usfirst.frc.team1025.robot.RobotMap;
import org.usfirst.frc.team1025.robot.commands.BasketArm.Basket_Arm_Joystick;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class BasketArmSubsystem extends PIDSubsystem {
	
	private Potentiometer basketArmPot; 
	private SpeedController basketArmMotor;
    
	
	
	private static final double kP_real = 1,
            kP_simulation = 0.05;

	
    // Initialize your subsystem here
    public BasketArmSubsystem() {
    	
    	 super(kP_real, 0, 0);
         if (Robot.isSimulation()) { // Check for simulation and update PID values
             getPIDController().setPID(kP_simulation, 0, 0, 0);
         }
         setAbsoluteTolerance(2.5);

         basketArmMotor = new Victor(RobotMap.PWM__BASKET_MOTOR);
         
         // Conversion value of potentiometer varies between the real world and simulation
         if (Robot.isReal()) {
             basketArmPot = new AnalogPotentiometer(RobotMap.ANALOG_BASKET_POT, -270.0/5);
         } else {
        	 basketArmPot = new AnalogPotentiometer(RobotMap.ANALOG_BASKET_POT); // Defaults to degrees
         }

 		// Let's show everything on the LiveWindow
     //    LiveWindow.addActuator("Arm", "Motor", (Victor) basketArmMotor);
     //    LiveWindow.addSensor("Arm", "Pot", (AnalogPotentiometer) basketArmPot);
      //   LiveWindow.addActuator("Arm", "PID", getPIDController());
    }
    
    // Initialize your subsystem here
    public void initDefaultCommand() {
    	setDefaultCommand(new Basket_Arm_Joystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void updateStatus() {
    	
    	SmartDashboard.putData("Arm Angle", (AnalogPotentiometer) basketArmPot);
    }
    
   
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return basketArmPot.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	basketArmMotor.pidWrite(output);
    }
    

   public void stop() {
       basketArmMotor.set(0.);
     
	}
   
    
}
