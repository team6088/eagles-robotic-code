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
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.GoToColorCommand;
import frc.robot.commands.RotationalControlCommand;
import frc.robot.subsystems.ColorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PixySubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

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
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  public static ColorSubsystem colorSubsystem = new ColorSubsystem();
  private final PixySubsystem pixySubsystem = new PixySubsystem();
  SendableChooser<Command> chooser = new SendableChooser<>();
  //private final Command simpleAuto = new autoCommand1();

  // Define sticks and Buttons
  public static Joystick driverStick = new Joystick(0);
  private final Joystick operatorStick = new Joystick(1);
  private final JoystickButton buttonA = new JoystickButton(driverStick, 1), 
  buttonB = new JoystickButton(driverStick, 2),
  buttonX = new JoystickButton(driverStick, 3),
  buttonY = new JoystickButton(driverStick, 4),
  buttonLeftBumper = new JoystickButton(driverStick, 5),
  buttonRightBumper = new JoystickButton(driverStick, 6),
  buttonBack = new JoystickButton(driverStick, 7),
  buttonRightStick = new JoystickButton(driverStick, 10),
  buttonLeftStick = new JoystickButton(driverStick, 9);

      /*
      * buttonDpadN = new AnalogJoystickButton(stick, 0, 0), buttonDpadE = new
      * AnalogJoystickButton(driverStick, 0, 90), buttonDpadS = new
      * AnalogJoystickButton(driverStick, 0, 180), buttonDpadW = new
      * AnalogJoystickButton(driverStick, 0, 270), buttonDpadNE = new
      * AnalogJoystickButton(driverStick, 0, 45), buttonDpadSE = new
      * AnalogJoystickButton(driverStick, 0, 135), buttonDpadSW = new
      * AnalogJoystickButton(driverStick, 0, 225), buttonDpadNW = new
      * AnalogJoystickButton(driverStick, 0, 315);
      */


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();


    //Set Default Commands
    driveSubsystem.setDefaultCommand(
      new RunCommand(() -> driveSubsystem.manualDrive(driverStick.getY(),driverStick.getX()),driveSubsystem)
    );
    colorSubsystem.setDefaultCommand(
      new RunCommand(() -> colorSubsystem.checkColor(),colorSubsystem)
    );
    pixySubsystem.setDefaultCommand(
      new RunCommand(() -> pixySubsystem.findTarget(),pixySubsystem)
    );
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    //Color Wheel Controls

    //Manually turn the color wheel
    buttonA.whenPressed(
      new InstantCommand(colorSubsystem::turnWheel,colorSubsystem)
    );
    //Quick Stop the wheel when released
     buttonA.whenReleased(
      new InstantCommand(colorSubsystem::quickStop,colorSubsystem)
     );
     //Automatically go to target Color
     buttonB.whenPressed(new GoToColorCommand());

     //Turn color wheel to see blue 4 times
     buttonX.whenPressed(new RotationalControlCommand());


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
