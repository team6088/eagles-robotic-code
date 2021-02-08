/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticConstants;

public class PneumaticSubsystem extends SubsystemBase {
  /**
   * Creates a new PneumaticSubsystem.
   */

     // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final Compressor compressor1 = new Compressor(PneumaticConstants.compressor);
  public final DoubleSolenoid shooterSolenoid = new DoubleSolenoid(PneumaticConstants.shooterRetract,PneumaticConstants.shooterExtend);
  public final DoubleSolenoid wheelSolenoid = new DoubleSolenoid(PneumaticConstants.ballRetract,PneumaticConstants.ballExtend);
  public final DoubleSolenoid indexerSolenoid = new DoubleSolenoid(PneumaticConstants.indexerRetract,PneumaticConstants.indexerExtend);


  public void init(){
    compressor1.setClosedLoopControl(true);
    //compressor1.enabled();
  }
  public void shooterExtend(){
    shooterSolenoid.set(Value.kForward); 
  }

  public void shooterRetract(){
    shooterSolenoid.set(Value.kReverse); 
  }

  public void wheelUp(){
    wheelSolenoid.set(Value.kForward); 
  }

  public void wheelDown(){
    wheelSolenoid.set(Value.kReverse); 
  }

  public void indexerOut() {
    indexerSolenoid.set(Value.kForward);
  }

  public void indexerIn() {
    indexerSolenoid.set(Value.kReverse);
  }


  
  public PneumaticSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
