// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.SillyGuy;
import frc.robot.subsystems.Swerve;
import frc.robot.autos.exampleAuto;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LeftPiece extends ParallelRaceGroup {
  /** Creates a new MiddlePiece. */
  public LeftPiece(Swerve s_Swerve, Intake cIntake, Shooter cShooter, SillyGuy cSillyGuy) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
            new SequentialCommandGroup(
              new exampleAuto(s_Swerve, List.of(
                new Pose2d(0, 0, Rotation2d.fromDegrees(0)), 
                new Pose2d(0, 1.4, Rotation2d.fromDegrees(0)), 
                new Pose2d(1.7, 1.4, Rotation2d.fromDegrees(0)), 
                new Pose2d(1.8, 1.4, Rotation2d.fromDegrees(0)), 
                new Pose2d(0.4, 1.4, Rotation2d.fromDegrees(0)), 
                new Pose2d(0, -0.3, Rotation2d.fromDegrees(0))
              )),
              s_Swerve.run(() -> {
                s_Swerve.setModuleStates(new SwerveModuleState[]{
                    new SwerveModuleState(0.0, Rotation2d.fromDegrees(45)),
                    new SwerveModuleState(0.0, Rotation2d.fromDegrees(-45)),
                    new SwerveModuleState(0.0, Rotation2d.fromDegrees(-45)),
                    new SwerveModuleState(0.0, Rotation2d.fromDegrees(45))
                });
              })
            ),
            new SequentialCommandGroup(
              new AutoIntake(cIntake, 0.8f, 4.5f),
              new AutoIntake(cIntake, 0,0.1f),
              new Shoot(cShooter, cSillyGuy, 0.75)
            )
          );
  }
}
