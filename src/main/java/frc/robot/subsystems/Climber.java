package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase{
    private float speed = 1f;
    private CANSparkMax motor1;
    private CANSparkMax motor2;
    private XboxController xbox;
    public Climber(int Motor1, int Motor2, int Xbox){
        motor1 = new CANSparkMax(Motor1, MotorType.kBrushless);
        motor2 = new CANSparkMax(Motor2, MotorType.kBrushless);
        motor1.setIdleMode(IdleMode.kBrake);
        motor2.setIdleMode(IdleMode.kBrake);
        xbox = new XboxController(Xbox);
    }
    public void Climb(){
        motor1.set(0);
        motor2.set(0);
        float fast = speed;
        
        if (xbox.getXButton()){
            fast = -fast;
        }        
        motor1.set(-(fast * xbox.getRightTriggerAxis()));
        motor2.set((fast * xbox.getLeftTriggerAxis()));
        
    }
    @Override
    public void periodic(){
        Climb();
    }
}
