package org.usfirst.frc.team1025.robot;


import org.usfirst.frc.team1025.robot.commands.PID_BasketArmDown;
import org.usfirst.frc.team1025.robot.commands.PID_BasketArmUp;
import org.usfirst.frc.team1025.robot.commands.Chassis.*;
//import org.usfirst.frc.team1025.robot.commands.Claw.*;



//import edu.wpi.first.wpilibj.command.WaitCommand;


public class OI {
    public XboxController driverController;
    public XboxController buttonsController;

    public OI() {
        driverController = new XboxController(RobotMap.PORT__OI__DRIVER_CONTROLLER);
        buttonsController = new XboxController(RobotMap.PORT__OI__BUTTONS_CONTROLLER);
        
        //DRIVER CONTROLLER BUTTONS
        driverController.buttonA.whenPressed(new PID_BasketArmDown());
        driverController.buttonB.whenPressed(new PID_BasketArmUp());
        //BUTTONS CONTROLLER BUTTONS
        
     /*   driverController.buttonLeft.whenPressed(new CanGrabber_Up());
        driverController.buttonRight.whenPressed(new CanGrabber_Down());

        buttonsController.buttonLeft.whenPressed (new Unloader_Toggle());
        buttonsController.buttonRight.whenPressed(new Loader_Toggle());
        buttonsController.buttonX.whenPressed(new Elevator_Top()); */
        
      //  buttonsController.buttonY.whenPressed(new Claw_Toggle());
        
      /*  buttonsController.buttonA.whenPressed(new Elevator_Bottom());
        buttonsController.buttonB.whenPressed(new Elevator_StagePosition());
        buttonsController.buttonLeftStick.whenPressed(new WaitCommand(0.1));
        buttonsController.buttonRightStick.whenPressed(new WaitCommand(0.1)); */
      //  buttonsController.buttonSelect.whenPressed(new Claw_Open());
       // buttonsController.buttonStart.whenPressed(new Claw_Closed());
    }
    
    public XboxController getDriverController() {
        return driverController;
    }

    public XboxController getButtonsController() {
        return buttonsController;
    }
}