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

import frc.robot.RobotMap;
import frc.robot.commands.CheckColorCommand;


/**
 * Add your docs here.
 */
public class ColorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.



  public final Spark colorMotor = new Spark(RobotMap.colorMotorPort);

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  public final ColorMatch colorMatcher = new ColorMatch();

  // Put the color sensor on our targets and change the "average" to these values
  public static Color BlueTarget = ColorMatch.makeColor(.143, .427, .429);
  public static Color GreenTarget = ColorMatch.makeColor(.197, .561, .240);
  public static Color RedTarget = ColorMatch.makeColor(.561, .232, .114);
  public static Color YellowTarget = ColorMatch.makeColor(.361, .524, .113);


  public static Color detectedColor;
  public static String colorString;
  public static ColorMatchResult match;
  public int blueCount;
  

  public void turnColorWheel(final double speed) {
    colorMotor.set(speed);
  }

  public void init(){

    colorMatcher.addColorMatch(BlueTarget);
    colorMatcher.addColorMatch(GreenTarget);
    colorMatcher.addColorMatch(YellowTarget);
    colorMatcher.addColorMatch(RedTarget);
  }

  public void checkColor(){
    detectedColor = colorSensor.getColor();
    match = colorMatcher.matchClosestColor(detectedColor);
    //double blueCount=0;
    if(match.color == BlueTarget){
      colorString = "Blue";
    }
    else if (match.color == RedTarget){
      colorString = "Red";
    }
    else if (match.color == GreenTarget){
      colorString = "Green";
    }
    else if (match.color == YellowTarget){
      colorString = "Yellow";
    }
    else {
      colorString = "Unknown";
    }
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);

  }
  public void turnColorWheelThreeTimes(final double speed) {
  

    blueCount = 0;
    colorMotor.set(speed);
    while(match.color == BlueTarget){//&& Robot.colorString != "Blue"
    blueCount = blueCount + 1;
    }
    //if (blueCount > 3){
    //  colorMotor.set(0);
    //}

  
  SmartDashboard.putNumber("subsystem Blue Count", blueCount);
  }

  public void stopColorWheel(){
    colorMotor.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new CheckColorCommand());
  }
}
