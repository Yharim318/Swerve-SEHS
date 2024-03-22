package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;

public class Intake{
  private CANSparkMax IntakeMotor1;
  private CANSparkMax IntakeMotor2;
  //private CANSparkMax IntakeMotor3;
  public XboxController cXboxController;
  float speed = 0.4f;

  public float getSpeed(){
    return speed;
  }
  public Intake(int intakemotor1, int intakemotor2, int intakeMotor3, int controller ){
    IntakeMotor1 = new CANSparkMax(intakemotor1, MotorType.kBrushless);
    IntakeMotor2 = new CANSparkMax(intakemotor2, MotorType.kBrushless);
    //IntakeMotor3 = new CANSparkMax(intakeMotor3, MotorType.kBrushless);
    IntakeMotor2.setInverted(false);
    IntakeMotor1.setInverted(false);
    //IntakeMotor3.setInverted(true);

    cXboxController = new XboxController(controller);

    IntakeMotor1.setIdleMode(IdleMode.kBrake);
    IntakeMotor2.setIdleMode(IdleMode.kBrake);
    //IntakeMotor3.setIdleMode(IdleMode.kBrake);
  }
  public void Move(){
    IntakeMotor1.set(0);
    IntakeMotor2.set(0);
    //IntakeMotor3.set(0);
    if (cXboxController.getAButton()){
      IntakeMotor1.set(speed);
      IntakeMotor2.set(speed);
      //IntakeMotor3.set(speed);
    }
    else if (cXboxController.getBButton()){
      IntakeMotor1.set(-speed);
      IntakeMotor2.set(-speed);
      //IntakeMotor3.set(-speed);
    }
  }
  public void Start(){
    IntakeMotor1.set(speed);
    IntakeMotor2.set(speed);
    //IntakeMotor3.set(speed);
  }
  public void Stop(){
    IntakeMotor1.set(0);
    IntakeMotor2.set(0);
    //IntakeMotor3.set(0);
  }
}


