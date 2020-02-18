/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.CheckColorCommand;
import frc.robot.commands.GoToColorCommand;
import frc.robot.commands.GoToColorGroup;
import frc.robot.commands.IntakeBallCommand;
import frc.robot.commands.MoveSequence;
import frc.robot.commands.SpinWheelThreeCommand;
import frc.robot.commands.StopColorWheelCommand;
import frc.robot.commands.StopIntakeCommand;

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
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  public final Joystick stick = new Joystick(RobotMap.joystickPort);
  public Button buttonA = new JoystickButton(stick, 1), buttonB = new JoystickButton(stick, 2),
      buttonX = new JoystickButton(stick, 3), buttonY = new JoystickButton(stick, 4),
      buttonLeftBumper = new JoystickButton(stick, 5), buttonRightBumper = new JoystickButton(stick, 6),
      buttonBack = new JoystickButton(stick, 7), buttonRightStick = new JoystickButton(stick, 10),
      buttonLeftStick = new JoystickButton(stick, 9);
  /*
   * buttonDpadN = new AnalogJoystickButton(stick, 0, 0), buttonDpadE = new
   * AnalogJoystickButton(stick, 0, 90), buttonDpadS = new
   * AnalogJoystickButton(stick, 0, 180), buttonDpadW = new
   * AnalogJoystickButton(stick, 0, 270), buttonDpadNE = new
   * AnalogJoystickButton(stick, 0, 45), buttonDpadSE = new
   * AnalogJoystickButton(stick, 0, 135), buttonDpadSW = new
   * AnalogJoystickButton(stick, 0, 225), buttonDpadNW = new
   * AnalogJoystickButton(stick, 0, 315);
   */

  public OI() {
    /*
     * buttonX.whenPressed(new MoveSequence()); buttonY.whileHeld(new
     * TurnColorWheelSlowCommand()); buttonY.whenReleased(new
     * StopColorWheelCommand()); buttonB.whileHeld(new TurnColorWheelFastCommand());
     * buttonB.whenReleased(new StopColorWheelCommand());
     */
    buttonX.whenPressed(new MoveSequence());
    buttonA.whenPressed(new SpinWheelThreeCommand());
    buttonLeftBumper.whileHeld(new IntakeBallCommand());
    buttonLeftBumper.whenReleased(new StopIntakeCommand());
    SmartDashboard.putData("color wheel 3 times", new SpinWheelThreeCommand());
    SmartDashboard.putData("Just Read Color", new CheckColorCommand());
    SmartDashboard.putData("Stop Color Wheel", new StopColorWheelCommand());
    SmartDashboard.putData("GoToColor", new GoToColorCommand());
    SmartDashboard.putData("GoToColorGroup", new GoToColorGroup());
  
  }

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
