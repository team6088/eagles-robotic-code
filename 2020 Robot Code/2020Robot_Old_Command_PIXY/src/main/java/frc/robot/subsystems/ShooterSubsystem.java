/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

/**
 * Add your docs here.
 */
public class ShooterSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public AnalogInput ultraSonic = new AnalogInput(RobotMap.ultraSonicPort);
  public Spark intakeMotor =  new Spark(RobotMap.intakeMotorPort);
  public Spark shooterMotor = new Spark(RobotMap.shooterMotor);



  public void measureDistance(){
  double sensorValue = ultraSonic.getVoltage();
  final double scaleFactor = 1/(5./1024.)/25.4; //scale converting voltage to distance
  double distance = 5*sensorValue*scaleFactor; //convert the voltage to distance
  SmartDashboard.putNumber("Ultrasonic Distance", distance); //write the value to the LabVIEW DriverStation
  }



  
  public void intakeBall(){
    intakeMotor.setSpeed(.2);
  }
  public void stopIntake(){
    intakeMotor.stopMotor();
  }

  public void stopShooter(){
      shooterMotor.set(0);
  }

  

  
    


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new FindTargetCommand());
  }
}
