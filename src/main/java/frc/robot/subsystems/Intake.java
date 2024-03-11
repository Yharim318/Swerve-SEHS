package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;

public class Intake{
  private CANSparkMax IntakeMotor1;
  private CANSparkMax IntakeMotor2;
  public XboxController cXboxController;
  float speed = 0.4f;

  public Intake(int intakemotor1, int intakemotor2, int controller ){
    IntakeMotor1 = new CANSparkMax(intakemotor1, MotorType.kBrushless);
    IntakeMotor2 = new CANSparkMax(intakemotor2, MotorType.kBrushless);
    // IntakeMotorX.setInverted(true);

    cXboxController = new XboxController(controller);

    IntakeMotor1.setIdleMode(IdleMode.kBrake);
    IntakeMotor2.setIdleMode(IdleMode.kBrake);
  }
  public void Move(){
    IntakeMotor1.set(0);
    IntakeMotor2.set(0);
    if (cXboxController.getAButton()){
      IntakeMotor1.set(speed);
      IntakeMotor2.set(speed);
    }
  }
  public void Start(){
    IntakeMotor1.set(speed);
    IntakeMotor2.set(speed);
  }
  public void Stop(){
    IntakeMotor1.set(0);
    IntakeMotor2.set(0);
  }
}


