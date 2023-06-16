package frc.robot

import edu.wpi.first.wpilibj.RobotBase

class Main {
  companion object {
    public @JvmStatic fun main(args: Array<String>) {
      RobotBase.startRobot({Robot()})
    }
  }
}
