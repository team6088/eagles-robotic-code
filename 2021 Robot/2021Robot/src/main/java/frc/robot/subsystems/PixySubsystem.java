/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.VisionConstants;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.links.SPILink;

public class PixySubsystem extends SubsystemBase {

 /*  public static Pixy2 pixycam;
  boolean isCamera = true;
  private static SPILink spi;
  int state=-1;
  public int targetHeight;
  public int targetWidth;
  public boolean targetAquired;
  public double xcoord;
  public double ycoord;
  public String data; */



  /**
   * Creates a new PixySubsystem.
   */
  public PixySubsystem() {

  }

/*    public void initPixy(){
    pixycam = Pixy2.createInstance(Pixy2.LinkType.I2C);
}
 */


// Goal ratio is 39.125 x 17.125 for h x w    
//60x137 - 80x182
/*  public void findTarget(){
   if(targetHeight>=VisionConstants.minTargetHeight && targetHeight<=VisionConstants.maxTargetHeight && 
  targetWidth>=VisionConstants.minTargetWidth && targetWidth<=VisionConstants.maxTargetWidth){
    targetAquired = true;
  }
  else{
  targetAquired = false;
  }
  SmartDashboard.putBoolean("Target Status", targetAquired); 
  } */
 





  @Override
  public void periodic() {
     // This method will be called once per scheduler run
    /*  if(!isCamera)
     state = pixycam.init(); // if no camera present, try to initialize
     isCamera = state>=0; 
 
     SmartDashboard.putBoolean("Camera", isCamera);   //publish if we are connected
     pixycam.getCCC().getBlocks(true,255,255); //run getBlocks with arguments to have the camera
                                                //acquire target data
     ArrayList<Block> blocks = pixycam.getCCC().getBlockCache(); //assign the data to an ArrayList for convinience
     if(blocks.size() > 0)
     {
     xcoord = blocks.get(0).getX();       // x position of the largest target
     ycoord = blocks.get(0).getY();       // y position of the largest target
     data   = blocks.get(0).toString();   // string containing target info
     targetHeight = blocks.get(0).getHeight();
     targetWidth = blocks.get(0).getWidth();
     SmartDashboard.putBoolean("present", true); // show there is a target present
     SmartDashboard.putNumber("Xccord",xcoord);
     SmartDashboard.putNumber("Ycoord", ycoord);
     SmartDashboard.putString("Data", data ); 
      }
   
   
     else{
   
     SmartDashboard.putBoolean("present", false);
     SmartDashboard.putNumber("size", blocks.size()); //push to dashboard how many targets are detected
     }  */
  } 
}

