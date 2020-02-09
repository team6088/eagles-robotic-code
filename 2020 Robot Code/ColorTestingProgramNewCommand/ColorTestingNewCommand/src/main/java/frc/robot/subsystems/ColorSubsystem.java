/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ColorSubsystem extends SubsystemBase {


   
  private final Spark colorMotor = new Spark(Constants.colorMotorPort);

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch colorMatcher = new ColorMatch();

  // Put the color sensor on our targets and change the "average" to these values
  private static Color BlueTarget = ColorMatch.makeColor(.143, .427, .429);
  private static Color GreenTarget = ColorMatch.makeColor(.197, .561, .240);
  private static Color RedTarget = ColorMatch.makeColor(.561, .232, .114);
  private static Color YellowTarget = ColorMatch.makeColor(.361, .524, .113);


  private static Color detectedColor;
  private static String colorString;
  private static ColorMatchResult match;
  private int blueCount = 0;



  /**
   * Creates a new ColorSubsystem.
   */
  public ColorSubsystem() {

  }

  public void turnColorWheel(final double speed) {
    colorMotor.set(speed);
  }

  
  public void stopColorWheel(){
    colorMotor.set(0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    colorMatcher.addColorMatch(BlueTarget);
    colorMatcher.addColorMatch(GreenTarget);
    colorMatcher.addColorMatch(YellowTarget);
    colorMatcher.addColorMatch(RedTarget);  
    
    detectedColor = colorSensor.getColor();
    match = colorMatcher.matchClosestColor(detectedColor);



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
}
