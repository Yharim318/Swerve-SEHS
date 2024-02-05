package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;

public class Shooter {
    CANSparkMax ShooterMotor1;
    CANSparkMax ShooterMotor2;
    XboxController cXboxControllerontroller;
    float speedMultiplier = 0.5f;

    public Shooter(int shooterMotor1, int shooterMotor2, int controller ){
        ShooterMotor1 = new CANSparkMax(shooterMotor1, MotorType.kBrushless);
        ShooterMotor2 = new CANSparkMax(shooterMotor2, MotorType.kBrushless);
        cXboxControllerontroller = new XboxController(controller);

        ShooterMotor1.setIdleMode(IdleMode.kBrake);
        ShooterMotor2.setIdleMode(IdleMode.kBrake);
    }
    public void Shoot(){
        ShooterMotor1.set(cXboxControllerontroller.getRightTriggerAxis() - cXboxControllerontroller.getLeftTriggerAxis() * speedMultiplier);
        ShooterMotor2.set(-(cXboxControllerontroller.getRightTriggerAxis() - cXboxControllerontroller.getLeftTriggerAxis()) *speedMultiplier);
    }
}
