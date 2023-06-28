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
import frc.robot.commands.TeleopDrive

class RobotContainer {

  val drive = Drive()
  val shooter = Shooter()
  val arms = Arms()
  val armSpinner = ArmSpinner()

  init {
    val joy = XboxController(0)
    JoystickButton(joy, 1)
    .onTrue(shooter.getShootCommand(arms, 0))
    .onFalse(shooter.getShootReleaseCommand(arms))

    JoystickButton(joy, 6)
    .onTrue(InstantCommand(arms::release, arms).andThen(WaitCommand(0.2)).andThen(InstantCommand(arms::rest, arms)))
    .onFalse(InstantCommand(arms::catch, arms))

    JoystickButton(joy, 3)
    .onTrue(shooter.getShootCommand(arms, 1))
    .onFalse(shooter.getShootReleaseCommand(arms))

    JoystickButton(joy, 4)
    .onTrue(shooter.getShootCommand(arms, 2))
    .onFalse(shooter.getShootReleaseCommand(arms))


    drive.defaultCommand = TeleopDrive(drive, joy, armSpinner)
  }

  public fun getAutonomousCommand(): Command? {
    return InstantCommand({
      print("bruh moment")
    })
  }
}