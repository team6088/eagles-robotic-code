/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.BallLiftSubsystem;
import frc.robot.subsystems.LiftSubsystem;

public class ExampleAutoCommand extends Command {
  public ExampleAutoCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.ballLiftSubsystem);
    requires(Robot.driveSubsystem);
    //requires(Robot.distanceSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //double distance = liftUltrasonic.getRangeInches();
    //DistanceSubsystem.liftDistance(distance);
    BallLiftSubsystem.driveLiftAuto();
    //Timer.delay(3);
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //Stop when switch is pressed (the ! means opposite)
    return !LiftSubsystem.frontLiftSwitch.get();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
