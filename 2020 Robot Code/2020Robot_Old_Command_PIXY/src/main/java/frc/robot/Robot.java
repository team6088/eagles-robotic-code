/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.ArrayList;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.ColorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PixySubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ColorSubsystem colorSubsystem = new ColorSubsystem();
  public static OI oi;
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  public static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public static PixySubsystem pixySubsystem = new PixySubsystem();

  public static Pixy2 pixycam;
  boolean isCamera = false;
  //private static SPILink spi;
  int state=-1;
  public int targetHeight;
  public int targetWidth;
  public boolean targetAquired;
  
  Command autonomousCommand;
  SendableChooser<Command> chooser = new SendableChooser<>();
  //private RobotContainer m_robotContainer;
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    oi = new OI();
    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    //chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", chooser);
    UsbCamera frontCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.frontCamera);
    UsbCamera backCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.backCamera);
      //Set the resolution
    frontCamera.setResolution(240, 180);
    backCamera.setResolution(240, 180);

    pixycam = Pixy2.createInstance(Pixy2.LinkType.SPI);
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    if(!isCamera)
    state = pixycam.init(1); // if no camera present, try to initialize
    isCamera = state>=0;
  
    SmartDashboard.putBoolean("Camera", isCamera);   //publish if we are connected
    pixycam.getCCC().getBlocks(true,255,255); //run getBlocks with arguments to have the camera
                                               //acquire target data
    ArrayList<Block> blocks = pixycam.getCCC().getBlocks(); //assign the data to an ArrayList for convinience
    if(blocks.size() > 0)
    {
    double xcoord = blocks.get(0).getX();       // x position of the largest target
    double ycoord = blocks.get(0).getY();       // y position of the largest target
    String data   = blocks.get(0).toString();   // string containing target info
    targetHeight = blocks.get(0).getHeight();
    targetWidth = blocks.get(0).getWidth();
    if(targetHeight>=RobotMap.minTargetHeight && targetHeight<=RobotMap.maxTargetHeight && targetWidth>=RobotMap.minTargetWidth && targetWidth<=RobotMap.maxTargetWidth){
    targetAquired = true;
    }
    else{
    targetAquired = false;
    }
  
    SmartDashboard.putBoolean("present", true); // show there is a target present
    SmartDashboard.putNumber("Xccord",xcoord);
    SmartDashboard.putNumber("Ycoord", ycoord);
    SmartDashboard.putString("Data", data );
    SmartDashboard.putBoolean("Target Status", targetAquired);
  }
  else
    SmartDashboard.putBoolean("present", false);
  SmartDashboard.putNumber("size", blocks.size()); //push to dashboard how many targets are detected
  }
  

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    autonomousCommand = chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }


  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }




  
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
