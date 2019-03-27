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
  public static WaitCommand servoWait = new WaitCommand(100);
public static double verticalPosition = .6;
public static double horizontalPosition = .5;

  public static void verticalLook(){
    double lookUp = Robot.oi.stick.getRawAxis(5)/100;
    if(lookUp !=0 & Math.abs(lookUp)>(.2/100))
    verticalPosition = verticalPosition + lookUp;
    else if(verticalPosition>1)
    verticalPosition = 1;
    else if (verticalPosition<0)
    verticalPosition = 0;
    servo2.set(verticalPosition);
    SmartDashboard.putNumber("verticalPosition", verticalPosition);


  }
  public static void horizontalPosition(){
    double lookSideways = Robot.oi.stick.getRawAxis(4)/50;
    if(lookSideways !=0 & Math.abs(lookSideways)>(.2/100))
    horizontalPosition = horizontalPosition + lookSideways;
    else if(horizontalPosition>1)
    horizontalPosition = 1;
    else if (horizontalPosition<0)
    horizontalPosition = 0;
    servo.set(horizontalPosition);
    SmartDashboard.putNumber("horizontalPosition", horizontalPosition);
  }

  


    
    //if(lookSideways!=0 & Math.abs(lookSideways)>.1)
    //horizontalPosition = horizontalPosition + lookSideways/50;
    //servo2.set(horizontalPosition);
    //SmartDashboard.putNumber("horizontalPosition", horizontalPosition);
    
    
    
    //servo.set((Robot.oi.stick.getRawAxis(4)+1)/2);
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new CameraMoveCommand());
  }
}
