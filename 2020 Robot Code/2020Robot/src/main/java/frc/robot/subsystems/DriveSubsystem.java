/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */

  private final WPI_TalonSRX leftMaster = new WPI_TalonSRX(DriveConstants.leftMasterPort);
  private final WPI_TalonSRX leftSlave = new WPI_TalonSRX(DriveConstants.leftSlavePort);
  private final WPI_TalonSRX rightMaster = new WPI_TalonSRX(DriveConstants.rightMasterPort);
  private final WPI_TalonSRX rightSlave = new WPI_TalonSRX(DriveConstants.rightSlavePort);
  private final DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);


  public DriveSubsystem() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);


    //final int peakCurrentAmps = 35;
    /* Duration after current exceed Peak Current to trigger current limit */
    //final int peakTimeMs = 0;
    /* Current to mantain once current limit has been triggered */
    //final int continCurrentAmps = 35;
    /**
    * Timeout value generally used in parameter configs
    * Non-zero to block the config until success, zero to skip checking 
    */
    //final int timoutMs = 200;
    //boolean currentSelect = false;
    //boolean currentButton = Robot.oi.logitech.getRawButton(10);
 /*    boolean currentLimitState = true;
    leftMaster.configPeakCurrentLimit(peakCurrentAmps,timoutMs);
    leftMaster.configPeakCurrentDuration(peakTimeMs,timoutMs);
    leftMaster.configContinuousCurrentLimit(continCurrentAmps,timoutMs);
    leftMaster.enableCurrentLimit(currentLimitState);
    rightMaster.configPeakCurrentLimit(peakCurrentAmps,timoutMs);
    rightMaster.configPeakCurrentDuration(peakTimeMs,timoutMs);
    rightMaster.configContinuousCurrentLimit(continCurrentAmps,timoutMs);
    rightMaster.enableCurrentLimit(currentLimitState); */
  }

  public void manualDrive(double move, double turn) {
    if(Math.abs(move)<.2) {
      move = 0;
    }
    if (Math.abs(turn)<.2){
      turn = 0;
    }
  drive.arcadeDrive(-move, turn, true);

  }

  public void autonDrive(double move, double turn){
    drive.arcadeDrive(move, turn);
  }

  public void stop(){
    drive.arcadeDrive(0, 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
