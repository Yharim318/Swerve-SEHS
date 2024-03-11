package frc.robot.autos;

import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class AutosTimer {
    public static void Start(int autoNumber, double autoTimer, RobotContainer m_robotContainer, Shooter cShooter, Intake cIntake){

    // Move Forward

    if (autoNumber == 0){
      if (autoTimer < 2.2 ){
        m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
      }
    }

    // Shoot and Move

    if (autoNumber == 7){
      if (autoTimer < 1){
        cShooter.ShootManual(0.8);
      }
      if (autoTimer > 1 && autoTimer < 2.2){
        cIntake.ShooterIntake();
      }
      if (autoTimer > 2.2 && autoTimer < 2.7){
        cIntake.IntakeManualStop();
        cShooter.ShootManual(0);
        m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
      }
    }
    //Middle 2 piece and leave
    if (autoNumber == 2){
        if (autoTimer < 1){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 1 && autoTimer < 2){
            cShooter.ShootManual(0);
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
            //intake
        }
        if (autoTimer > 2 && autoTimer < 3){
             m_robotContainer.s_Swerve.drive(new Translation2d(-10, 0), 0, true, false);
        }
        if (autoTimer > 3 && autoTimer < 4){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 4 && autoTimer < 4.5){
            cShooter.ShootManual(0);
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
        }
    }
    //Blue Middle 3 piece and leave
    if (autoNumber == 3){
        if (autoTimer < 1){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 1 && autoTimer < 2){
            cShooter.ShootManual(0);
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
            //intake
        }
        if (autoTimer > 2 && autoTimer < 3){
            m_robotContainer.s_Swerve.drive(new Translation2d(-10, 0), 0, true, false);
        }
        if (autoTimer > 3 && autoTimer < 4){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 4 && autoTimer < 4.5){
            cShooter.ShootManual(0);
            m_robotContainer.s_Swerve.drive(new Translation2d(0, 10), 0, true, false);
        }
        if (autoTimer > 4.5 && autoTimer < 5){
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
            //intake
        }
        if (autoTimer > 5 && autoTimer < 5.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(-10, 0), 0, true, false);
        }
        if (autoTimer > 5.5 && autoTimer < 6){
            m_robotContainer.s_Swerve.drive(new Translation2d(0, -10), 0, true, false);
        }
        if (autoTimer > 6 && autoTimer < 7){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 7 && autoTimer < 7.5){
            cShooter.ShootManual(0);
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
        }
    }
    //Blue left 
    if (autoNumber == 4){
        if (autoTimer < 1){
            m_robotContainer.s_Swerve.drive(new Translation2d(0, 0), 0.8, true, false); //TODO: rotation?
        }
        if (autoTimer > 1 && autoTimer < 2){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 2 && autoTimer < 3);
    }
}
}

