package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics
import com.revrobotics.CANSparkMax;
import com.revrobotics.REVLibError;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.commands.TeleopDrive

class Drive: SubsystemBase {
  constructor(): super()

  private val leftFront = CANSparkMax(1, MotorType.kBrushless)
  private val leftRear = CANSparkMax(2, MotorType.kBrushless)
  private val rightFront = CANSparkMax(3, MotorType.kBrushless)
  private val rightRear = CANSparkMax(4, MotorType.kBrushless)
 
  private val diff = DifferentialDrive(leftFront, rightFront)

  init {
    leftFront.setCANTimeout(250);
    rightFront.setCANTimeout(250);
    leftRear.setCANTimeout(250);
    rightRear.setCANTimeout(250);

    leftFront.restoreFactoryDefaults()
    leftRear.restoreFactoryDefaults()
    rightFront.restoreFactoryDefaults()
    rightRear.restoreFactoryDefaults()

    rightFront.setInverted(true)
    rightRear.setInverted(true)

    leftRear.follow(leftFront)
    rightRear.follow(rightFront)


    leftFront.setCANTimeout(0);
    rightFront.setCANTimeout(0);
    leftRear.setCANTimeout(0);
    rightRear.setCANTimeout(0);
  }  

  public fun drive(x: Double, rot: Double) {
    diff.arcadeDrive(x, rot)
  }
}