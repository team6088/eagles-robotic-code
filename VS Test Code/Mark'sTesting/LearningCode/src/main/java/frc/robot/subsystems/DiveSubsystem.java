/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DiveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.



  //intsatiate new motor controller objects
public WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
public WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.leftSlavePort);
public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
public WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.rightSlavePort);

//SpeedControlerGroup leftMotorGroup = new SpeedControllerGroup(leftMaster, leftSlave);
//SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(rightMaster, rightSlave);


 // instantiate a new DifferetialDrive object
 // assign motor controllers to differetnial drive
public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);


 // create contructor function
 public DriveSubsystem() {
// point slaves to masters
  leftSlave.follow(leftmaster);
  rightSlave.follow(rightmaster);
 }
 
 
 // add manualDrive() method
 public void manualDrive(double move, double turn) {

if(move > .5) {
  move = .5;
}

drive.arcadeDrive(move, turn);
 }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
   // setDefaultCommand(new MySpecialCommand());
  }
}
