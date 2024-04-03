package frc.robot.autos;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Swerve;


public class ThreePiece extends SequentialCommandGroup{
    public ThreePiece(Swerve s_Swerve){
        addCommands(new exampleAuto(s_Swerve, List.of(
            new Pose2d(), new Pose2d(), new Pose2d()
            )));
    }
}