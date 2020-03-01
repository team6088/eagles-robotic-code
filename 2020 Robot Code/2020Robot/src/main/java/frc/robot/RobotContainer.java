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
import frc.robot.Constants.IntakeConstants;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.GetColorCommand;
//import frc.robot.commands.RotationalControlCommand;
import frc.robot.subsystems.ColorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PixySubsystem;
import frc.robot.subsystems.PneumaticSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
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
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final PneumaticSubsystem pneumaticSubsystem = new PneumaticSubsystem();

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
  buttonStart = new JoystickButton(driverStick,8),
  buttonDpadN = new POVButton(driverStick, 0, 0),
  buttonDpadE = new POVButton(driverStick, 90, 0),
  buttonDpadS = new POVButton(driverStick, 180, 0),
  buttonDpadW = new POVButton(driverStick, 270, 0),
  buttonDpadNE = new POVButton(driverStick, 45, 0),
  buttonDpadSE = new POVButton(driverStick, 135, 0),
  buttonDpadSW = new POVButton(driverStick, 225, 0),
  buttonDpadNW = new POVButton(driverStick, 315, 0);

  //VERIFY LOGITECH BUTTONS!
  public Button logitechThumbButton = new JoystickButton(operatorStick, 1),
  logitechFingerTrigger = new JoystickButton(operatorStick, 2),
  logitechButton11 = new JoystickButton(operatorStick,11),
  logitechButton12 = new JoystickButton(operatorStick,12),
  logitechButton7 = new JoystickButton(operatorStick,7),
  logitechButton8 = new JoystickButton(operatorStick,8),
  logitechButtonDpadS = new POVButton(operatorStick, 180, 0),
  logitechButtonDpadE = new POVButton(operatorStick, 90, 0),
  logitechButtonDpadN = new POVButton(operatorStick, 0, 0),
  logitechButtonDpadW = new POVButton(operatorStick, 270, 0),
  logitechButton4 = new JoystickButton(operatorStick,4),
  logitechButton3 = new JoystickButton(operatorStick,3);

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
      new RunCommand(() -> 
      driveSubsystem.manualDrive(driverStick.getY(), driverStick.getX()),driveSubsystem)
      );

      shooterSubsystem.setDefaultCommand(
      new RunCommand(() ->
      shooterSubsystem.manualShoot(driverStick.getRawAxis(2),driverStick.getRawAxis(3)),shooterSubsystem)
    );

  
      colorSubsystem.setDefaultCommand(
        new GetColorCommand()
      );


      //ColorWheel Commands!
      buttonA.whenPressed(
        new InstantCommand(colorSubsystem::manualTurnWheelQuick, colorSubsystem)
      ).whenReleased(
        new InstantCommand(colorSubsystem::stopColorWheel, colorSubsystem)
      );

      buttonB.whenPressed(
        new InstantCommand(colorSubsystem::manualTurnWheelSlow, colorSubsystem)
      ).whenReleased(
        new InstantCommand(colorSubsystem::stopColorWheel, colorSubsystem)
      );

      buttonStart.whenPressed(
        new InstantCommand(shooterSubsystem::runShooter, shooterSubsystem)
      ).whenReleased(
        new InstantCommand(shooterSubsystem::stopShooter, shooterSubsystem)
      );



    //Test of this version of a command
    buttonX.whenPressed(
        new RunCommand(colorSubsystem::rotationControl, colorSubsystem)
        .withInterrupt(colorSubsystem::colorPositionSet)
        .andThen(colorSubsystem::stopColorWheel, colorSubsystem)
    );
        //Otherwise this one works probably
    //buttonX.whenPressed(new RotationalControlCommand());

/*     buttonLeftBumper.whenPressed(
    new InstantCommand(intakeSubsystem::runShooter, intakeSubsystem)
    ).whenReleased(
      new InstantCommand(intakeSubsystem::stopShooter, intakeSubsystem)
    ); */

    //buttonLeftBumper.whenPressed(
      //new InstantCommand(intakeSubsystem::runShooter, intakeSubsystem)
      //);

    buttonLeftBumper.whenPressed(()
       -> pneumaticSubsystem.shooterExtend());
    


    buttonRightBumper.whenPressed(
      new InstantCommand(pneumaticSubsystem::shooterRetract, pneumaticSubsystem)
    );

    
    buttonLeftStick.whenPressed(
      new InstantCommand(pneumaticSubsystem::wheelDown, pneumaticSubsystem)
    );

    
    buttonRightStick.whenPressed(
      new InstantCommand(pneumaticSubsystem::wheelUp, pneumaticSubsystem)
    );

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
