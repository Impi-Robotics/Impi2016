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
    
    		public static final int PWM__BASKET_MOTOR = 4;
    		public static final int PWM__BIGARM_MOTOR = 5;
    
            public static final int PWM__BASKETROLLER__MOTOR = 6;
   
	        public static final int PWM__CLIMBERWINCH__LEFT_MOTOR = 7;
	        public static final int PWM__CLIMBERWINCH__RIGHT_MOTOR = 8;
	        public static final int PWM__CLIMBER_MOTOR = 9;
	
	
    //PCM Module and Channel Assignments
          
	
	//Digital IO
			public static final int DIO__CHASSIS__RIGHT_ENCODER_A = 7;
			public static final int DIO__CHASSIS__RIGHT_ENCODER_B = 8;
			public static final int DIO__CHASSIS__LEFT_ENCODER_A = 5;
			public static final int DIO__CHASSIS__LEFT_ENCODER_B = 6;
			
			public static final int DIO__CATAPULT_LIMIT_SWITCH = 4;
			public static final int DIO__CATAPULT_MOTOR = 9;
			
	//Analog
			public static final int ANALOG_BASKET_POT = 0;
			public static final int ANALOG_BIGARM_POT = 1;



	
	

	
	
	
	
	
}
