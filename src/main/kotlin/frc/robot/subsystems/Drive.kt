package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics
import com.revrobotics.REVLibError;
import com.revrobotics.RelativeEncoder;
import frc.robot.commands.TeleopDrive
import com.revrobotics.spark.SparkMax
import com.revrobotics.spark.SparkLowLevel.MotorType
import com.revrobotics.spark.config.SparkMaxConfig
import com.revrobotics.spark.SparkBase.ResetMode
import com.revrobotics.spark.SparkBase.PersistMode
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode

class Drive: SubsystemBase {
  constructor(): super()

  private val leftFront = SparkMax(2, MotorType.kBrushless)
  private val leftRear = SparkMax(3, MotorType.kBrushless)
  private val rightFront = SparkMax(4, MotorType.kBrushless)
  private val rightRear = SparkMax(5, MotorType.kBrushless)
 
  private val diff = DifferentialDrive(leftFront, rightFront)

  init {
    leftFront.setCANTimeout(250);
    rightFront.setCANTimeout(250);
    leftRear.setCANTimeout(250);
    rightRear.setCANTimeout(250);

    val commonConfig = SparkMaxConfig();
    commonConfig.idleMode(IdleMode.kCoast);

    val lfConfig = SparkMaxConfig().apply(commonConfig);
    val lrConfig = SparkMaxConfig().apply(commonConfig);
    val rfConfig = SparkMaxConfig().apply(commonConfig);
    val rrConfig = SparkMaxConfig().apply(commonConfig);
    
    rfConfig.inverted(true);
    rrConfig.inverted(true);

    lrConfig.follow(leftFront);
    rrConfig.follow(rightFront);

    leftFront.configure(lfConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    leftRear.configure(lrConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightFront.configure(rfConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightRear.configure(rrConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    leftFront.setCANTimeout(0);
    rightFront.setCANTimeout(0);
    leftRear.setCANTimeout(0);
    rightRear.setCANTimeout(0);
  }  

  public fun drive(x: Double, rot: Double) {
    diff.arcadeDrive(x, rot)
  }
}