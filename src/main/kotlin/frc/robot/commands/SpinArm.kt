package frc.robot.commands

import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.Subsystem
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.math.MathUtil
import frc.robot.subsystems.Drive
import frc.robot.subsystems.ArmSpinner

class SpinArm(val armSpinner: ArmSpinner, val joy: XboxController): CommandBase() {

    init {
      addRequirements(armSpinner)
      armSpinner.spin(0.0)
    }

    override fun execute() {

      armSpinner.spin(joy.getRightY() * 0.6)
      
    }
}