package frc.robot.subsystems;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;

public class Intake{
  CANSparkMax intake1;
  CANSparkMax intake2;
  public CANSparkMax intake3;
  TalonFX sushiRoller;
  public CANSparkMax rotate1;
  public CANSparkMax rotate2;
  XboxController controller;
  float Spin = 0.3f;
  float Flip = 0.3f;

  public Intake(int Intake1, int Intake2, int Intake3, int SushiRoller, int Rotate1, int Rotate2, int Controller) {
    intake1 = new CANSparkMax(Intake1, MotorType.kBrushless);
    intake2 = new CANSparkMax(Intake2, MotorType.kBrushless);
    intake3 = new CANSparkMax(Intake3, MotorType.kBrushless);
    sushiRoller = new TalonFX(SushiRoller);
    rotate1 = new CANSparkMax(Rotate1, MotorType.kBrushless);
    rotate2 = new CANSparkMax(Rotate2, MotorType.kBrushless);
    controller = new XboxController(Controller);
    rotate1.setIdleMode(IdleMode.kBrake);
    rotate2.setIdleMode(IdleMode.kBrake);
    intake1.setIdleMode(IdleMode.kBrake);
    intake2.setIdleMode(IdleMode.kBrake);
    intake3.setIdleMode(IdleMode.kBrake);
    sushiRoller.setNeutralMode(NeutralModeValue.Brake);
  }

  public void Move() {
    rotate1.set(0.05);
    rotate2.set(-0.05);
    intake1.set(0);
    intake2.set(0);
    intake3.set(0);
    sushiRoller.set(0);
    if (controller.getRightBumper()) {
      rotate1.set(Flip);
      rotate2.set(-Flip);
    }
    else if (controller.getLeftBumper()) {
      rotate1.set(-Flip/3);
      rotate2.set(Flip/3);
    }
    if (controller.getAButton()) {
      intake1.set(-Spin-0.2);
      intake2.set(-Spin-0.4);
      intake3.set(Spin+0.2);
      sushiRoller.set(Spin/2);
    }
    if (controller.getBButton()) {
      intake1.set(-(-Spin));
      intake2.set(-(-Spin-0.1));
      intake3.set(-(Spin+0.1));
    }
  }
  public void IntakeManual(){
    intake1.set(-Spin-0.2);
    intake2.set(-Spin-0.3);
    intake3.set(Spin+0.2);
    sushiRoller.set(Spin/2);
  }
  public void IntakeManualStop(){
    intake1.set(0);
    intake2.set(0);
    intake3.set(0);
    sushiRoller.set(0);
  }
  public void RotateManual(double direction){
    rotate1.set(direction);
    rotate2.set(direction);
  
  }
  public void ShooterIntake(){
    intake3.set(Spin);
    sushiRoller.set(Spin);
  }
}
