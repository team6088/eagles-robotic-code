/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManuallyCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
  public static WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.leftSlavePort);
  public static WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
  public static WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.rightSlavePort);
  public static DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  public DriveSubsystem(){
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
    final int peakCurrentAmps = 35;
    /* Duration after current exceed Peak Current to trigger current limit */
    final int peakTimeMs = 0;
    /* Current to mantain once current limit has been triggered */
    final int continCurrentAmps = 35;
    /**
    * Timeout value generally used in parameter configs
    * Non-zero to block the config until success, zero to skip checking 
    */
    final int timoutMs = 200;
    //boolean currentSelect = false;
    //boolean currentButton = Robot.oi.logitech.getRawButton(10);
    boolean currentLimitState = true;
    leftMaster.configPeakCurrentLimit(peakCurrentAmps,timoutMs);
    leftMaster.configPeakCurrentDuration(peakTimeMs,timoutMs);
    leftMaster.configContinuousCurrentLimit(continCurrentAmps,timoutMs);
    leftMaster.enableCurrentLimit(currentLimitState);
    rightMaster.configPeakCurrentLimit(peakCurrentAmps,timoutMs);
    rightMaster.configPeakCurrentDuration(peakTimeMs,timoutMs);
    rightMaster.configContinuousCurrentLimit(continCurrentAmps,timoutMs);
    rightMaster.enableCurrentLimit(currentLimitState);
  }

  public void manualDrive(double move, double turn) {
    if(Math.abs(move)<.2) {
      move = 0;
    }
    if (Math.abs(turn)<.2){
      turn = 0;
    }
  drive.arcadeDrive(-move, turn);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveManuallyCommand());
  }
}
