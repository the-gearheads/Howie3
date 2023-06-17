package frc.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.Subsystem
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.math.MathUtil
import frc.robot.subsystems.Drive

const val DEADBAND = 0.02

class TeleopDrive(val drive: Drive, val joy: XboxController): CommandBase() {

    init {
      addRequirements(drive)
      drive.drive(0.0, 0.0)
    }

    override fun execute() {
      drive.drive(MathUtil.applyDeadband(-joy.getLeftY(), DEADBAND), MathUtil.applyDeadband(-joy.getRightX(), DEADBAND))
    }
}