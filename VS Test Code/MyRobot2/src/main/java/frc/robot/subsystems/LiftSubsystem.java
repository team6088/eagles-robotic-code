/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveLiftCommand;;

/**
 * Add your docs here.
 */
public class LiftSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Spark frontLiftMotor = new Spark(RobotMap.frontLiftMotorPort);
  public static Spark backLiftMotor = new Spark(RobotMap.backLiftMotorPort);
  public static DigitalInput frontLiftSwitch = new DigitalInput(RobotMap.frontLiftSwitch);
  public static DigitalInput backLiftSwitch = new DigitalInput(RobotMap.backLiftSwitch);
  public static DigitalInput frontLowerSwitch = new DigitalInput(RobotMap.frontLowerSwitch);
  public static DigitalInput backLowerSwitch = new DigitalInput(RobotMap.backLowerSwitch);
  
  public static Spark liftDriveMotor = new Spark(RobotMap.liftdrivePort);
  public static double liftMotorSpeed(){
    return frontLiftMotor.get();
  }
  public static double liftDriveMotorSpeed(){
    return liftDriveMotor.get();
  }

  //public static boolean isRaised(){
  //  return highLiftSwitch.get();
  //}

  //public static boolean isLowered(){
  //  return lowLiftSwitch.get();
  //}

  public static void raiseRobot(){
    if(Robot.oi.buttonY.get() & frontLiftSwitch.get()==true)
    frontLiftMotor.set(1);
    else {
      frontLiftMotor.set(0);
    }
    if(Robot.oi.buttonY.get() & backLiftSwitch.get()==true)
      backLiftMotor.set(1);
    else {
      backLiftMotor.set(0);

    }
}

  //public static void stopRaise(){
    //if(isRaised() & liftMotorSpeed() > 0)
  //    liftMotor.set(0);
  //}

  public static void lowerRobotFront(){
    if(Robot.oi.buttonA.get() & frontLowerSwitch.get()==true)
      frontLiftMotor.set(-1);
    else {
      frontLiftMotor.set(0);
    }
  }

  public static void lowerRobotBack(){
    if(Robot.oi.buttonB.get() & backLowerSwitch.get()==true)
      backLiftMotor.set(-1);
    else {
      backLiftMotor.set(0);
    }
  }

  public static void lowerWholeRobot(){
    if(Robot.oi.buttonX.get())
    backLiftMotor.set(-1);
    frontLiftMotor.set(-1);
    //else{
     // backLiftMotor.set(0);
     // frontLiftMotor.set(0);
    //}
}

  public static void stopFrontLift(){
    frontLiftMotor.set(0);
  }

  public static void stopBackLift(){
    backLiftMotor.set(0);
  }


  public static boolean driveType;
  public static boolean buttonToggle = false;
  

  public static void driveLift(){


    //if (driveType =true)
    //liftDriveMotor.set(1);
    //else
    //liftDriveMotor.set(-1);

    if(Robot.oi.stick.getRawAxis(2) > Robot.oi.stick.getRawAxis((3)))
    liftDriveMotor.set(Robot.oi.stick.getRawAxis(2)*-1);
    else
    liftDriveMotor.set(Robot.oi.stick.getRawAxis(3));
  }


 // public static void stopLower(){
    //if(isLowered() & liftMotorSpeed() < 0)
      //liftMotor.set(0);
  //}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveLiftCommand());
  }
}
