/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.FindTargetCommand;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

/**
 * Add your docs here.
 */
public class ShooterSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public AnalogInput ultraSonic = new AnalogInput(RobotMap.ultraSonicPort);
  public Spark intakeMotor =  new Spark(RobotMap.intakeMotorPort);
  public static Pixy2 pixycam;
  boolean isCamera = false;
  //private static SPILink spi;
  int state=-1;


  public void measureDistance(){
  double sensorValue = ultraSonic.getVoltage();
  final double scaleFactor = 1/(5./1024.)/25.4; //scale converting voltage to distance
  double distance = 5*sensorValue*scaleFactor; //convert the voltage to distance
  SmartDashboard.putNumber("DB/Slider 0", distance); //write the value to the LabVIEW DriverStation
  }

  public void initPixy(){
        pixycam = Pixy2.createInstance(Pixy2.LinkType.SPI);
  }

  public void findTarget(){
  if(!isCamera)
  state = pixycam.init(1); // if no camera present, try to initialize
isCamera = state>=0;

SmartDashboard.putBoolean("Camera", isCamera);   //publish if we are connected
pixycam.getCCC().getBlocks(false,255,255); //run getBlocks with arguments to have the camera
                                           //acquire target data
ArrayList<Block> blocks = pixycam.getCCC().getBlocks(); //assign the data to an ArrayList for convinience
if(blocks.size() > 0)
{
  double xcoord = blocks.get(0).getX();       // x position of the largest target
  double ycoord = blocks.get(0).getY();       // y position of the largest target
  String data   = blocks.get(0).toString();   // string containing target info
  SmartDashboard.putBoolean("present", true); // show there is a target present
  SmartDashboard.putNumber("Xccord",xcoord);
  SmartDashboard.putNumber("Ycoord", ycoord);
  SmartDashboard.putString("Data", data );
}
else
  SmartDashboard.putBoolean("present", false);
SmartDashboard.putNumber("size", blocks.size()); //push to dashboard how many targets are detected
}


  public void intakeBall(){
    intakeMotor.setSpeed(.2);
  }
  public void stopIntake(){
    intakeMotor.stopMotor();
  }

  

  
    


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new FindTargetCommand());
  }
}
