// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SillyGuy;

public class AutoSillyGuy extends Command {
  /** Creates a new AutoSillyGuyStart. */
  public SillyGuy cSillyGuy;
  public float speed;
  public AutoSillyGuy(SillyGuy cSillyGuy, float speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(cSillyGuy);
    this.cSillyGuy = cSillyGuy;
    this.speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    cSillyGuy.SillyVroom(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
