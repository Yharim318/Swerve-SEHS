package frc.robot.autos;
import org.opencv.core.CvException;

import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.SillyGuy;

public class AutosTimer {

    public static float meter = 0.6f;

    public static void Start(int autoNumber, double autoTimer, RobotContainer m_robotContainer, Shooter cShooter, Intake cIntake, SillyGuy cSillyGuy){

    // Move Forward

    if (autoNumber == 0){
      if (autoTimer < meter ){
        m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
      }
    }

    // Shoot and Move

    if (autoNumber == 1){
      if (autoTimer < 1){
        cShooter.ShootManual(0.8);
      }
      if (autoTimer > 1 && autoTimer < 2.2){
        cSillyGuy.SillyVroom(cIntake.getSpeed());
      }
      if (autoTimer > 2.2 && autoTimer < 2.7){
        cSillyGuy.SillyVroom(0);
        cShooter.ShootManual(0);
        m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
      }
    }
    //Middle 2 piece and leave
    if (autoNumber == 2){
        if (autoTimer < 1){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 1 && autoTimer < 1.5){
            cSillyGuy.SillyVroom(cIntake.getSpeed());
        }
        if (autoTimer > 1.5 && autoTimer < 2.3){
            m_robotContainer.s_Swerve.drive(new Translation2d(3, 0), 0, true, false);
            cShooter.ShootManual(0);
            cSillyGuy.SillyVroom(0);
            cIntake.Start();
        }
        if (autoTimer > 2.8 && autoTimer < 3.6){
            m_robotContainer.s_Swerve.drive(new Translation2d(-3, 0), 0, true, false);
            cIntake.Stop();
            cSillyGuy.SillyVroom(-cIntake.getSpeed());
        }
        if (autoTimer > 3.7 && autoTimer < 4.4){
            cShooter.ShootManual(1);
        }
        if (autoTimer > 4.6 && autoTimer < 5){
            cSillyGuy.SillyVroom(cIntake.getSpeed());
        }
        if (autoTimer > 5 && autoTimer < 5.8){
            cShooter.ShootManual(0);
            cSillyGuy.SillyVroom(0);
            m_robotContainer.s_Swerve.drive(new Translation2d(3, 0), 0, true, false);
        }
    }
    //Blue Middle 3 piece and leave
    if (autoNumber == 3){
        if (autoTimer < 1){
            cShooter.ShootManual(0.8);
        }   
        if (autoTimer > 1 && autoTimer < 1.5){
            cSillyGuy.SillyVroom(cIntake.getSpeed());
        }
        if (autoTimer > 1.5 && autoTimer < 2.3){
            m_robotContainer.s_Swerve.drive(new Translation2d(3, 0), 0, true, false);
            cShooter.ShootManual(0);
            cSillyGuy.SillyVroom(0);
            cIntake.Start();
        }
        if (autoTimer > 2.8 && autoTimer < 3.6){
            m_robotContainer.s_Swerve.drive(new Translation2d(-3, 0), 0, true, false);
            cIntake.Stop();
            cSillyGuy.SillyVroom(-cIntake.getSpeed());
        }
        if (autoTimer > 3.7 && autoTimer < 4.4){
            cShooter.ShootManual(1);
        }
        if (autoTimer > 4.6 && autoTimer < 5){
            cSillyGuy.SillyVroom(cIntake.getSpeed());
        }
        if (autoTimer > 5 && autoTimer < 5.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(0, 10), 0, true, false);
        }
        if (autoTimer > 5.5 && autoTimer < 6){
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
            cIntake.Start();
        }
        if (autoTimer > 6 && autoTimer < 7){
            m_robotContainer.s_Swerve.drive(new Translation2d(-10, 0), 0, true, false);
            cIntake.Stop();
            cSillyGuy.SillyVroom(-cIntake.getSpeed());
        }
        if (autoTimer > 7 && autoTimer < 7.5){
           m_robotContainer.s_Swerve.drive(new Translation2d(0, -10), 0, true, false);
        }
        if (autoTimer > 7.5 && autoTimer < 8){
            cShooter.ShootManual(0.8);
            cSillyGuy.SillyVroom(cIntake.getSpeed());
        }
        if (autoTimer > 8 && autoTimer < 8.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
            cShooter.ShootManual(0);
            cSillyGuy.SillyVroom(0);
        }
    } 
    //Blue Middle 4 piece and leave
    //Blue left 3 piece and leave
    if (autoNumber == 4){
        if (autoTimer < 1){
            m_robotContainer.s_Swerve.drive(new Translation2d(0, 0), 0.8, true, false); //TODO: rotation?
        }
        if (autoTimer > 1 && autoTimer < 2){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 2 && autoTimer < 3){
            cShooter.ShootManual(0);
            m_robotContainer.s_Swerve.drive(new Translation2d(0, 0), 0.8, true, false); //TODO: rotation
        }
        if (autoTimer > 3 && autoTimer < 3.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(0, 10), 0, true, false);
        }
        if (autoTimer > 3.5 && autoTimer < 4.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
            cIntake.Start();
        }
        if (autoTimer > 4.5 && autoTimer < 5.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(-10, 0), 0, true, false);
            cIntake.Stop();
        }
        if (autoTimer > 5.5 && autoTimer < 6.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(0, -10), 0, true, false);
        }
        if (autoTimer > 6.5 && autoTimer < 7.5){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 7.5 && autoTimer < 8.5){
            cShooter.ShootManual(0);
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
            cIntake.Start();
        }
        if (autoTimer > 8.5 && autoTimer < 9.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(-10, 0), 0, true, false);
            cIntake.Stop();
        }
        if (autoTimer > 9.5 && autoTimer < 10.5){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 10.5 && autoTimer < 11.5){
            cShooter.ShootManual(0);
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
        }
    }
    //Right blue 
    if (autoNumber == 5){
        if (autoTimer < 1){
             m_robotContainer.s_Swerve.drive(new Translation2d(0, 0), 0.8, true, false); //TODO: rotation?
        }
        if (autoTimer > 1 && autoTimer < 2){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 2 && autoTimer < 3){
            cShooter.ShootManual(0);
            m_robotContainer.s_Swerve.drive(new Translation2d(0, 0), 0.8, true, false); //TODO: rotation?
        }
        if (autoTimer > 3 && autoTimer < 4.2){
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false); 
            cIntake.Start();
        }
        if (autoTimer > 4.2 && autoTimer < 5){
            m_robotContainer.s_Swerve.drive(new Translation2d(-10, 0), 0, true, false);
            cIntake.Stop(); 
        }
        if (autoTimer > 5 && autoTimer < 5.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(0, 10), 0, true, false); 
        }
        if (autoTimer > 5.5 && autoTimer < 6.5){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 6.5 && autoTimer < 7.5){
            cShooter.ShootManual(0);
            m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false); 
             cIntake.Start();
        }
        if (autoTimer > 7.5 && autoTimer < 8.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(-10, 0), 0, true, false); 
            cIntake.Stop();
        }
        if (autoTimer > 8.5 && autoTimer < 9.5){
            cShooter.ShootManual(0.8);
        }
        if (autoTimer > 9.5 && autoTimer > 10.5){
            cShooter.ShootManual(0.0);
        }
    }
    //Red Middle 3 piece
      if (autoNumber == 6){
        if (autoTimer < 1){
            cShooter.ShootManual(1);
        }   
        if (autoTimer > 1 && autoTimer < 1.5){
            cSillyGuy.SillyVroom(cIntake.getSpeed());
        }
        if (autoTimer > 1.5 && autoTimer < 2.3){
            m_robotContainer.s_Swerve.drive(new Translation2d(3, 0), 0, true, false);
            cShooter.ShootManual(0);
            cSillyGuy.SillyVroom(0);
            cIntake.Start();
        }
        if (autoTimer > 2.8 && autoTimer < 3.6){
            m_robotContainer.s_Swerve.drive(new Translation2d(-3, 0), 0, true, false);
            cIntake.Stop();
            cSillyGuy.SillyVroom(-cIntake.getSpeed());
        }
        if (autoTimer > 3.7 && autoTimer < 4.4){
            cShooter.ShootManual(1);
        }
        if (autoTimer > 4.6 && autoTimer < 5){
            cSillyGuy.SillyVroom(cIntake.getSpeed());
        }
        if (autoTimer > 5 && autoTimer < 5.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(0, -3), 0, true, false);
        }
        if (autoTimer > 5.5 && autoTimer < 6.3){
            m_robotContainer.s_Swerve.drive(new Translation2d(3, 0), 0, true, false);
            cIntake.Start();
        }
        if (autoTimer > 6.3 && autoTimer < 6.8){
            m_robotContainer.s_Swerve.drive(new Translation2d(0, 3), 0, true, false);
            cIntake.Stop();
            cSillyGuy.SillyVroom(-cIntake.getSpeed());
        }
        if (autoTimer > 6.8 && autoTimer < 7.6){
           m_robotContainer.s_Swerve.drive(new Translation2d(-3, 0), 0, true, false);
        }
        if (autoTimer > 7.6 && autoTimer < 8){
            cShooter.ShootManual(1);
            cSillyGuy.SillyVroom(cIntake.getSpeed());
        }
        if (autoTimer > 8 && autoTimer < 8.5){
            m_robotContainer.s_Swerve.drive(new Translation2d(3, 0), 0, true, false);
            cShooter.ShootManual(0);
            cSillyGuy.SillyVroom(0);
        }
    } 
}
}
