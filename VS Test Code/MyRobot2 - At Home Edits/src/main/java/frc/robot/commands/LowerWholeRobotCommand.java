/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.OI;

public class LowerWholeRobotCommand extends Command {
  public LowerWholeRobotCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.liftSubystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    LiftSubsystem.lowerWholeRobot();
  }
  public static boolean stopLower;
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;


    

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    LiftSubsystem.stopBackLift();
    LiftSubsystem.stopFrontLift();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
