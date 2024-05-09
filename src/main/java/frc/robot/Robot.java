// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {
  public static final CTREConfigs ctreConfigs = new CTREConfigs();

  private Command m_autonomousCommand;

  
  private RobotContainer m_robotContainer;

  Swerve s_Swerve;
  public static Shooter cShooter = new Shooter(31, 32, 1);
  public static Climber cClimber = new Climber(38, 39, 0);
  public static Intake cIntake = new Intake(34, 35, 36, 1);
  public static SillyGuy cSillyGuy = new SillyGuy(36, 1);
  private static final String Nothing = "Nothing";
  private static final String OnePiece = "One Piece";
  private static final String TwoPiece = "2 Piece";
  private static final String ThreePieceLeft = "3 Piece Left";
  private static final String ThreePieceRight = "3 Piece Right";
  private static final String FourPiece = "4 Piece";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {

    /*
     * if (robot.exists){
     *  bollean QualifiedForWorlds = true;
     *  boolean AtWorlds = true;
     * }
     */

    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    s_Swerve = m_robotContainer.s_Swerve;
    CameraServer.startAutomaticCapture().setFPS(10);
    m_chooser.setDefaultOption(Nothing, Nothing);
    m_chooser.addOption(OnePiece, OnePiece);
    m_chooser.addOption(TwoPiece, TwoPiece);
    m_chooser.addOption(ThreePieceLeft, ThreePieceLeft);
    m_chooser.addOption(ThreePieceRight, ThreePieceRight);
    m_chooser.addOption(FourPiece, FourPiece);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);
    switch (m_autoSelected) {
      case Nothing:
        m_autonomousCommand = new SequentialCommandGroup();
        break;
      case OnePiece:
        m_autonomousCommand = new Shoot(cShooter, cSillyGuy, 0.9);
        break;
      case TwoPiece:
        m_autonomousCommand = new SequentialCommandGroup(
          new Shoot(cShooter, cSillyGuy, 0.9),
          new MiddlePiece(s_Swerve, cIntake, cShooter, cSillyGuy)
          );
        break;
      case ThreePieceLeft:
        m_autonomousCommand = new SequentialCommandGroup(
          new Shoot(cShooter, cSillyGuy, 0.9),
          //new MiddlePiece(s_Swerve, cIntake, cShooter, cSillyGuy),
          new LeftPiece(s_Swerve, cIntake, cShooter, cSillyGuy)
          );
        break;
      case ThreePieceRight:
        m_autonomousCommand = new SequentialCommandGroup(
          new Shoot(cShooter, cSillyGuy, 0.9),
          new MiddlePiece(s_Swerve, cIntake, cShooter, cSillyGuy),
          new RightPiece(s_Swerve, cIntake, cShooter, cSillyGuy)
          );
        break;
      case FourPiece:
        m_autonomousCommand = new SequentialCommandGroup(
          new Shoot(cShooter, cSillyGuy, 0.9),
          new PrintInstant("shoot:finished"),
          new MiddlePiece(s_Swerve, cIntake, cShooter, cSillyGuy),
          new PrintInstant("middle:finished"),
          new RightPiece(s_Swerve, cIntake, cShooter, cSillyGuy),
          new PrintInstant("right:finished"),
          new LeftPiece(s_Swerve, cIntake, cShooter, cSillyGuy),
          new PrintInstant("left:finished")
          );
        break;
    }
    
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }
  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    cClimber.Climb();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
