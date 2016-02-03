package org.usfirst.frc.team1025.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CameraSubsystem extends Subsystem {
	
	CameraServer server;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public CameraSubsystem() {
	 server = CameraServer.getInstance();
     server.setQuality(50);
     //the camera name (ex "cam0") can be found through the roborio web interface
     server.startAutomaticCapture("cam0");
     
	}
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void updateStatus() {
        
    }
    
}



