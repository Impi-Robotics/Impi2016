package org.usfirst.frc.team1025.robot;

//import org.usfirst.frc.team1025.robot.commands.Autonomous.*;
import org.usfirst.frc.team1025.robot.commands.BasketArm.SetBasketArmSetpoint;
import org.usfirst.frc.team1025.robot.commands.Chassis.*;
import org.usfirst.frc.team1025.robot.commands.*;
//import org.usfirst.frc.team1025.robot.commands.Camera.*;


import edu.wpi.first.wpilibj.command.WaitCommand;


public class OI {
    public XboxController driverController;
    public XboxController buttonsController;

    public OI() {
        driverController = new XboxController(RobotMap.PORT__OI__DRIVER_CONTROLLER);
        buttonsController = new XboxController(RobotMap.PORT__OI__BUTTONS_CONTROLLER);

     /*   driverController.buttonLeft.whenPressed(new CanGrabber_Up());
        driverController.buttonRight.whenPressed(new CanGrabber_Down());

        buttonsController.buttonLeft.whenPressed (new Unloader_Toggle());
        buttonsController.buttonRight.whenPressed(new Loader_Toggle());*/
        buttonsController.buttonX.whenPressed(new SetBasketArmSetpoint(10));   //basket arm up
        buttonsController.buttonY.whenPressed(new SetBasketArmSetpoint(30));   //basket arm down
        buttonsController.buttonA.whenPressed(new BasketArmDown_BigArmDown());
        buttonsController.buttonB.whenPressed(new BasketArmUp_BigArmUp());
       // buttonsController.buttonLeftStick.whenPressed(new WaitCommand(0.1));
       // buttonsController.buttonRightStick.whenPressed(new WaitCommand(0.1)); */
        //buttonsController.buttonSelect.whenPressed(new Claw_Open());
       // buttonsController.buttonStart.whenPressed(new Claw_Closed());
    }
    
    public XboxController getDriverController() {
        return driverController;
    }

    public XboxController getButtonsController() {
        return buttonsController;
    }
}