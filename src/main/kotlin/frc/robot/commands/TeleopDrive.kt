package frc.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.Subsystem
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.math.MathUtil
import frc.robot.subsystems.Drive
import frc.robot.subsystems.ArmSpinner

const val DEADBAND = 0.02

class TeleopDrive(val drive: Drive, val joy: XboxController, val arm: ArmSpinner): CommandBase() {

    init {
      addRequirements(drive)
      addRequirements(arm)
      drive.drive(0.0, 0.0)
      arm.spin(0.0)
    }

    override fun execute() {
      drive.drive(MathUtil.applyDeadband(-joy.leftY * 0.5, DEADBAND), MathUtil.applyDeadband(-joy.leftX * 0.5, DEADBAND))
      val spin = MathUtil.applyDeadband(joy.rightY, DEADBAND)
      arm.spin(spin)
    }
}