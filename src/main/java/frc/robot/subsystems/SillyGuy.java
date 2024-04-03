package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SillyGuy extends SubsystemBase{
    //while (robot.enabled){
    //  robot.work;    
    //}
    CANSparkMax sillyMotor;
    XboxController ratherSillyController;
    public SillyGuy(int SillyMotor, int RatherGoofyController){
        sillyMotor = new CANSparkMax(SillyMotor, MotorType.kBrushless);
        ratherSillyController = new XboxController(RatherGoofyController);
    }
    public void Vroom(float zooooom){
    sillyMotor.set(-0);
        if (ratherSillyController.getRightBumper()){
            sillyMotor.set(zooooom);
        }
        if (ratherSillyController.getLeftBumper()){
            sillyMotor.set(-zooooom);
        }
    }
    public void SillyVroom(float sillyZooooom){
        sillyMotor.set(sillyZooooom);
    }
}
