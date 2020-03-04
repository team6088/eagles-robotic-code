/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {



  private final Spark shooterMotor = new Spark(ShooterConstants.shooterMotorPort);



  public void reverseShooter(){
    shooterMotor.set(-.5);
}

  public void stopShooter(){
      shooterMotor.set(0);
  }

  public void manualShoot(double forward){

      shooterMotor.set(forward);
  }

  @Override
  public void periodic() {
 

  
    }
}
