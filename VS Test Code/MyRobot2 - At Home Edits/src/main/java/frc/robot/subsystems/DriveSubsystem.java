/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.VictorSP;
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

  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
  public WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.leftSlavePort);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.rightSlavePort);
  public VictorSP leftVictor = new VictorSP (RobotMap.victorDrivePortLeft);
  public VictorSP rightVictor = new VictorSP(RobotMap.victorDrivePortRight);


  // instantiate a new DifferentialDrive object and assign motor controllers to
  // differential drive


  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);
  public DifferentialDrive victorDrive = new DifferentialDrive(leftVictor, rightVictor);

  // create constructor function
  public DriveSubsystem() {
    // point slaves to masters

    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

  // add manualDrive() method
  public void manualDrive(double move, double turn) {

    // max speed example
    // if(move>.5) move = .5;

    drive.arcadeDrive(move, turn);
  }

  public void victorDrive(double move, double turn){
    victorDrive.arcadeDrive(move,turn);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveManuallyCommand());
  }
}
