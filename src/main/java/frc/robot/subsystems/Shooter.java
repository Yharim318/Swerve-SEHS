package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;

public class Shooter {
    private final CANSparkMax ShooterMotor1;
    private final CANSparkMax ShooterMotor2;
    public XboxController WackyController;

    private static final float SetSpeed = 0.95f;

    public Shooter(int shooterMotor1, int shooterMotor2, int controller ){
        ShooterMotor1 = new CANSparkMax(shooterMotor1, MotorType.kBrushless);
        ShooterMotor2 = new CANSparkMax(shooterMotor2, MotorType.kBrushless);
        
        WackyController = new XboxController(controller);

        ShooterMotor1.setIdleMode(IdleMode.kBrake);
        ShooterMotor2.setIdleMode(IdleMode.kBrake);
        ShooterMotor2.setInverted(true);
    }
    public void Shoot(){
        ShooterMotor1.set((WackyController.getRightTriggerAxis() - WackyController.getLeftTriggerAxis()) * SetSpeed);
        ShooterMotor2.set((WackyController.getRightTriggerAxis() - WackyController.getLeftTriggerAxis()) * SetSpeed);
    }
        public void ShootManual(double speed){
        ShooterMotor1.set(speed);
        ShooterMotor2.set(speed);
    }
}
