// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;

public class AutoIntake extends Command {
  /** Creates a new AutoIntake. */
  private Intake cIntake;
  float speed;
  float timer;
  float current = 0;
  float period = (float) Robot.kDefaultPeriod;
  public AutoIntake(Intake cIntake, float speed, float timer) {
    this.cIntake = cIntake;
    this.speed = speed;
    this.timer = timer;
    addRequirements(cIntake);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    cIntake.Set(speed);
    current += period;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    cIntake.Set(0);
    System.out.println("aaaaaaaaaa");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (current < timer)
      return false;
    else
    {
      return true;
    }
  }
}
