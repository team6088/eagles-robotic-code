/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ColorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PixySubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public final static ColorSubsystem colorSubsystem = new ColorSubsystem();
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final PixySubsystem pixySubsystem = new PixySubsystem();

  public static Joystick driverStick = new Joystick(0);
  public static Joystick operatorStick = new Joystick(1);
  public Button buttonA = new JoystickButton(driverStick, 1),
  buttonB = new JoystickButton(driverStick,2),
  buttonX = new JoystickButton(driverStick,3),
  buttonY = new JoystickButton(driverStick,4),
  buttonLeftBumper = new JoystickButton(driverStick,5),
  buttonRightBumper = new JoystickButton(driverStick,6),
  buttonBack = new JoystickButton(driverStick,7),
  buttonRightStick = new JoystickButton(driverStick,10),
  buttonLeftStick = new JoystickButton(driverStick,9),
  buttonDpadN = new POVButton(driverStick, 0, 0),
  buttonDpadE = new POVButton(driverStick, 90, 0),
  buttonDpadS = new POVButton(driverStick, 180, 0),
  buttonDpadW = new POVButton(driverStick, 270, 0),
  buttonDpadNE = new POVButton(driverStick, 45, 0),
  buttonDpadSE = new POVButton(driverStick, 135, 0),
  buttonDpadSW = new POVButton(driverStick, 225, 0),
  buttonDpadNW = new POVButton(driverStick, 315, 0);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    driveSubsystem.setDefaultCommand(
      new RunCommand(() -> driveSubsystem.manualDrive(driverStick.getY(), driverStick.getX()),driveSubsystem));
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
