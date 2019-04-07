/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.CameraSubsystem;

public class CameraMoveCommand extends Command {
  public CameraMoveCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.cameraSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    CameraSubsystem.servo2.set(.2);
    CameraSubsystem.servo.set(.5);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    //double lookSideways = Robot.oi.stick.getRawAxis(4);
    //CameraSubsystem.horizontalLook(lookSideways);
    CameraSubsystem.verticalLook();
    CameraSubsystem.horizontalPosition();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
