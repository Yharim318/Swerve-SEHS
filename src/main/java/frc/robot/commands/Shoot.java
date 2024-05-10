// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.SillyGuy;

public class Shoot extends Command {
  /** Creates a new Shoot. */
  private Shooter cShooter;
  private SillyGuy cSillyGuy;
  private double kDefaultPeriod = Robot.kDefaultPeriod;
  private double ShooterStartTime = 0.1;
  private double SillyGuyStartTime = 0.2;
  private double EndTime = 0.5;
  private double speed;
  private double timer;
  public Shoot(Shooter cShooter, SillyGuy cSillyGuy, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.cShooter = cShooter;
    this.cSillyGuy = cSillyGuy;
    this.speed = speed;
    addRequirements(cShooter);
    addRequirements(cSillyGuy);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    timer += kDefaultPeriod;

    if (timer < SillyGuyStartTime){
      cSillyGuy.SillyVroom(0.8f);
    }
    else if (timer >= SillyGuyStartTime){
      cSillyGuy.SillyVroom(-0.8f);
    }
    if (timer >= ShooterStartTime){
      cShooter.ShootManual(speed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (timer > EndTime){
      cShooter.ShootManual(0);
      cSillyGuy.SillyVroom(0);
      return true;
    }
    else {
      return false; 
    }
  }
}
