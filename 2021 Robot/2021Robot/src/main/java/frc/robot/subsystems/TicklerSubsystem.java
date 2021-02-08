/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TicklerConstants;

public class TicklerSubsystem extends SubsystemBase {
  /**
   * Creates a new TicklerSubsystem.
   */
  private final Spark ticklerMotor = new Spark(TicklerConstants.ticklerMotorPort);

  public void runTickler(){
    ticklerMotor.set(TicklerConstants.ticklerMotorSpeed);
  }

  public void reverseTickler(){
    ticklerMotor.set(-TicklerConstants.ticklerMotorSpeed);
  }

  public void autoTickle(double speed){
    ticklerMotor.set(speed);
  }

  public void manualTickle(double speed){
    ticklerMotor.set(speed*.8);
  }

  public void stopTickler(){
    ticklerMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
