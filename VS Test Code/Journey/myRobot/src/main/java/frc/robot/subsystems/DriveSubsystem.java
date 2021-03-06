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

public WPI_TalonSRX leftMaster = new WPI_TalonSRX (RobotMap.leftMasterPort);
public WPI_TalonSRX leftSlave = new WPI_TalonSRX (RobotMap.leftSlavePort);
public WPI_TalonSRX rightMaster = new WPI_TalonSRX (RobotMap.rightMasterPort);
public WPI_TalonSRX rightSlave = new WPI_TalonSRX (RobotMap.rightSlavePort);

//instantiate a new DifferentialDrive object
public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

//create constructor function
public DriveSubsystem() {
  //point slaves to masters
  leftSlave.follow(leftMaster);
  rightSlave.follow(rightMaster);
}

//add teleopDrive() method
public void teleopDrive(double move, double turn) {

  if (Math.abs(move) < 0.10) {
      move = 0;
  }
  if (Math.abs(move) < 0.10) {
      turn = 0;
  }

  //if (move > .5){
  //    move = .5;
  //}
  //if (move < -.5){
  //move = -.5;
  //}

  //if (turn > .5){
  //  turn = .5;
//}
//if (turn < -.5){
//turn = -.5;
//}


drive.arcadeDrive(move, turn);
}

  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveManuallyCommand());
  }
}
