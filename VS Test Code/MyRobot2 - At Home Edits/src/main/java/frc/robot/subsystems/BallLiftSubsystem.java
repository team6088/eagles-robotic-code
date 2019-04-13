/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.BallLiftCommand;

/**
 * Add your docs here.
 */
public class BallLiftSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Spark ballLiftMotor = new Spark(RobotMap.ballLiftMotorPort);
  //public static AnalogInput ultrasonic = new AnalogInput(RobotMap.ultrasonicSensor);
  public static DigitalInput lowBallSwitch = new DigitalInput(RobotMap.lowBallSwitch);
  public static DigitalInput midBallSwitch = new DigitalInput(RobotMap.midBallSwitch);
  public static DigitalInput highBallSwitch = new DigitalInput(RobotMap.highBallSwitch);
  public static String position = "null";
  public static Spark ballIntakeMotor = new Spark(RobotMap.ballIntakeMotor);
  

  //public static void displayDistance(){
  //  SmartDashboard.putNumber("distance",ultrasonic.getVoltage()*(12*3.6));
  //}
  public static void driveLift(){
    
    double ballLiftSpeed = Robot.oi.logitech.getRawAxis(1);
    //if (lowBallSwitch.get()==true & midBallSwitch.get()==true & highBallSwitch.get()==true)

    SmartDashboard.putBoolean("Low Ball Position",lowBallSwitch.get());
    SmartDashboard.putBoolean("Mid Ball Position",midBallSwitch.get());
    SmartDashboard.putBoolean("High Ball Position",highBallSwitch.get());
    
    //if (highBallSwitch.get()==false & ballLiftSpeed>0)
    //ballLiftMotor.set(0);
    //else if(lowBallSwitch.get()==false)
    //ballLiftMotor.set(ballLiftSpeed);
    //else
    if(Math.abs(ballLiftSpeed)<.25) {
      ballLiftSpeed = 0;
    }
    ballLiftMotor.set(ballLiftSpeed);
    SmartDashboard.putNumber("Lift Speed",ballLiftSpeed);
    

  }

  public static void getLiftPosition(){
    if(highBallSwitch.get()==false)
      position = "high";
      else if (midBallSwitch.get()==false)
        position = "mid";
      else if (lowBallSwitch.get()==false)
        position = "low";
      else if (lowBallSwitch.get()==true & midBallSwitch.get()==true & highBallSwitch.get()==true)
        position = "unkown";  
      
      SmartDashboard.putString("ball position", position);

  }
  //public static void raiseBallLift(){
  //  if(highBallSwitch.get()==true)
  //  ballLiftMotor.set(.5);
  //  else{
  //    ballLiftMotor.set(0);
  //}
  //}
  public static void driveLiftAuto(){
    ballLiftMotor.set(.2);
  }

  public static void stopDriveLift(){
    ballLiftMotor.set(0);
  }

  public static void ballIntake(){
    ballIntakeMotor.set(-.5);
  }

  public static void ballShoot(){
    ballIntakeMotor.set(.5);
  }
  public static void ballMotorStop(){
    ballIntakeMotor.set(0);
  }

  @Override
  public void initDefaultCommand() {

    // Set the default command for a subsystem here.
    setDefaultCommand(new BallLiftCommand());
  }
}
