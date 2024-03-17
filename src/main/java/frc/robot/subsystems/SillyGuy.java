package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;

public class SillyGuy {
    CANSparkMax sillyMotor;
    XboxController ratherSillyController;
    public SillyGuy(int SillyMotor, int RatherGoofyController){
        sillyMotor = new CANSparkMax(SillyMotor, MotorType.kBrushless);
        ratherSillyController = new XboxController(RatherGoofyController);
    }
    public void Vroom(float zooooom){
        if (ratherSillyController.getRightBumper()){
            sillyMotor.set(zooooom);
        }
    }
}
