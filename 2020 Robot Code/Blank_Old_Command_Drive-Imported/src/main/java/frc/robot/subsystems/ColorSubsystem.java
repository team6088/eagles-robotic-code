/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.StopColorWheelCommand;

/**
 * Add your docs here.
 */
public class ColorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.



  public final Spark colorMotor = new Spark(RobotMap.colorMotorPort);

  public void addColors() {

  }

  public void turnColorWheel(final double speed){
    colorMotor.set(speed);
  }



  public void trackColors(int blueCount){

    if(Robot.match.color == Robot.BlueTarget){//&& Robot.colorString != "Blue"
      blueCount = blueCount + 1;
    }
    SmartDashboard.putNumber("Blue Count", blueCount);
    
  }
  

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     //setDefaultCommand(new StopColorWheelCommand());
  }
}
