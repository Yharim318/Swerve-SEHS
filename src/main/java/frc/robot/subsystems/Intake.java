package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;

public class Intake{
  CANSparkMax intake1;
  CANSparkMax intake2;
  CANSparkMax intake3;
  public CANSparkMax rotate1;
  public CANSparkMax rotate2;
  XboxController controller;
  float Spin = 0.3f;
  float Flip = 0.3f;

  public Intake(int Intake1, int Intake2, int Intake3, int Rotate1, int Rotate2, int Controller) {
    intake1 = new CANSparkMax(Intake1, MotorType.kBrushless);
    intake2 = new CANSparkMax(Intake2, MotorType.kBrushless);
    intake3 = new CANSparkMax(Intake3, MotorType.kBrushless);
    rotate1 = new CANSparkMax(Rotate1, MotorType.kBrushless);
    rotate2 = new CANSparkMax(Rotate2, MotorType.kBrushless);
    controller = new XboxController(Controller);
  }

  public void Move() {
    rotate1.set(0);
    rotate2.set(0);
    intake1.set(0);
    intake2.set(0);
    intake3.set(0);
    if (controller.getRightBumper()) {
      rotate1.set(Flip);
      rotate2.set(-Flip);
    }
    else if (controller.getLeftBumperPressed()) {
      rotate1.set(-Flip);
      rotate2.set(Flip);
    }
    if (controller.getAButton()) {
      intake1.set(-Spin-0.2);
      intake2.set(-Spin-0.3);
      intake3.set(Spin+0.2);
    }
        if (controller.getBButton()) {
      intake1.set(-(-Spin-0.2));
      intake2.set(-(-Spin-0.3));
      intake3.set(-(Spin+0.2));
    }
  }
  public void IntakeManual(double speed){
    intake1.set(-(speed*1.5));
    intake2.set(-(speed*1.5));
    intake3.set(speed*1.5);
  }
  public void RotateManual(int direction){
    if (direction > 0){
      rotate1.set(0.3);
      rotate2.set(0.3);
    }
    if (direction < 0){
      rotate1.set(0.05);
      rotate2.set(-0.05);
    }
  }
}
