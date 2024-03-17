package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;

public class Climber {
    private float speed = 0.3f;
    private CANSparkMax motor1;
    private CANSparkMax motor2;
    private XboxController xbox;
    public Climber(int Motor1, int Motor2, int Xbox){
        motor1 = new CANSparkMax(Motor1, MotorType.kBrushless);
        motor2 = new CANSparkMax(Motor2, MotorType.kBrushless);
        xbox = new XboxController(Xbox);
    }
    public void Climb(){
        motor1.set(0);
        motor2.set(0);
        float fast = speed;
        
        if (xbox.getAButton()){
            fast = -fast;
        }        
        float slow = fast / 10;
        if (xbox.getXButton()) {
            fast = slow;
        }
        motor1.set(-(fast * xbox.getRightTriggerAxis()));
        motor2.set((fast * xbox.getLeftTriggerAxis()));
        
    }
}
