/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


//import static org.junit.Assume.assumeFalse;
//import static org.junit.Assume.assumeTrue;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
//import frc.robot.commands.GetGyroValueCommand;


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
  public static ADXRS453Gyro gyroSPI = new ADXRS453Gyro();


  public static double liftMotorSpeed(){
    return frontLiftMotor.get();
  }




  //public static boolean isRaised(){
  //  return highLiftSwitch.get();
  //}

  //public static boolean isLowered(){
  //  return lowLiftSwitch.get();
  //}

  public static void raiseRobot(){
    if(frontLiftSwitch.get()==true)
    frontLiftMotor.set(-.92);
    else{
      frontLiftMotor.set(0);
    }
    if(backLiftSwitch.get()==true)
      backLiftMotor.set(1);
    else{
      backLiftMotor.set(0);
    }
    }

public static void raiseRobotFront(){
  if(frontLiftSwitch.get()==true)
  frontLiftMotor.set(-1);
  else{
    frontLiftMotor.set(0);
  }
}
public static void raiseRobotBack(){
  if(backLiftSwitch.get()==true)
  backLiftMotor.set(1);
else{
  backLiftMotor.set(0);
}
}

  //public static void stopRaise(){
    //if(isRaised() & liftMotorSpeed() > 0)
  //    liftMotor.set(0);
  //}

  public static void lowerRobotFront(){
    if(Robot.oi.buttonLeftBumper.get()==true && Robot.oi.buttonA.get()==true)
      frontLiftMotor.set(1);
      else if (Robot.oi.buttonLeftBumper.get()==true && Robot.oi.buttonA.get()==false)
      frontLiftMotor.set(-.18);
      else if (Robot.oi.buttonLeftBumper.get()==false && Robot.oi.buttonA.get()==true)
      frontLiftMotor.set(1);
      else
      frontLiftMotor.set(0);
  }
  
  public static void lowerRobotBack(){
    //ORIGINAL CODE
    //if(backLowerSwitch.get()==true)
    //  backLiftMotor.set(-1);
    //else {
     // backLiftMotor.set(0);
    //}

    //Test holding code.... Don't need ==True for buttons?
    if(Robot.oi.buttonRightBumper.get()==true && Robot.oi.buttonB.get()==true)
    backLiftMotor.set(-1);
    else if (Robot.oi.buttonRightBumper.get()==true && Robot.oi.buttonB.get()==false)
    backLiftMotor.set(.18);
    else if (Robot.oi.buttonRightBumper.get()==false && Robot.oi.buttonB.get()==true)
    backLiftMotor.set(-1);
    else
    backLiftMotor.set(0);
  }

  public static void lowerWholeRobot(){
    if(Robot.oi.buttonX.get())
    backLiftMotor.set(-1);
    frontLiftMotor.set(1);
    //else{
     // backLiftMotor.set(0);
     // frontLiftMotor.set(0);
    //}
}

public static void holdRobotFront(){
  if (frontLowerSwitch.get()==true)
    frontLiftMotor.set(.1);
}

public static void holdRobotBack(){
  if (backLowerSwitch.get()==true)
    backLiftMotor.set(.1);
}


  public static void stopFrontLift(){
    frontLiftMotor.set(0);
  }

  public static void stopBackLift(){
    backLiftMotor.set(0);
  }

  public static void stopBothLifts(){
    frontLiftMotor.set(0);
    backLiftMotor.set(0);
  }

 // public static void stopLower(){
    //if(isLowered() & liftMotorSpeed() < 0)
      //liftMotor.set(0);
  //}
  
public static void initializeGyro(){
  gyroSPI.startThread();
}
public static void calibrateGyro(){
  gyroSPI.calibrate();
}

public static void calibrationComplete(boolean calibrated){
 calibrated = gyroSPI.hasCompletedCalibration();
  }
  

public static void getAngle(){
  SmartDashboard.putNumber("angle", gyroSPI.getAngle());
  SmartDashboard.putNumber("position",gyroSPI.getPos());

}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new GetGyroValueCommand());
  }
}

