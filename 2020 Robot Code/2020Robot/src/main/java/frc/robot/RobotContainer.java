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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.Constants.IntakeConstants;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.GoToColorCommand;
import frc.robot.commands.RotationalControlCommand;
import frc.robot.commands.TimedMoveCommand;
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
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
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
/*   public Button logitechThumbButton = new JoystickButton(operatorStick, 1),
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
  logitechButton3 = new JoystickButton(operatorStick,3); */

  //2nd Xbox Controller
  public Button operatorButtonA = new JoystickButton(operatorStick, 1),
  operatorButtonB = new JoystickButton(operatorStick,2),
  operatorButtonX = new JoystickButton(operatorStick,3),
  operatorButtonY = new JoystickButton(operatorStick,4),
  operatorButtonLeftBumper = new JoystickButton(operatorStick,5),
  operatorButtonRightBumper = new JoystickButton(operatorStick,6),
  operatorButtonBack = new JoystickButton(operatorStick,7),
  operatorButtonRightStick = new JoystickButton(operatorStick,10),
  operatorButtonLeftStick = new JoystickButton(operatorStick,9),
  operatorButtonStart = new JoystickButton(operatorStick,8),
  operatorButtonDpadN = new POVButton(operatorStick, 0, 0),
  operatorButtonDpadE = new POVButton(operatorStick, 90, 0),
  operatorButtonDpadS = new POVButton(operatorStick, 180, 0),
  operatorButtonDpadW = new POVButton(operatorStick, 270, 0),
  operatorButtonDpadNE = new POVButton(operatorStick, 45, 0),
  operatorButtonDpadSE = new POVButton(operatorStick, 135, 0),
  operatorButtonDpadSW = new POVButton(operatorStick, 225, 0),
  operatorButtonDpadNW = new POVButton(operatorStick, 315, 0);

  SendableChooser<Command> m_chooser = new SendableChooser<>();


  //Auton Commands

  // Test Command
  private final Command autoTest = new SequentialCommandGroup(
    new TimedMoveCommand(driveSubsystem, 1, .5, 0),
    new TimedMoveCommand(driveSubsystem, 1, 0, .5)
  );

  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    driveSubsystem.setDefaultCommand(
      new RunCommand(() -> 
      driveSubsystem.manualDrive(driverStick.getY(), driverStick.getX()),driveSubsystem)
      );

    shooterSubsystem.setDefaultCommand(
      new RunCommand(() ->
      shooterSubsystem.manualShoot(driverStick.getRawAxis(2),driverStick.getRawAxis(3)),shooterSubsystem)
    );


    intakeSubsystem.setDefaultCommand(
      new RunCommand(() ->
      intakeSubsystem.manualIntakeHeight(operatorStick.getRawAxis(2),operatorStick.getRawAxis(3)),intakeSubsystem)
      );

      
    // Add auton Commands to the chooser
    m_chooser.addOption("Auto Test", autoTest);
    Shuffleboard.getTab("Autonomous").add(m_chooser);
  }



  //button Mapping
  private void configureButtonBindings() {

          buttonStart.whenPressed(
        new InstantCommand(shooterSubsystem::runShooter, shooterSubsystem)
      ).whenReleased(
        new InstantCommand(shooterSubsystem::stopShooter, shooterSubsystem)
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

      buttonY.whenPressed(
        new RotationalControlCommand());  // Works!

    buttonX.whenPressed(
      new GoToColorCommand()); // WORKS!


        //Otherwise this one works probably

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
    return m_chooser.getSelected();
  }
}
