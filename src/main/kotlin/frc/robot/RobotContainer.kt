package frc.robot

import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.InstantCommand

class RobotContainer {
  init {

  }

  public fun getAutonomousCommand(): Command? {
    return InstantCommand({
      print("bruh moment")
    })
  }
}