/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {

  private final Spark intakeMotor =  new Spark(IntakeConstants.intakeMotorPort);
  private final Spark intakeLiftMotor = new Spark(IntakeConstants.intakeLiftMotorPort);


  public void runIntake(){
    intakeMotor.set(IntakeConstants.intakeMotorSpeed);
  }

  public void reverseIntake(){
    intakeMotor.set(-IntakeConstants.intakeMotorSpeed);
  }

  public void runIntakeSlow(){
    intakeMotor.set(IntakeConstants.intakeMotorSpeedSlow);
  }

  public void reverseIntakeSlow(){
    intakeMotor.set(-IntakeConstants.intakeMotorSpeedSlow);
  }

  public void stopIntake(){
    intakeMotor.set(0);
  }

  public void manualFeed(double speed){
    if(speed>.4){
    speed = .4;
    }
    intakeMotor.set(speed);
}
  public void autoIntake(double speed){
    intakeMotor.set(-speed);
  }

  /**
   * Creates a new IntakeSubsystem.
   */
  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
