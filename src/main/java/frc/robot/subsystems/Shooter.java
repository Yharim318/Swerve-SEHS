package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;

public class Shooter {
    private CANSparkMax ShooterMotor1;
    private CANSparkMax ShooterMotor2;
    public XboxController cXboxControllerontroller;

    private float AmpMultiplier = 0.14f; // THIS NEEDS TO BE CALIBRATED 
    private float SpeakerMultiplier = 0.2f; // THIS NEEDS TO BE CALIBRATED 
    private float SetSpeed;

    public Shooter(int shooterMotor1, int shooterMotor2, int controller ){
        ShooterMotor1 = new CANSparkMax(shooterMotor1, MotorType.kBrushless);
        ShooterMotor2 = new CANSparkMax(shooterMotor2, MotorType.kBrushless);
        cXboxControllerontroller = new XboxController(controller);

        ShooterMotor1.setIdleMode(IdleMode.kBrake);
        ShooterMotor2.setIdleMode(IdleMode.kBrake);
    }
    public void Shoot(){
        if (cXboxControllerontroller.getYButton())

            SetSpeed = SpeakerMultiplier;
            
        else 

            SetSpeed = AmpMultiplier;

        ShooterMotor1.set((cXboxControllerontroller.getRightTriggerAxis() - cXboxControllerontroller.getLeftTriggerAxis()) * SetSpeed);
        ShooterMotor2.set(-(cXboxControllerontroller.getRightTriggerAxis() - cXboxControllerontroller.getLeftTriggerAxis()) * SetSpeed);
    }
}
