package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
  public CANSparkMax IntakeMotor1;
  public CANSparkMax IntakeMotor2;
  private SillyGuy sillyguy;
  public XboxController cXboxController;
  float speed = 0.2f;

  public float getSpeed(){
    return speed;
  }
  public Intake(int intakemotor1, int intakemotor2, int intakeMotor3, int controller, SillyGuy sillyGuy){
    IntakeMotor1 = new CANSparkMax(intakemotor1, MotorType.kBrushless);
    IntakeMotor2 = new CANSparkMax(intakemotor2, MotorType.kBrushless);
    this.sillyguy = sillyGuy;
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
      sillyguy.SillyVroom(speed);
    }
    else if (cXboxController.getBButton()){
      IntakeMotor1.set(-speed);
      IntakeMotor2.set(-speed);
      sillyguy.SillyVroom(-speed);
      //IntakeMotor3.set(-speed);
    }
  }
  public void Set(float speed_){
    IntakeMotor1.set(speed_);
    IntakeMotor2.set(speed_);
    sillyguy.SillyVroom(-speed_);
    //IntakeMotor3.set(speed);
  }
}


