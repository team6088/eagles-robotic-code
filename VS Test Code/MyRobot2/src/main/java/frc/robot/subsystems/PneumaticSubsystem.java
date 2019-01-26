/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ExtendCommand;

/**
 * Add your docs here.
 */
public class PneumaticSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  
  public Compressor compressor1 = new Compressor(RobotMap.hatchCompressor);
  public DoubleSolenoid solenoid1 = new DoubleSolenoid(RobotMap.hatchExtend, RobotMap.hatchExtend);

  compressor1.setClosedLoopControl(on);


  //public Compressor compressor1 = new Compressor(RobotMap.hatchCompressor);
  //public DoubleSolenoid solenoid1 = new DoubleSolenoid(RobotMap.hatchExtend, RobotMap.hatchExtend);

  //public Compressor getCompressor1() {
  //  return compressor1;
  //}
  
  //public DoubleSolenoid getSolenoid1() {
  //  return solenoid1;
  //}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new ExtendCommand());
  }
}
