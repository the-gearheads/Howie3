package frc.robot

import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.InstantCommand
import frc.robot.subsystems.Drive

class RobotContainer {

  val drive = Drive()

  init {
    
  }

  public fun getAutonomousCommand(): Command? {
    return InstantCommand({
      print("bruh moment")
    })
  }
}