/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
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

  public static void verticalLook(){
    servo2.set((Robot.oi.stick.getRawAxis(5)+1)/2);
  }

  public static void horizontalLook(){
    servo.set((Robot.oi.stick.getRawAxis(4)+1)/2);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new CameraMoveCommand());
  }
}
