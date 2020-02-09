/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class SpinWheelThreeCommand extends Command {
  public SpinWheelThreeCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.colorSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.colorSubsystem.init();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.colorSubsystem.turnColorWheelThreeTimes(RobotMap.maxSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (Robot.colorSubsystem.blueCount < 4)
    return true;
    else
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.colorSubsystem.stopColorWheel();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
