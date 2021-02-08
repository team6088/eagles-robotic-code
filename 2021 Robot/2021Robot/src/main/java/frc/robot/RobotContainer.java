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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.IntakeConstants;
import frc.robot.commands.DriveToUltrasonicDistance;
import frc.robot.commands.GoToColorCommand;
import frc.robot.commands.ManualShootCommand;
import frc.robot.commands.RotationalControlCommand;
import frc.robot.commands.TimedMoveCommand;
import frc.robot.subsystems.ClimberSubsystem;
//import frc.robot.commands.RotationalControlCommand;
import frc.robot.subsystems.ColorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
//import frc.robot.subsystems.shooterSubsystem;
import frc.robot.subsystems.PixySubsystem;
import frc.robot.subsystems.PneumaticSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TicklerSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
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
  public final static ColorSubsystem colorSubsystem = new ColorSubsystem();
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final PixySubsystem pixySubsystem = new PixySubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final TicklerSubsystem ticklerSubsystem = new TicklerSubsystem();
  private final PneumaticSubsystem pneumaticSubsystem = new PneumaticSubsystem();
  private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();

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
/*    public Button logitechThumbButton = new JoystickButton(operatorStick, 1),
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
  logitechButton3 = new JoystickButton(operatorStick,3);  */

  //Summary of Controls
  //DRIVER
  // A - Manual Conveyor
  // B - Manual Intake
  // X - Reverse Conveyor
  // Y - Reverse Intake
  // Left Bumper - Index Ball (instant out/in)
  // RIght Bumper - Ball Feeder  (instant out/in)
  // Start - 
  // Back - 
  // Left Trigger 2 - Intake & Belt
  // Right Trigger 3 - Shoot
  // Left D Pad -
  // Right D Pad - 
  // Up D Pad -
  // Down D Pad - Manual Shooter Reverse
  // L X axis 0 - Drive
  // L Y Axis 1 - Drive
  // R X Axis 4 - 
  // R Y Axis 5 - 

  //Operator
  // A - Go to Color Command
  // B - Rotational Control Command
  // X - Manual Wheel Control
  // Y - Lower Intake
  // Left Bumper - Color Wheel Down
  // RIght Bumper - Color Wheel Up
  // Start - Test Automated Loading
  // Back - 
  // Left Trigger 2 - 
  // Right Trigger 3 - Manual Color Wheel Control 
  // Left D Pad - 
  // Right D Pad - 
  // Up D Pad -
  // Down D Pad - 
  // L X axis 0 - 
  // L Y Axis 1 -
  // R X Axis 4 - 
  // R Y Axis 5 - 



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

  // Test Command See if it will drive for .5 seconds.
  private final Command timedMoveStraight = new TimedMoveCommand(driveSubsystem, .5, 0).withTimeout(2) //Drives backwards
  ;

  //public final Command calibrateGyro = new InstantCommand(driveSubsystem::calibrateGyro,driveSubsystem);


  private final Command shootStriaghtOn = new SequentialCommandGroup(
    //new ParallelCommandGroup(
      // Drive forward and lower ball intake
      new TimedMoveCommand(driveSubsystem, -.5, 0 ).withTimeout(2),
      new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem),
        new TimedMoveCommand(driveSubsystem, -.5, 0)).withTimeout(1),
      new ManualShootCommand(shooterSubsystem, intakeSubsystem, ticklerSubsystem, 1, .5, .3).withTimeout(3),
      new ManualShootCommand(shooterSubsystem, intakeSubsystem, ticklerSubsystem, 1, .5, -.3).withTimeout(3)
/*       new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem), //CHECK SHOOT POWER
        new InstantCommand(intakeSubsystem::runIntake, intakeSubsystem),
        new InstantCommand(ticklerSubsystem::reverseTickler, ticklerSubsystem)).withTimeout(3) */
      );
  
/*   private final Command shootThreeBalls = new SequentialCommandGroup(
    new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem).withTimeout(2),
      new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem),//.withTimeout(1),
        new InstantCommand(pneumaticSubsystem::shooterExtend,pneumaticSubsystem)).withTimeout(1),
      new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem),//.withTimeout(1),
        new InstantCommand(pneumaticSubsystem::shooterRetract,pneumaticSubsystem)).withTimeout(.25),
      new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem),//.withTimeout(1),
        new InstantCommand(pneumaticSubsystem::indexerIn,pneumaticSubsystem)).withTimeout(1),
      new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem),//.withTimeout(1),
        new InstantCommand(pneumaticSubsystem::indexerOut,pneumaticSubsystem)).withTimeout(.5),
      new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem),//.withTimeout(1),
        new InstantCommand(shooterSubsystem::runBelt, shooterSubsystem),
        new InstantCommand(pneumaticSubsystem::shooterExtend,pneumaticSubsystem)).withTimeout(1),
      new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem),//.withTimeout(1),
        new InstantCommand(shooterSubsystem::runBelt, shooterSubsystem),
        new InstantCommand(pneumaticSubsystem::shooterRetract,pneumaticSubsystem)).withTimeout(.5),
      new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem),//.withTimeout(1),
        new InstantCommand(pneumaticSubsystem::indexerIn,pneumaticSubsystem)).withTimeout(1),
      new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem),//.withTimeout(1),
        new InstantCommand(pneumaticSubsystem::indexerOut,pneumaticSubsystem)).withTimeout(.5),
      new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem),//.withTimeout(1),
        new InstantCommand(pneumaticSubsystem::shooterExtend,pneumaticSubsystem)).withTimeout(1),
      new ParallelCommandGroup(
        new InstantCommand(shooterSubsystem::staticShoot, shooterSubsystem),//.withTimeout(1),
        new InstantCommand(pneumaticSubsystem::shooterRetract,pneumaticSubsystem)).withTimeout(.5),
      new TimedMoveCommand(driveSubsystem, .5, 0).withTimeout(2)
      ); */

  
  private final Command autoDriveToDistanceTest = new DriveToUltrasonicDistance(driveSubsystem, 30);
  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // Configure Always Running Commands
        configureButtonBindings();

    driveSubsystem.setDefaultCommand(
      new RunCommand(() -> 
      driveSubsystem.manualDrive(driverStick.getY(), driverStick.getX()),driveSubsystem)
      );

    shooterSubsystem.setDefaultCommand(
      new RunCommand(() ->
      shooterSubsystem.manualShoot(driverStick.getRawAxis(3)),shooterSubsystem)
      );



    ticklerSubsystem.setDefaultCommand(
      new RunCommand(() ->
      ticklerSubsystem.manualTickle(driverStick.getRawAxis(2)),ticklerSubsystem)
    );

    // Now linked to CLIMBER!!
    colorSubsystem.setDefaultCommand(
      new RunCommand(() ->
      colorSubsystem.manualColorControl(operatorStick.getRawAxis(3)-operatorStick.getRawAxis(2)),colorSubsystem)
    );


      
    // Add auton Commands to the chooser
    m_chooser.addOption("Timed Move", timedMoveStraight);
    m_chooser.addOption("Shoot from straight on", shootStriaghtOn);
    m_chooser.addOption("Auto Drive to Distance (80 inches)", autoDriveToDistanceTest);
    //m_chooser.addOption("Shoot 3 Balls and Move Straight", shootThreeBalls);
    m_chooser.setDefaultOption("Default", timedMoveStraight); // Does this work?
    Shuffleboard.getTab("Autonomous").add(m_chooser);
  }




  //button Mapping
  private void configureButtonBindings() {



      // Shooter Commands!
      buttonDpadS.whenPressed(
        new InstantCommand(shooterSubsystem::reverseShooter, shooterSubsystem)
      ).whenReleased(
        new InstantCommand(shooterSubsystem::stopShooter, shooterSubsystem)
      );

          // WORKS
/*     buttonRightBumper.whenPressed(new SequentialCommandGroup(
      new InstantCommand(pneumaticSubsystem::shooterExtend, pneumaticSubsystem),
      new WaitCommand(.4),
      new InstantCommand(pneumaticSubsystem::shooterRetract, pneumaticSubsystem)
    )); */

    buttonLeftBumper.whileHeld(
      new ManualShootCommand(shooterSubsystem, intakeSubsystem, ticklerSubsystem, 1, .5, .3)
    ).whenReleased(
      new ParallelCommandGroup(
      new InstantCommand(shooterSubsystem::stopShooter, shooterSubsystem),
      new InstantCommand(intakeSubsystem::stopIntake, intakeSubsystem),
      new InstantCommand(ticklerSubsystem::stopTickler, ticklerSubsystem))
    );

    buttonRightBumper.whileHeld(
      new InstantCommand(shooterSubsystem::shootHigh, shooterSubsystem)
    ).whenReleased(
      new InstantCommand(shooterSubsystem::stopShooter, shooterSubsystem)
    );

    
    operatorButtonStart.whenPressed(new SequentialCommandGroup(
      new InstantCommand(pneumaticSubsystem::shooterExtend, pneumaticSubsystem),
      new WaitCommand(.4),
      new InstantCommand(pneumaticSubsystem::shooterRetract, pneumaticSubsystem),
      new WaitCommand(.2),
      new InstantCommand(pneumaticSubsystem::indexerIn, pneumaticSubsystem),
      new WaitCommand(.1),
      new InstantCommand(pneumaticSubsystem::indexerOut, pneumaticSubsystem)
    ));


      //INTAKE COMMANDS !!

      //tickler
      buttonA.whileHeld(
        new InstantCommand(ticklerSubsystem::runTickler, ticklerSubsystem)
      ).whenReleased(
        new InstantCommand(ticklerSubsystem::stopTickler, ticklerSubsystem)
      );

      buttonB.whileHeld(
        new InstantCommand(intakeSubsystem::runIntake, intakeSubsystem)
      ).whenReleased(
        new InstantCommand(intakeSubsystem::stopIntake, intakeSubsystem)
      );

      //tickler
      buttonX.whileHeld(
        new InstantCommand(ticklerSubsystem::reverseTickler, ticklerSubsystem)
      ).whenReleased(
        new InstantCommand(ticklerSubsystem::stopTickler, ticklerSubsystem)
      );

      buttonY.whileHeld(
        new InstantCommand(intakeSubsystem::reverseIntake, intakeSubsystem)
      ).whenReleased(
        new InstantCommand(intakeSubsystem::stopIntake, intakeSubsystem)
      );






          //ColorWheel Commands!

/* 
          operatorButtonX.whenPressed(
            new InstantCommand(colorSubsystem::manualTurnWheelQuick, colorSubsystem)
          ).whenReleased(
            new InstantCommand(colorSubsystem::stopColorWheel, colorSubsystem)
          ); */
    
/*           operatorButtonB.whenPressed(
            new RotationalControlCommand()); */  // Works!
    
          operatorButtonA.whenPressed(
          new GoToColorCommand()); // WORKS!

          operatorButtonLeftBumper.whenPressed(
            new InstantCommand(pneumaticSubsystem::wheelDown, pneumaticSubsystem)
          );
      
          operatorButtonRightBumper.whenPressed(
            new InstantCommand(pneumaticSubsystem::wheelUp, pneumaticSubsystem)
          );

/*           operatorButtonX.whileHeld(
            new InstantCommand(colorSubsystem::manualTurnWheelQuick, colorSubsystem)
          ); */


        //Climber Commands

        operatorButtonB.whileHeld(
            new InstantCommand(climberSubsystem::runClimber, climberSubsystem)
            ).whenReleased(
            new InstantCommand(climberSubsystem::stopClimber, climberSubsystem)
            );
          
          operatorButtonX.whileHeld(
            new InstantCommand(climberSubsystem::reverseClimber, climberSubsystem
          )).whenReleased(
            new InstantCommand(climberSubsystem::stopClimber, climberSubsystem)
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
