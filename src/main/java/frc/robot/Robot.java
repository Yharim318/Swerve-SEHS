// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.SillyGuy;
import frc.robot.autos.AutosTimer;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Intake;

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

  public int autoNumber = 0;
  private double autoTimer = 0.0f;
  private Shooter cShooter = new Shooter(31, 32, 33, 1);
  private Climber cClimber = new Climber(38, 39, 0);
  private Intake cIntake = new Intake(34, 35, 36, 1);
  private SillyGuy cSillyGuy = new SillyGuy(36, 1);
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private static final String kCustomAuto2 = "My Auto 2";
  private static final String kCustomAuto3 = "My Auto 3";
  private static final String kCustomAuto4 = "My Auto 4";
  private static final String kCustomAuto5 = "My Auto 5";
  private static final String kCustomAuto6 = "My Auto 6";
  private static final String kCustomAuto7 = "My Auto 7";
  private static final String kCustomAuto0 = "Do Nothing";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    CameraServer.startAutomaticCapture();

    m_chooser.setDefaultOption("Move Forward", kDefaultAuto);
    m_chooser.addOption("Shoot and Move", kCustomAuto);
    m_chooser.addOption("Do Nothing", kCustomAuto0);
    m_chooser.addOption("Middle 2 and leave", kCustomAuto2);
    m_chooser.addOption("Blue Middle 3 and leave", kCustomAuto3);
    m_chooser.addOption("Blue Left 3 and leave", kCustomAuto4);
     m_chooser.addOption("Right 3 and leave", kCustomAuto5);
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
    m_robotContainer.s_Swerve.drive(new Translation2d(0, 0), 0, false, false);
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);
    switch (m_autoSelected) {
      case kCustomAuto:
        autoNumber = 1;
        break;
      case kCustomAuto2:
       autoNumber = 2;
       break;
      case kCustomAuto3:
       autoNumber = 3;
       break;
      case kCustomAuto4:
       autoNumber = 4;
       break;
      case kCustomAuto5:
       autoNumber = 5;
       break;
      case kCustomAuto6:
       autoNumber = 6;
       break;
      case kCustomAuto7:
       autoNumber = 7;
       break;
      case kCustomAuto0:
       autoNumber = -1;
       break;
      case kDefaultAuto:
      default:
        autoNumber = 0;
        break;

    }
    
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
      m_autonomousCommand.cancel();
    }
    autoTimer = 0;
  }
  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

    // TODO: Work on changing to a more proper solution in the future

    autoTimer += kDefaultPeriod;
    AutosTimer.Start(autoNumber, autoTimer, m_robotContainer, cShooter, cIntake);
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
    cShooter.Shoot();
    cClimber.Climb();
    cIntake.Move();
    cSillyGuy.Vroom(cIntake.getSpeed());
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
