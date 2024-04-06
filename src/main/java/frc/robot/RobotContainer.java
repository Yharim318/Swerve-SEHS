package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.button.*;
import edu.wpi.first.wpilibj2.command.*;;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final Joystick driver = new Joystick(0);
    private final Joystick co_driver = new Joystick(1);

    /* Drive Controls */
    private final int translationAxis = XboxController.Axis.kLeftY.value;
    private final int strafeAxis = XboxController.Axis.kLeftX.value;
    private final int rotationAxis = XboxController.Axis.kRightX.value;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(driver, XboxController.Button.kY.value);
    private final JoystickButton robotCentric = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);
    private final JoystickButton xMode = new JoystickButton(driver, XboxController.Button.kRightBumper.value);

    /* Co_Driver Buttons */
    private final JoystickButton shootButton = new JoystickButton(co_driver, XboxController.Button.kY.value);
    private final JoystickButton sillyForwardButton = new JoystickButton(co_driver, XboxController.Button.kRightBumper.value);
    private final JoystickButton sillyBackwardButton = new JoystickButton(co_driver, XboxController.Button.kLeftBumper.value);
    private final JoystickButton intakeForwardButton = new JoystickButton(co_driver, XboxController.Button.kA.value);
    private final JoystickButton intakeBackwardButton = new JoystickButton(co_driver, XboxController.Button.kB.value);

    /* Subsystems */
    public final Swerve s_Swerve = new Swerve();
    public final Climber climber = Robot.cClimber;
    public final SillyGuy sillyGuy = Robot.cSillyGuy;
    public final Shooter shooter = Robot.cShooter;
    public final Intake intake = Robot.cIntake;


    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        s_Swerve.setDefaultCommand(
            new TeleopSwerve(
                s_Swerve, 
                () -> -driver.getRawAxis(translationAxis), 
                () -> -driver.getRawAxis(strafeAxis), 
                () -> -driver.getRawAxis(rotationAxis), 
                () -> robotCentric.getAsBoolean()
            )
        );

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {

        /* Driver Buttons */

        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroHeading()));

        xMode.whileTrue(s_Swerve.run(() -> {
            s_Swerve.setModuleStates(new SwerveModuleState[]{
                new SwerveModuleState(0.0, Rotation2d.fromDegrees(45)),
                new SwerveModuleState(0.0, Rotation2d.fromDegrees(-45)),
                new SwerveModuleState(0.0, Rotation2d.fromDegrees(-45)),
                new SwerveModuleState(0.0, Rotation2d.fromDegrees(45))
            });
        }));

        /* Co_driver Buttons */

        shootButton.onTrue(new Shoot(shooter, sillyGuy));

        sillyBackwardButton.whileTrue(new InstantCommand(() -> sillyGuy.SillyVroom(-intake.getSpeed())));
        sillyForwardButton.whileTrue(new InstantCommand(() -> sillyGuy.SillyVroom(intake.getSpeed())));
        
        intakeBackwardButton.whileTrue(new InstantCommand(() -> intake.Set(-intake.getSpeed())));
        intakeForwardButton.whileTrue(new InstantCommand(() -> intake.Set(intake.getSpeed())));
        
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */

    /* 
     *  
     * Use this if needed.
     * 
     * 
     * public Command getAutonomousCommand() {
     *   // An ExampleCommand will run in autonomous
     *  return null;
     * }
     */
}
