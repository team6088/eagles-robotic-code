/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;

//import org.opencv.core.Mat;
//import org.opencv.core.Scalar;
//import org.opencv.imgproc.Imgproc;

//import edu.wpi.cscore.CvSink;
//import edu.wpi.cscore.CvSource;
//import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.BallLiftCommand;
import frc.robot.commands.ExampleAutoCommand;
import frc.robot.subsystems.BallLiftSubsystem;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LiftDriveSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.PneumaticSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();
  public static PneumaticSubsystem pneumaticSubsystem = new PneumaticSubsystem();
  public static LiftSubsystem liftSubystem = new LiftSubsystem();
  public static CameraSubsystem cameraSubsystem = new CameraSubsystem();
  public static BallLiftSubsystem ballLiftSubsystem = new BallLiftSubsystem();
  public static LiftDriveSubsystem liftDriveSubsystem = new LiftDriveSubsystem();
  public static OI oi;

  
  //LiveWindow Test Stuff
  



  //Thread m_visionThread;
  
  //Commented out to see if causing issues with robot code crashing 2/14
  //Command raiseRobotCommand;
  //Command lowerRobotCommand;
  //Command driveManuallyCommand;
  //Command autonomousCommand;
  //SendableChooser chooser = new SendableChooser<>();

  // The following is an example of how to add preferences for calibration settings
  // to the smartDashboard instead of hard-coding them.
  
  //	Preferences prefs;
	//double armUpPosition;
	//double armDownPosition;	
	//public void robotInit() {
	//	prefs = Preferences.getInstance();
	//	armUpPosition = prefs.getDouble("ArmUpPosition", 1.0);
	//	armDownPosition = prefs.getDouble("ArmDownPosition", 4.);
	//}

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    oi = new OI();
    //retractCommand = new RetractCommand();

    //TEST CODE FROM INTERMEDIATE VISINO EXAMPLE
    //m_visionThread = new Thread(() -> {
    //  // Get the UsbCamera from CameraServer
    //  UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
      // Set the resolution
    //  camera.setResolution(640, 480);

      // Get a CvSink. This will capture Mats from the camera
//      CvSink cvSink = CameraServer.getInstance().getVideo();
      // Setup a CvSource. This will send images back to the Dashboard
  //    CvSource outputStream
     //     = CameraServer.getInstance().putVideo("Rectangle", 640, 480);

      // Mats are very memory expensive. Lets reuse this Mat.
      //Mat mat = new Mat();

      // This cannot be 'true'. The program will never exit if it is. This
      // lets the robot stop this thread when restarting robot code or
      // deploying.
    //  while (!Thread.interrupted()) {
        // Tell the CvSink to grab a frame from the camera and put it
        // in the source mat.  If there is an error notify the output.
    //    if (cvSink.grabFrame(mat) == 0) {
          // Send the output the error.
     //     outputStream.notifyError(cvSink.getError());
          // skip the rest of the current iteration
    //      continue;
    //    }
        // Put a rectangle on the image
    //    Imgproc.rectangle(mat, new Point(100, 100), new Point(400, 400),
    //        new Scalar(255, 255, 255), 5);
    //    // Give the output stream a new image to display
    //    outputStream.putFrame(mat);
    //  }
    //});
    //m_visionThread.setDaemon(true);
    //m_visionThread.start();


    //Adding Scheduler and commmands to the smartDashboard
		//chooser.addDefault("Middle", new ExampleAutoCommand());
		//chooser.addObject("Left Hatch", new BallLiftCommand());
		//chooser.addObject("Center Position", "Center");
		//chooser.addObject("Right Position", "Right");
		//chooser.addObject("Right - Scale Preferred", "RightScale");
    //SmartDashboard.putData("auto mode",chooser);

    // Get the UsbCamera from CameraServer
    UsbCamera frontCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.frontCamera);
    UsbCamera backCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.backCamera);
      //Set the resolution
    frontCamera.setResolution(240, 180);
    backCamera.setResolution(240, 180);

    //CameraServer.getInstance().startAutomaticCapture(0);
    //CameraServer.getInstance().startAutomaticCapture(1);

     // LiveWindow.addSensor("Front Raise Robot Switch", RobotMap.frontLiftSwitch, new DIO);
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
    SmartDashboard.putNumber("Drive Speed",BallLiftSubsystem.ballLiftMotor.get());
    //SmartDashboard.putNumber("distance",LiftSubsystem.ultrasonic.getVoltage()*(12*3.6));
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
  //  autonomousCommand = (Command) chooser.getSelected();
  //if (autonomousCommand != null)
  //  autonomousCommand.start();
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
    //if (autonomousCommand != null) {
    //  autonomousCommand.cancel();
    //}
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
    //LiveWindow.run();
  }
}
