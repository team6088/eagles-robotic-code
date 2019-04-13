/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.CameraMoveCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class CameraSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Servo servo = new Servo(RobotMap.servo);
  public static Servo servo2 = new Servo(RobotMap.servo2);
  public static Servo ballHorizontalServo = new Servo(RobotMap.ballServoHorizontal);
  public static Servo ballVerticalServo = new Servo(RobotMap.ballServoVertical);
  public static WaitCommand servoWait = new WaitCommand(100);
  public static double verticalPosition = .2;
  public static double horizontalPosition = .5;
  public static double ballVerticalPosition = 1;
  public static double ballHorizontalPosition = .5;


  public static void verticalLook(){
    double lookUp = Robot.oi.stick.getRawAxis(5)/100;
    if(lookUp !=0 & Math.abs(lookUp)>(.4/100))
    verticalPosition = verticalPosition + lookUp;
    else if(verticalPosition>1)
    verticalPosition = 1;
    else if (verticalPosition<0)
    verticalPosition = 0;
    servo2.set(verticalPosition);
    SmartDashboard.putNumber("verticalPosition", verticalPosition);
  }

  public static void horizontalLook(){
    //double lookSideways = Robot.oi.stick.getRawAxis(4)/50;
    //if(lookSideways !=0 & Math.abs(lookSideways)>(.4/100))
    //horizontalPosition = horizontalPosition + lookSideways;
    //else if(horizontalPosition>1)
    //horizontalPosition = 1;
    //else if (horizontalPosition<0)
    //horizontalPosition = 0;
    //servo.set(horizontalPosition);
    //SmartDashboard.putNumber("horizontalPosition", horizontalPosition);

    servo.set((Robot.oi.stick.getRawAxis(4)+1)/2);
  }

  public static void ballLookUp(){
    double balllookUp = -.7/100;
    ballVerticalPosition = ballVerticalPosition + balllookUp;
    if(ballVerticalPosition>1)
    ballVerticalPosition = 1;
    else if (ballVerticalPosition<.6)
    ballVerticalPosition = .6;
    ballVerticalServo.set(ballVerticalPosition);
    SmartDashboard.putNumber("ballVerticalPosition", ballVerticalPosition);
  }
  
  public static void ballLookDown(){
    double ballLookDown = .7/100;
    ballVerticalPosition = ballVerticalPosition + ballLookDown;
    if(ballVerticalPosition>1)
    ballVerticalPosition = 1;
    else if (ballVerticalPosition<.6)
    ballVerticalPosition = .6;
    ballVerticalServo.set(ballVerticalPosition);
    SmartDashboard.putNumber("ballVerticalPosition", ballVerticalPosition);
  }

    public static void ballLookLeft(){
      double ballLookLeft = -.7/100;
      ballHorizontalPosition = ballHorizontalPosition + ballLookLeft;
      if(ballHorizontalPosition>1)
      ballHorizontalPosition = 1;
      else if (ballHorizontalPosition<0)
      ballHorizontalPosition = 0;
      ballHorizontalServo.set(ballHorizontalPosition);
      SmartDashboard.putNumber("ballHorizontalPosition", ballHorizontalPosition);
    }

    public static void ballLookRight(){
      double ballLookRight = .7/100;
      ballHorizontalPosition = ballHorizontalPosition + ballLookRight;
      if(ballHorizontalPosition>1)
      ballHorizontalPosition = 1;
      else if (ballHorizontalPosition<0)
      ballHorizontalPosition = 0;
      ballHorizontalServo.set(ballHorizontalPosition);
      SmartDashboard.putNumber("ballHorizontalPosition", ballHorizontalPosition);
    }


    public static void ballLookStop(){
      ballVerticalServo.set(ballVerticalServo.get());
      ballHorizontalServo.set(ballHorizontalServo.get());
    }


  


    
    //if(lookSideways!=0 & Math.abs(lookSideways)>.1)
    //horizontalPosition = horizontalPosition + lookSideways/50;
    //servo2.set(horizontalPosition);
    //SmartDashboard.putNumber("horizontalPosition", horizontalPosition);
    
    
    

  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new CameraMoveCommand());
  }
}
