/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveLiftCommand;

/**
 * Add your docs here.
 */
public class LiftDriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Spark liftDriveMotor = new Spark(RobotMap.liftdrivePort);
  public static void driveLift(){

    if(Robot.oi.stick.getRawAxis(2) > Robot.oi.stick.getRawAxis((3)))
    liftDriveMotor.set(Robot.oi.stick.getRawAxis(2)*-.5);
    else
    liftDriveMotor.set(Robot.oi.stick.getRawAxis(3)*.5);

        //if (driveType =true)
    //liftDriveMotor.set(1);
    //else
    //liftDriveMotor.set(-1);
  }

  public static void driveLiftStop(){
    liftDriveMotor.set(0);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveLiftCommand());
  }
}
