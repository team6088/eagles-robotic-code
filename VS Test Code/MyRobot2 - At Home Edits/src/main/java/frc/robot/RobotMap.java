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
  public static int victorDrivePortLeft = 8;
  public static int victorDrivePortRight = 9;
  public static int servo = 2;
  public static int servo2 = 4;
  public static int ballLiftMotorPort = 7;



  // CAN
  public static int leftMasterPort = 1;
  public static int leftSlavePort = 3;
  public static int rightMasterPort = 0;
  public static int rightSlavePort = 2;


  // USB
  public static int joystickPort = 0;
  public static int logitechJoystickPort = 1;




  //Pneumatics
  public static int hatchExtend = 2;
  public static int hatchRetract = 3;
  public static int hatchCompressor = 0;
  public static int ballExtend = 1;
  public static int ballRetract = 4;


  //Digital IO
  public static int frontLiftSwitch = 0;
  public static int backLiftSwitch = 1;
  public static int frontLowerSwitch = 6;
  public static int backLowerSwitch = 7;

  

  //public static int wheelDiameter = 6;


}
