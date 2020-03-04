/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.util.Gains;
import frc.robot.util.PID;

public class DriveToUltrasonicDistance extends CommandBase {
  
  private final Gains driveGains;
  private final PID pid;
  double drivePower, error, m_targetDistance, currentDistance;
  private final DriveSubsystem m_drive;
  private final double tolerance = Units.inchesToMeters(3);
  private int onTargetCounter = 0;

  /**
   * Creates a new DriveToUltrasonicDistance.
   */
  public DriveToUltrasonicDistance(DriveSubsystem drive, double targetDistance) {
    m_drive=drive;
    m_targetDistance = targetDistance;
    SmartDashboard.putNumber("dtd target", targetDistance);
    addRequirements(drive);
    driveGains = new Gains(.035, 0, .02, true, "dtd drive gains");
    // Decent at moving 30"
    pid = new PID(driveGains, targetDistance);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveGains.kPUpdated();
    driveGains.kIUpdated();
    driveGains.kDUpdated();
    currentDistance = m_drive.distance;
    error = m_targetDistance - currentDistance;
    SmartDashboard.putNumber("dtd error", error);
    SmartDashboard.putNumber("current distance", currentDistance);

    drivePower = pid.getCorrection(currentDistance);
    if(drivePower > 0.6)
      drivePower = 0.6;

    if(drivePower < -0.6)
      drivePower = -0.6;
      SmartDashboard.putNumber("dtd drive power", drivePower);

      if (Math.abs(error) < tolerance) {
        onTargetCounter++;
      } else {
        onTargetCounter = 0;
      }

      m_drive.autonDrive(drivePower, 0);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(onTargetCounter >= 50)
    return true;

    return false;
  }
}
