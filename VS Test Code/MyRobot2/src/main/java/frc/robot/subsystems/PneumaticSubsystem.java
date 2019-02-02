/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ExtendCommand;

/**
 * Add your docs here.
 */
public class PneumaticSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Compressor compressor1 = new Compressor(RobotMap.hatchCompressor);
  public static DoubleSolenoid solenoid1 = new DoubleSolenoid(RobotMap.hatchRetract,RobotMap.hatchExtend);

  public static void init(){
    compressor1.setClosedLoopControl(true);
    //compressor1.enabled();
  }

  public static void solenoidExtend(){
    solenoid1.set(DoubleSolenoid.Value.kForward);
  }

  public static void solenoidRetract(){
    solenoid1.set(DoubleSolenoid.Value.kReverse);
  }
  
  public static void solenoidOff(){
    solenoid1.set(DoubleSolenoid.Value.kOff);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new ExtendCommand());
  }
}
