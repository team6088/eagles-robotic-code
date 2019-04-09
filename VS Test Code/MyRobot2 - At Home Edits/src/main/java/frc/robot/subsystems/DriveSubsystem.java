/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManuallyCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(RobotMap.leftMasterPort);
  public WPI_TalonSRX leftSlave = new WPI_TalonSRX(RobotMap.leftSlavePort);
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RobotMap.rightMasterPort);
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.rightSlavePort);
  //public VictorSP leftVictor = new VictorSP (RobotMap.victorDrivePortLeft);
  //public VictorSP rightVictor = new VictorSP(RobotMap.victorDrivePortRight);

  // instantiate a new DifferentialDrive object and assign motor controllers to
  // differential drive


  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);
  //public DifferentialDrive victorDrive = new DifferentialDrive(leftVictor, rightVictor);

  // create constructor function
  public DriveSubsystem() {
    // point slaves to masters

    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

  // add manualDrive() method
  public void manualDrive(double move, double turn) {
        /* Current threshold to trigger current limit */
    final int peakCurrentAmps = 20;
        /* Duration after current exceed Peak Current to trigger current limit */
    final int peakTimeMs = 0;
        /* Current to mantain once current limit has been triggered */
    final int continCurrentAmps = 15;
        /**
     * Timeout value generally used in parameter configs
     * Non-zero to block the config until success, zero to skip checking 
     */
    final int timoutMs = 30;
    boolean currentSelect = false;
    boolean currentButton = Robot.oi.logitech.getRawButton(10);
    boolean currentLimitState = true;
    
    leftMaster.configFactoryDefault();
    rightMaster.configFactoryDefault();
    leftMaster.configPeakCurrentLimit(peakCurrentAmps,timoutMs);
    leftMaster.configPeakCurrentDuration(peakTimeMs,timoutMs);
    leftMaster.configContinuousCurrentLimit(continCurrentAmps,timoutMs);
    leftMaster.enableCurrentLimit(currentLimitState);
    rightMaster.configPeakCurrentLimit(peakCurrentAmps,timoutMs);
    rightMaster.configPeakCurrentDuration(peakTimeMs,timoutMs);
    rightMaster.configContinuousCurrentLimit(continCurrentAmps,timoutMs);
    rightMaster.enableCurrentLimit(currentLimitState);

    // max speed example
    if(Math.abs(move)<.2) {
      move = 0;
    }
    if (Math.abs(turn)<.2){
      turn = 0;
    }

    drive.arcadeDrive(move, turn);
    
    		/* on logitech button 10  */
    if (!currentSelect && currentButton){
      			/* toggle current limit */
      currentLimitState = !currentLimitState;
			/* update Talon current limit */
      leftMaster.enableCurrentLimit(currentLimitState);
      rightMaster.enableCurrentLimit(currentLimitState);
			/* print to DS */
      System.out.println("Enable Current Limit:" + currentLimitState);
    	/* print to DS */
      SmartDashboard.putBoolean("Current Limit State", currentLimitState);
    }

  }

  //public void victorDrive(double move, double turn){
  //  victorDrive.arcadeDrive(move,turn);
  //}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //SendableChooser<String> driveChooser = new SendableChooser<>();
		//driveChooser.addDefault("Competition", "Competition");
		//driveChooser.addObject("Practice", "Practice");
    //SmartDashboard.putData("Drive mode", driveChooser);
    //String command = driveChooser.getSelected();
		//if (command.equals("Competition")) {
    //  setDefaultCommand(new UseVictorsCommand());
		//} else if (command.equals("Practice")) {
      setDefaultCommand(new DriveManuallyCommand());
    //}

  }
}
