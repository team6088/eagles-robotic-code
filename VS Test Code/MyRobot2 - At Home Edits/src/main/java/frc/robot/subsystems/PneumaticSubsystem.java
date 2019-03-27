/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */
public class PneumaticSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Compressor compressor1 = new Compressor(RobotMap.hatchCompressor);
  public static DoubleSolenoid hatchSolenoid = new DoubleSolenoid(RobotMap.hatchRetract,RobotMap.hatchExtend);
  public static DoubleSolenoid ballSolenoid = new DoubleSolenoid(RobotMap.ballRetract,RobotMap.ballExtend);
  public static DoubleSolenoid kickSolenoid = new DoubleSolenoid(RobotMap.kickRetract,RobotMap.kickExtend);
 public static Solenoid pancakeSolenoid = new Solenoid(RobotMap.pancakeSolenoid);

  public static void init(){
    compressor1.setClosedLoopControl(true);
    //compressor1.enabled();
  }
 public static void pancakeSolenoidExtend(){
   pancakeSolenoid.set(true);
 }

  public static void pancakeSolenoidRetract(){
    pancakeSolenoid.set(false);
  }


  public static void hatchSolenoidExtend(){
    hatchSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public static void hatchSolenoidRetract(){
    hatchSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
  
  public static void hatchSolenoidOff(){
    hatchSolenoid.set(DoubleSolenoid.Value.kOff);
}

public static void ballSolenoidExtend(){
  ballSolenoid.set(DoubleSolenoid.Value.kForward);
}

public static void ballSolenoidRetract(){
  ballSolenoid.set(DoubleSolenoid.Value.kReverse);
}

public static void ballSolenoidOff(){
  ballSolenoid.set(DoubleSolenoid.Value.kOff);
}


public static void kickSolenoidExtend(){
  kickSolenoid.set(DoubleSolenoid.Value.kForward);
}

public static void kickSolenoidRetract(){
  kickSolenoid.set(DoubleSolenoid.Value.kReverse);
}

public static void kickSolenoidOff(){
  kickSolenoid.set(DoubleSolenoid.Value.kOff);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new ExtendCommand());
  }
}
