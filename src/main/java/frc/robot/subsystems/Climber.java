package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;

public class Climber {
    private float speed = 0.5f;
    private TalonFX motor1;
    private TalonFX motor2;
    private XboxController xbox;
    public Climber(int Motor1, int Motor2, int Xbox){
        motor1 = new TalonFX(Motor1);
        motor2 = new TalonFX(Motor2);
        xbox = new XboxController(Xbox);
    }
    public void Climb(){
        motor1.set(speed * xbox.getRightY());
        motor2.set(speed * xbox.getRightY());
    }
}
