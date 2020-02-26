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

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ColorConstants;

public class ColorSubsystem extends SubsystemBase {
  /**
   * Creates a new ColorSubsystem.
   */

  public final Spark colorMotor = new Spark(ColorConstants.colorMotorPort);
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  public final ColorMatch colorMatcher = new ColorMatch();
  // Put the color sensor on our targets and change the "average" to these values
  public static Color BlueTarget = ColorMatch.makeColor(.125, .42, .44);//143, .427, .429
  public static Color GreenTarget = ColorMatch.makeColor(.17, .6, .250);//.197, .561, .240
  public static Color RedTarget = ColorMatch.makeColor(.52, .35, .14);//561, .232, .114
  public static Color YellowTarget = ColorMatch.makeColor(.32, .56, .118);//.361, .524, .113
  public static Color detectedColor;
  public String colorString;
  public static String prevColor;
  public static ColorMatchResult match;
  public static int blueCount = 0;
  public int countBlue = 0;
  public String targetColor = "No Target";



  public ColorSubsystem() {
    colorMatcher.addColorMatch(BlueTarget);
    colorMatcher.addColorMatch(GreenTarget);
    colorMatcher.addColorMatch(YellowTarget);
    colorMatcher.addColorMatch(RedTarget);
  }

  public void turnWheel() {
    colorMotor.set(.15);
  }

  public void resetCount(){
    countBlue=0;
  }

  public void checkColor(){
    detectedColor = colorSensor.getColor();
    match = colorMatcher.matchClosestColor(detectedColor);

    if(match.color == BlueTarget){
      prevColor = colorString;
      colorString = "Blue";
    }
    else if (match.color == RedTarget){
      prevColor = colorString;
      colorString = "Red";
    }
    else if (match.color == GreenTarget){
      prevColor = colorString;
      colorString = "Green";
    }
    else if (match.color == YellowTarget){
      prevColor = colorString;
      colorString = "Yellow";
    }
    else {
      prevColor = colorString;
      colorString = "Unknown";
    }
    
    if(prevColor != "Blue" && match.color == BlueTarget){//
    countBlue = countBlue + 1;
    }

    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();

    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
      case 'B' :
      targetColor = "Blue";
      break;
      case 'G' :
      targetColor = "Green";
      break;
      case 'R' :
      targetColor = "Red";
      break;
      case 'Y' :
      targetColor = "Yellow";
      break;
      default :
        //This is corrupt data
      break;
      }
    }
        else {
    targetColor = "No Target";

  }

    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
    SmartDashboard.putNumber("countBlue", countBlue);
    SmartDashboard.putString("Target Color", targetColor);
  }


  public void rotationControl() {
    if (blueCount < 4){
    colorMotor.set(.14);
    }
    else
    colorMotor.set(0);
  }
  public boolean blueCount(){
    if (blueCount >3){
    return true;
  }
    return false;
  }

  public boolean colorTargetAquired() {
    if(targetColor == colorString){
    return true;
  }
    return false;
    
  }

  public void quickStop(){
    colorMotor.set(-.2);
    Timer.delay(.2);
    colorMotor.set(0);
  }

  public void stopColorWheel(){
    colorMotor.set(0);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}