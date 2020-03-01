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
  private static final double cpr = 360; //if am-3132
  //private static final double cpr = 7/4; //if am-2861a
  // private static final double cpr = 5; //if am-3314a
  // private static final double cpr = 1024; //if am-3445
  // private static final double cpr = 64; //if am-4027
  private final Encoder intakeEncoder = new Encoder(0,1);
  private final int angle = 5;
  private final Spark intakeLiftMotor = new Spark(IntakeConstants.intakeLiftMotorPort);
  
  int P, I, D = 1;
  int integral, previous_error = 0;
  double setpoint = 30;

  /**
   * Creates a new IntakeSubsystem.
   */
  public void runIntake(){
    intakeMotor.set(IntakeConstants.intakeMotorSpeed);
  }

  public void stopShooter(){
      intakeMotor.set(0);
  }

  public void manualIntakeHeight(double up, double down){

    if(up > down)
    intakeLiftMotor.set(up);
    else
    intakeLiftMotor.set(-1*down);
}

  public void robotInit() {
    intakeEncoder.setDistancePerPulse(Math.PI*angle/cpr); //distance per pulse is pi* (wheel diameter / counts per revolution)
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double dist = intakeEncoder.getDistance();
    SmartDashboard.putNumber("Encoder", dist);
  }
}
