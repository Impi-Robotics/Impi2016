package org.usfirst.frc.team1025.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int PORT__OI__DRIVER_CONTROLLER = 0;
	public static final int PORT__OI__BUTTONS_CONTROLLER = 1;
	
	public static final int PWM__CHASSIS__RIGHT_FRONT_MOTOR = 3;
    public static final int PWM__CHASSIS__LEFT_FRONT_MOTOR = 0;
    public static final int PWM__CHASSIS__RIGHT_REAR_MOTOR = 2;
    public static final int PWM__CHASSIS__LEFT_REAR_MOTOR = 1;
	
    //PCM Module and Channel Assignments
    public static final int PCM_MODULE_NUMBER = 0;
   	public static final int PCM__CLAW__CLAW_FORWARD = 0;
	public static final int PCM__CLAW__CLAW_REVERSE = 1;
	
	
}
