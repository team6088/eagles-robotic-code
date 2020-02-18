/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.MeasureDistanceCommand;

/**
 * Add your docs here.
 */
public class ShooterSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public AnalogInput ultraSonic = new AnalogInput(RobotMap.ultraSonicPort);

  public void measureDistance(){
  double sensorValue = ultraSonic.getVoltage();
  final double scaleFactor = 1/(5./1024.); //scale converting voltage to distance
  double distance = 5*sensorValue*scaleFactor; //convert the voltage to distance
  SmartDashboard.putNumber("DB/Slider 0", distance); //write the value to the LabVIEW DriverStation
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new MeasureDistanceCommand());
  }
}
