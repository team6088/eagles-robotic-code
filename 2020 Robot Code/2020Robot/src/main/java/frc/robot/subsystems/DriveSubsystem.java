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
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */
  private final WPI_TalonSRX leftMaster = new WPI_TalonSRX(Constants.leftMasterPort);
  private final WPI_TalonSRX leftSlave = new WPI_TalonSRX(Constants.leftSlavePort);
  private final WPI_TalonSRX rightMaster = new WPI_TalonSRX(Constants.rightMaster);
  private final WPI_TalonSRX rightSlave = new WPI_TalonSRX(Constants.rightSlave);
  //private final SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftMaster, leftSlave);
  //private final SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(rightMaster, rightSlave);
  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

//differential drive of 2019

  public DriveSubsystem(){
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

  public void manualDrive(double move, double turn){

    if(Math.abs(move)<.2){
      move = 0;
    }
    if(Math.abs(turn)<.2){
      turn = 0;
    }
    drive.arcadeDrive(move, turn);
  }

/*   public void rightDrive(double rightStickY, double rightStickX){

    if(Math.abs(rightStickY)<.2){
      rightStickY = 0;
    }
    if(Math.abs(rightStickX)<.2){
      rightStickX = 0;
    }
    //drive.arcadeDrive(move,turn);
  } */


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
