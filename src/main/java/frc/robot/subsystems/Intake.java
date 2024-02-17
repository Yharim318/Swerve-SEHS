package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;

public class Intake{
  CANSparkMax spinnyMotor1;
  CANSparkMax spinnyMotor2;
  CANSparkMax flippyMotor;
  XboxController sillyController;
  float funnySpinSpeed = 0.3f;
  float funnyFlipSpeed = 0.3f;

  public Intake(int SpinnyMotor1, int SpinnyMotor2, int FlippyMotor, int SillyController) {
    spinnyMotor1 = new CANSparkMax(SpinnyMotor1, MotorType.kBrushless);
    spinnyMotor2 = new CANSparkMax(SpinnyMotor2, MotorType.kBrushless);
    flippyMotor = new CANSparkMax(FlippyMotor, MotorType.kBrushless);
    sillyController = new XboxController(SillyController);
  }

  public void Move() {
    flippyMotor.set(funnyFlipSpeed * (sillyController.getRightTriggerAxis() - sillyController.getLeftTriggerAxis()));
    if (sillyController.getRightBumper()) {
      spinnyMotor1.set(funnySpinSpeed);
      spinnyMotor2.set(funnyFlipSpeed);
    }
  }
}
