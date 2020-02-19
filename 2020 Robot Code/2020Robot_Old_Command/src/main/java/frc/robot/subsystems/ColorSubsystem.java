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

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
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
  public String targetColor;
  public ColorSubsystem() {
  }

  public void turnColorWheel(final double speed) {
    colorMotor.set(speed);
  }

  public void init(){
    colorMatcher.addColorMatch(BlueTarget);
    colorMatcher.addColorMatch(GreenTarget);
    colorMatcher.addColorMatch(YellowTarget);
    colorMatcher.addColorMatch(RedTarget);
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


    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
    SmartDashboard.putNumber("countBlue", countBlue);

  }


  public void turnColorWheelThreeTimes(final double speed) {
    blueCount = 0;
    if (blueCount < 4){
    colorMotor.set(speed);
    }
    else
    colorMotor.set(0);

    //while(match.color == BlueTarget){//&& Robot.colorString != "Blue"
    //blueCount = blueCount + 1;
    //}
    //if (blueCount > 3){
    //  colorMotor.set(0);
    //}
  }

  public void goToColor(final double speed) {
    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();

    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' :
        targetColor = "Blue";
        if (colorString != "Blue"){
          colorMotor.set(speed);
          }
          else
          colorMotor.set(0);
          break;
        case 'G' :
        targetColor = "Green";
        if (colorString != "Green"){
          colorMotor.set(speed);
          }
          else
          colorMotor.set(0);
          break;
        case 'R' :
        targetColor = "Red";
        if (colorString != "Red"){
          colorMotor.set(speed);
          }
          else
          colorMotor.set(0);
          break;
        case 'Y' :
        targetColor = "Yellow";
        if (colorString != "Yellow"){
          colorMotor.set(speed);
          }
          else
          colorMotor.set(0);
          break;
        default :
          //This is corrupt data
          break;
      }
    } else {
      targetColor = "No Target";
      colorMotor.set(0);
    }
    SmartDashboard.putString("Target Color", targetColor);
  }

  public void quickStop(){
    colorMotor.set(-.2);
    Timer.delay(.5);
    colorMotor.set(0);
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
