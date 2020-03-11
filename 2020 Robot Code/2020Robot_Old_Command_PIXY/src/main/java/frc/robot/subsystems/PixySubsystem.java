/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

/**
 * Add your docs here.
 */
public class PixySubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  public static Pixy2 pixycam;
  boolean isCamera = false;
  //private static SPILink spi;
  int state=-1;
  public int targetHeight;
  public int targetWidth;
  public boolean targetAquired;

  public void initPixy(){
    pixycam = Pixy2.createInstance(Pixy2.LinkType.SPI);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  }
}
