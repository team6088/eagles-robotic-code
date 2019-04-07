/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.BallGrabCommand;
import frc.robot.commands.BallLiftCommand;
import frc.robot.commands.BallShootCommandGroup;
import frc.robot.commands.CalibrateGyroCommand;
import frc.robot.commands.HatchExtendCommand;
import frc.robot.commands.HatchRetractCommand;
//import frc.robot.commands.HoldRobotBackCommand;
//import frc.robot.commands.HoldRobotFrontCommand;
import frc.robot.commands.KickExtendCommand;
import frc.robot.commands.KickRetractCommand;
import frc.robot.commands.LowerRobotBackCommand;
import frc.robot.commands.LowerRobotFrontCommand;
import frc.robot.commands.LowerWholeRobotCommand;
import frc.robot.commands.PancakeSolenoidExtendCommand;
import frc.robot.commands.PancakeSolenoidRetractCommand;
import frc.robot.commands.RaiseRobotBackCommand;
import frc.robot.commands.RaiseRobotCommand;
import frc.robot.commands.RaiseRobotFrontCommand;
//import frc.robot.commands.StopHoldRobotBackCommand;
//import frc.robot.commands.StopHoldRobotFrontCommand;
import frc.robot.commands.StopLowerRobotBackCommand;
import frc.robot.commands.StopLowerRobotFrontCommand;
import frc.robot.commands.StopLowerWholeRobotCommand;
import frc.robot.commands.StopRaiseRobotBackCommand;
import frc.robot.commands.StopRaiseRobotCommand;
import frc.robot.commands.StopRaiseRobotFrontCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  public Joystick stick = new Joystick(RobotMap.joystickPort);
  public Button buttonA = new JoystickButton(stick, 1),
                buttonB = new JoystickButton(stick,2),
                buttonX = new JoystickButton(stick,3),
                buttonY = new JoystickButton(stick,4),
                buttonLeftBumper = new JoystickButton(stick,5),
                buttonRightBumper = new JoystickButton(stick,6),
                buttonBack = new JoystickButton(stick,7),
                buttonRightStick = new JoystickButton(stick,10),
                buttonLeftStick = new JoystickButton(stick,9),
                buttonDpadN = new AnalogJoystickButton(stick, 0, 0),
                buttonDpadE = new AnalogJoystickButton(stick, 0, 90),
                buttonDpadS = new AnalogJoystickButton(stick, 0, 180),
                buttonDpadW = new AnalogJoystickButton(stick, 0, 270),
                buttonDpadNE = new AnalogJoystickButton(stick, 0, 45),
                buttonDpadSE = new AnalogJoystickButton(stick, 0, 135),
                buttonDpadSW = new AnalogJoystickButton(stick, 0, 225),
                buttonDpadNW = new AnalogJoystickButton(stick, 0, 315);



    public Joystick logitech = new Joystick(RobotMap.logitechJoystickPort);
    public Button logitechButtonGrab = new JoystickButton(logitech,1),
                  logitechButtonRelease = new JoystickButton(logitech,2),
                  logitechButton11 = new JoystickButton(logitech,11),
                  logitechButton12 = new JoystickButton(logitech,12),
                  logitechButton7 = new JoystickButton(logitech,7),
                  logitechButton8 = new JoystickButton(logitech,8);





  public OI(){

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());
    buttonLeftBumper.whenPressed(new LowerRobotFrontCommand());
    buttonLeftBumper.whenReleased(new StopLowerRobotFrontCommand());
    buttonRightBumper.whenPressed(new LowerRobotBackCommand());
    buttonRightBumper.whenReleased(new StopLowerRobotBackCommand());
    buttonA.whenPressed(new LowerRobotFrontCommand());
    buttonA.whenReleased(new StopLowerRobotFrontCommand());
    buttonB.whenPressed(new LowerRobotBackCommand());
    buttonB.whenReleased(new StopLowerRobotBackCommand());
    buttonY.whenPressed(new RaiseRobotCommand());
    buttonY.whenReleased(new StopRaiseRobotCommand());
    buttonX.whenPressed(new LowerWholeRobotCommand());
    buttonX.whenReleased(new StopLowerWholeRobotCommand());
    buttonDpadN.whenPressed(new RaiseRobotCommand());
    buttonDpadN.whenReleased(new StopRaiseRobotCommand());
    buttonDpadS.whenPressed(new LowerWholeRobotCommand());
    buttonDpadS.whenReleased(new StopLowerWholeRobotCommand());
    buttonDpadE.whenPressed(new RaiseRobotFrontCommand());
    buttonDpadE.whenReleased(new StopRaiseRobotFrontCommand());
    buttonDpadW.whenPressed(new RaiseRobotBackCommand());
    buttonDpadW.whenReleased(new StopRaiseRobotBackCommand());
    buttonRightStick.whenPressed(new PancakeSolenoidExtendCommand());
    buttonLeftStick.whenReleased(new PancakeSolenoidRetractCommand());
    logitechButtonGrab.whenPressed(new BallGrabCommand());
    logitechButtonRelease.whenPressed(new BallShootCommandGroup());
    logitechButton11.whenPressed(new KickRetractCommand());
    logitechButton12.whenPressed(new KickExtendCommand());
    logitechButton7.whenPressed(new HatchExtendCommand());
    //logitechButton7.whenReleased(new StopLowerRobotFrontCommand());
    logitechButton8.whenPressed(new HatchRetractCommand());
    //logitechButton8.whenReleased(new StopLowerRobotBackCommand());
    // Having "whenReleased" for logitech buttons apply the stop lower command may cause issues with other buttons trying to lower the robot.
    // Having the "else" motor = 0 in the subsystem may be adequate for stopping the lower function.

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  // Add commands to SmartDashboard
    SmartDashboard.putData("ExtendCommand", new HatchExtendCommand());
    SmartDashboard.putData("RetractCommand", new HatchRetractCommand());
    SmartDashboard.putData("LowerRobotCommand", new LowerRobotFrontCommand());
    SmartDashboard.putData("RaiseRobotCommand", new RaiseRobotCommand());
    SmartDashboard.putData("StartBallLift",new BallLiftCommand());
    SmartDashboard.putData("Calibrate Gyro",new CalibrateGyroCommand());


  }

}
