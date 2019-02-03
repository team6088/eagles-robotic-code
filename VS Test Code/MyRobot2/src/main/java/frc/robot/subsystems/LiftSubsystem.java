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
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class LiftSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Spark liftMotor = new Spark(RobotMap.liftMotorPort);
  public static DigitalInput highLiftSwitch = new DigitalInput(RobotMap.highLiftSwitch);
  public static DigitalInput lowLiftSwitch = new DigitalInput(RobotMap.lowLiftSwitch);
  
  public static double liftMotorSpeed(){
    return liftMotor.get();
  }

  public static boolean isRaised(){
    return highLiftSwitch.get();
}

  public static boolean isLowered(){
    return lowLiftSwitch.get();
  }
  public static void raiseRobot(){
    liftMotor.set(.8);
  }

  public static void stopRaise(){
    if(isRaised() & liftMotorSpeed() > 0)
      liftMotor.set(0);
  }

  public static void lowerRobot(){
    liftMotor.set(-.8);
  }

  public static void stopLower(){
    if(isLowered() & liftMotorSpeed() < 0)
      liftMotor.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
