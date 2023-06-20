package frc.robot

import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.InstantCommand
import edu.wpi.first.wpilibj2.command.button.JoystickButton
import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.WaitCommand
import edu.wpi.first.wpilibj.XboxController
import frc.robot.subsystems.Drive
import frc.robot.subsystems.Shooter
import frc.robot.subsystems.Arms
import frc.robot.subsystems.ArmSpinner

class RobotContainer {

  val drive = Drive()
  val shooter = Shooter()
  val arms = Arms()
  val armSpinner = ArmSpinner()

  init {
    val joy = XboxController(1)
    JoystickButton(joy, 1)
    .onTrue(InstantCommand(shooter::shoot, shooter))
    .onFalse(InstantCommand(shooter::retract, shooter).andThen(WaitCommand(0.2)).andThen(InstantCommand(shooter::rest, shooter)))

    JoystickButton(joy, 2)
    .onTrue(InstantCommand(arms::catch, arms))
    .onFalse(InstantCommand(arms::release, arms).andThen(WaitCommand(0.2)).andThen(InstantCommand(arms::rest, arms)))
  }

  public fun getAutonomousCommand(): Command? {
    return InstantCommand({
      print("bruh moment")
    })
  }
}