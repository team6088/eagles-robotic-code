/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */

  private final WPI_TalonSRX leftMaster = new WPI_TalonSRX(DriveConstants.leftMasterPort);
  private final WPI_TalonSRX leftSlave = new WPI_TalonSRX(DriveConstants.leftSlavePort);
  private final WPI_TalonSRX rightMaster = new WPI_TalonSRX(DriveConstants.rightMasterPort);
  private final WPI_TalonSRX rightSlave = new WPI_TalonSRX(DriveConstants.rightSlavePort);
  private final DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);


  private final AnalogInput ultraSonic = new AnalogInput(DriveConstants.ultraSonicPort);

  private static double distance = 0;
/*   private static int reading0 = 0;
  private static int reading1 = 0;
  private static int reading2 = 0;
  private static int reading3 = 0;
  private static int reading4 = 0;
  private static double distance0 = 0;
  private static double distance1 = 0;
  private static double distance2 = 0;
  private static double distance3 = 0;
  private static double distance4 = 0;
  private static double distance = 0;
  private static double sum;
  private static double readings[]; */

  public DriveSubsystem() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);


    //final int peakCurrentAmps = 35;
    /* Duration after current exceed Peak Current to trigger current limit */
    //final int peakTimeMs = 0;
    /* Current to mantain once current limit has been triggered */
    //final int continCurrentAmps = 35;
    /**
    * Timeout value generally used in parameter configs
    * Non-zero to block the config until success, zero to skip checking 
    */
    //final int timoutMs = 200;
    //boolean currentSelect = false;
    //boolean currentButton = Robot.oi.logitech.getRawButton(10);
 /*    boolean currentLimitState = true;
    leftMaster.configPeakCurrentLimit(peakCurrentAmps,timoutMs);
    leftMaster.configPeakCurrentDuration(peakTimeMs,timoutMs);
    leftMaster.configContinuousCurrentLimit(continCurrentAmps,timoutMs);
    leftMaster.enableCurrentLimit(currentLimitState);
    rightMaster.configPeakCurrentLimit(peakCurrentAmps,timoutMs);
    rightMaster.configPeakCurrentDuration(peakTimeMs,timoutMs);
    rightMaster.configContinuousCurrentLimit(continCurrentAmps,timoutMs);
    rightMaster.enableCurrentLimit(currentLimitState); */
  }

  public void manualDrive(double move, double turn) {
    if(Math.abs(move)<.2) {
      move = 0;
    }
    if (Math.abs(turn)<.2){
      turn = 0;
    }
  drive.arcadeDrive(-move, turn, true);

  }

  public void autonDrive(double move, double turn){
    drive.arcadeDrive(move, turn);
  }


  public void stop(){
    drive.arcadeDrive(0, 0);
  }

  public double getDistance(){
    return distance;
  }

  @Override
  public void periodic() {
    double sensorValue = ultraSonic.getVoltage();
    final double scaleFactor = 1/(5./1024.)/25.4; //scale converting voltage to distance
    double distance = 5*sensorValue*scaleFactor; //convert the voltage to distance



/*       if (distance != 0){
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

      readings[0] = distance;
      readings[1] = distance0;
      readings[2] = distance1;
      readings[3] = distance3;
      readings[4] = distance4;


    }



    for(int i=0; i<readings.length; i++){
      sum = sum + readings[i];
    }
    double smoothDistance = sum/readings.length;
    SmartDashboard.putNumber("Smoothed Ultrasonic Distance", smoothDistance);
    SmartDashboard.putNumber("Distance Array Length", readings.length);
     */
    
    SmartDashboard.putNumber("Ultrasonic Distance", distance); //write the value to the LabVIEW DriverStation

  }
}
