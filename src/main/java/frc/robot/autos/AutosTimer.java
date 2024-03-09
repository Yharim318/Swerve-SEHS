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

    // Right Diagonal Red

    if (autoNumber == 1){
      if (autoTimer < 2) {
        m_robotContainer.s_Swerve.drive(new Translation2d(0, 0), -0.4, true, false);
      }
      if (autoTimer > 2 && autoTimer < 2.2){  
        m_robotContainer.s_Swerve.drive(new Translation2d(0,10),0, true, false);
      }
      if (autoTimer > 2.2 && autoTimer < 3){
        cShooter.ShootManual(0.8);
      }
      if(autoTimer > 3 && autoTimer < 3.1){
        cIntake.ShooterIntake();
      }
      if (autoTimer > 3.1 && autoTimer < 3.3){
        cIntake.IntakeManualStop();
        cShooter.ShootManual(0);
        m_robotContainer.s_Swerve.drive(new Translation2d(0,-10),0, true, false);
      }
      if (autoTimer > 3.3 && autoTimer < 5.3){
        m_robotContainer.s_Swerve.drive(new Translation2d(10,0),0, true, false);
      }
    }

    // Left Diagonal Red

    if (autoNumber == 4){
      if (autoTimer < 2) {
        m_robotContainer.s_Swerve.drive(new Translation2d(0, 0), -0.4, true, false);
      }
      if (autoTimer > 2 && autoTimer < 2.2){  
        m_robotContainer.s_Swerve.drive(new Translation2d(0,-10),0, true, false);
      }
      if (autoTimer > 2.2 && autoTimer < 3){
        cShooter.ShootManual(0.8);
      }
      if(autoTimer > 3 && autoTimer < 3.1){
        cIntake.ShooterIntake();
      }
      if (autoTimer > 3.1 && autoTimer < 3.8){
        cIntake.IntakeManualStop();
        cShooter.ShootManual(0);
        m_robotContainer.s_Swerve.drive(new Translation2d(0,10),0, true, false);
      }
      if (autoTimer > 3.8 && autoTimer < 5.8){
        m_robotContainer.s_Swerve.drive(new Translation2d(10,0),0, true, false);
      }
    }
// Right Diagonal Blue

    if (autoNumber == 6){
      if (autoTimer < 2) {
        m_robotContainer.s_Swerve.drive(new Translation2d(0, 0), -0.4, true, false);
      }
      if (autoTimer > 2 && autoTimer < 2.2){  
        m_robotContainer.s_Swerve.drive(new Translation2d(0,10),0, true, false);
      }
      if (autoTimer > 2.2 && autoTimer < 3){
        cShooter.ShootManual(0.8);
      }
      if(autoTimer > 3 && autoTimer < 3.1){
        cIntake.ShooterIntake();
      }
      if (autoTimer > 3.1 && autoTimer < 3.8){
        cIntake.IntakeManualStop();
        cShooter.ShootManual(0);
        m_robotContainer.s_Swerve.drive(new Translation2d(0,-10),0, true, false);
      }
      if (autoTimer > 3.8 && autoTimer < 5.8){
        m_robotContainer.s_Swerve.drive(new Translation2d(10,0),0, true, false);
      }
    }
// Left Diagonal Blue

    if (autoNumber == 1){
      if (autoTimer < 2) {
        m_robotContainer.s_Swerve.drive(new Translation2d(0, 0), 0.4, true, false);
      }
      if (autoTimer > 2 && autoTimer < 2.2){  
        m_robotContainer.s_Swerve.drive(new Translation2d(0,-10),0, true, false);
      }
      if (autoTimer > 2.2 && autoTimer < 3){
        cShooter.ShootManual(0.8);
      }
      if(autoTimer > 3 && autoTimer < 3.1){
        cIntake.ShooterIntake();
      }
      if (autoTimer > 3.1 && autoTimer < 3.3){
        cIntake.IntakeManualStop();
        cShooter.ShootManual(0);
        m_robotContainer.s_Swerve.drive(new Translation2d(0,10),0, true, false);
      }
      if (autoTimer > 3.3 && autoTimer < 5.3){
        m_robotContainer.s_Swerve.drive(new Translation2d(10,0),0, true, false);
      }
    }

    // Shoot, Wait, Strafe, Forward (Right)

    if (autoNumber == 3){
      if (autoTimer > 0 && autoTimer < 0.75){
        cShooter.ShootManual(0.8);
      }
      if (autoTimer > 0.75 && autoTimer < 2){
        cIntake.ShooterIntake();
      }
      if (autoTimer > 2 && autoTimer < 2.1){
        cShooter.ShootManual(0);
        cIntake.IntakeManualStop();
      }
      if (autoTimer > 5 && autoTimer < 6){
         m_robotContainer.s_Swerve.drive(new Translation2d(0, 10), 0, true, false);
      }
      if (autoTimer > 6 && autoTimer < 8.5){
         m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
      }
    }

    // Shoot, Wait, Strafe, Forward (Left)

    if (autoNumber == 3){
      if (autoTimer > 0 && autoTimer < 0.75){
        cShooter.ShootManual(0.8);
      }
      if (autoTimer > 0.75 && autoTimer < 2){
        cShooter.ShootManual(0.8);
        cIntake.ShooterIntake();
      }
      if (autoTimer > 2 && autoTimer < 2.1){
        cShooter.ShootManual(0);
        cIntake.IntakeManualStop();
      }
      if (autoTimer > 5 && autoTimer < 6){
         m_robotContainer.s_Swerve.drive(new Translation2d(0, -10), 0, true, false);
      }
      if (autoTimer > 6 && autoTimer < 8.5){
         m_robotContainer.s_Swerve.drive(new Translation2d(10, 0), 0, true, false);
      }
    }
    }
}
