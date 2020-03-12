/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TicklerSubsystem;

public class ManualShootCommand extends CommandBase {
  /**
   * Creates a new ManualShootCommand.
   */

  private final ShooterSubsystem m_shoot;
  private final IntakeSubsystem m_intake;
  private final TicklerSubsystem m_tickler;
  private final double m_shootSpeed, m_intakeSpeed, m_tickleSpeed;


  public ManualShootCommand(ShooterSubsystem shoot, IntakeSubsystem intake, TicklerSubsystem tickler, double shootSpeed, double intakeSpeed, double tickleSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shoot = shoot;
    m_intake = intake;
    m_tickler = tickler;
    m_shootSpeed = shootSpeed;
    m_intakeSpeed = intakeSpeed;
    m_tickleSpeed = tickleSpeed;
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shoot.manualShoot(m_shootSpeed);
    m_intake.autoIntake(m_intakeSpeed);
    m_tickler.autoTickle(m_tickleSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shoot.stopShooter();
    m_intake.stopIntake();
    m_tickler.stopTickler();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
