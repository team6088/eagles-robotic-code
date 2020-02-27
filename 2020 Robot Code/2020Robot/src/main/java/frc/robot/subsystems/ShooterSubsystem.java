/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

  private final AnalogInput ultraSonic = new AnalogInput(ShooterConstants.ultraSonicPort);

  private final Spark shooterMotor = new Spark(ShooterConstants.shooterMotor);
  private static int reading0 = 0;
  private static int reading1 = 0;
  private static int reading2 = 0;
  private static int reading3 = 0;
  private static int reading4 = 0;
  private static double distance0 = 0;
  private static double distance1 = 0;
  private static double distance2 = 0;
  private static double distance3 = 0;
  private static double distance4 = 0;
  private static double readings[];
  private static double sum;


  public void runShooter(){
    shooterMotor.set(1);
}

  public void stopShooter(){
      shooterMotor.set(0);
  }

  @Override
  public void periodic() {
      double sensorValue = ultraSonic.getVoltage();
      final double scaleFactor = 1/(5./1024.)/25.4; //scale converting voltage to distance
      double distance = 5*sensorValue*scaleFactor; //convert the voltage to distance
 


      //while (distance != 0){
        reading4 = reading3;
        reading3 = reading2;
        reading2 = reading1;
        reading1 = reading0;
        reading0 = reading0 + 1;

        distance4 = distance3;
        distance3 = distance2;
        distance2 = distance1;
        distance1 = distance0;
        distance0 = distance;
      //}

      readings[0] = distance0;
      readings[1] = distance1;
      readings[2] = distance2;
      readings[3] = distance3;
      readings[4] = distance4;

      for(int i=0; i<readings.length; i++){
        sum = sum + readings[i];
      }
      double smoothDistance = sum/readings.length;
      SmartDashboard.putNumber("Smoothed Ultrasonic Distance", smoothDistance);
      SmartDashboard.putNumber("Distance Array Length", readings.length);
      SmartDashboard.putNumber("Ultrasonic Distance", distance); //write the value to the LabVIEW DriverStation

  
    }
}
