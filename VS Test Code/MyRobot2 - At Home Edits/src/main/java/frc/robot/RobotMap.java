/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  // PWM
  public static int liftdrivePort = 6;
  public static int frontLiftMotorPort = 5;
  public static int backLiftMotorPort = 1;
  //public static int victorDrivePortLeft = 8;
  //public static int victorDrivePortRight = 9;
  public static int servo = 8;
  public static int servo2 = 9;
  public static int ballLiftMotorPort = 3;



  // CAN
  public static int leftMasterPort = 0;
  public static int leftSlavePort = 1;
  public static int rightMasterPort = 2;
  public static int rightSlavePort = 3;


  // USB
  public static int joystickPort = 0;
  public static int logitechJoystickPort = 1;

  //Cameras
  public static int frontCamera = 0;
  public static int backCamera = 1;




  //Pneumatics
  public static int hatchExtend = 2;
  public static int hatchRetract = 3;
  public static int hatchCompressor = 0;
  public static int ballExtend = 0;
  public static int ballRetract = 1;
  public static int kickExtend = 4;
  public static int kickRetract = 5;
 public static int pancakeSolenoidExtend = 6;
 public static int pancakeSolenoidRetract = 7;


  //Digital IO
  public static int frontLiftSwitch = 0;
  public static int backLiftSwitch = 1;
  public static int frontLowerSwitch = 6;
  public static int backLowerSwitch = 7;
  public static int lowBallSwitch = 4;
  public static int midBallSwitch = 3;
  public static int highBallSwitch = 2;

  //Analog
  public static int ultrasonicSensor = 0;

  

  //public static int wheelDiameter = 6;


}
