/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {



  private final Spark shooterMotor = new Spark(ShooterConstants.shooterMotorPort);
  private final Spark intakeMotor =  new Spark(ShooterConstants.intakeMotorPort);
  private static final double cpr = 360; //if am-3132
  //private static final double cpr = 7/4; //if am-2861a
  // private static final double cpr = 5; //if am-3314a
  // private static final double cpr = 1024; //if am-3445
  // private static final double cpr = 64; //if am-4027
  private final Encoder intakeEncoder = new Encoder(0,1);
  private final int angle = 5;
  private final Spark intakeLiftMotor = new Spark(ShooterConstants.intakeLiftMotorPort);
  private final Spark ticklerMotor = new Spark(ShooterConstants.ticklerMotorPort);

  int P, I, D = 1;
  int integral, previous_error = 0;
  double setpoint = 30;

  public void reverseShooter(){
    shooterMotor.set(-.5);
}

  public void staticShoot(){
    shooterMotor.set(ShooterConstants.shootPower);  
  }

  public void stopShooter(){
      shooterMotor.set(0);
  }

  public void manualShoot(double forward){

      shooterMotor.set(forward);

  }

  public void shootHigh(){
    shooterMotor.set(.75);
  }

  public void shootLow(){
    shooterMotor.set(.5);
  }

  
  public void runIntake(){
    intakeMotor.set(ShooterConstants.intakeMotorSpeed);
  }

  public void reverseIntake(){
    intakeMotor.set(-ShooterConstants.intakeMotorSpeed);
  }

  public void runIntakeSlow(){
    intakeMotor.set(ShooterConstants.intakeMotorSpeedSlow);
  }

  public void reverseIntakeSlow(){
    intakeMotor.set(-ShooterConstants.intakeMotorSpeedSlow);
  }

  public void stopIntake(){
    intakeMotor.set(0);
  }

  public void runTickler(){
    ticklerMotor.set(ShooterConstants.ticklerMotorSpeed);
  }

  public void reverseTickler(){
    ticklerMotor.set(-ShooterConstants.ticklerMotorSpeed);
  }

  public void stopTickler(){
    ticklerMotor.set(0);
  }

  public void manualFeed(double speed){
    if(speed>1){
    speed = 1;
    }
    intakeMotor.set(-speed*.4);
    ticklerMotor.set(-speed);
}

  public void lowerIntakeAngle(){
    intakeLiftMotor.set(ShooterConstants.intakeLowerSpeed);
  }

  public void stopIntakeAngle(){
    intakeLiftMotor.set(0);
  }

  public void robotInit() {
    intakeEncoder.setDistancePerPulse(Math.PI*angle/cpr); //distance per pulse is pi* (wheel diameter / counts per revolution)
  }

  @Override
  public void periodic() {
 
    double dist = intakeEncoder.getDistance();
    //SmartDashboard.putNumber("Encoder", dist);
  
    }
}
