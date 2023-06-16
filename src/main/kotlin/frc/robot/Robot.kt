package frc.robot

import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj2.command.CommandScheduler
import edu.wpi.first.wpilibj2.command.Command

class Robot: TimedRobot {
  constructor(): super()

  val robotContainer = RobotContainer()
  var autonCommand: Command? = null

  override fun robotInit() {}

  override fun robotPeriodic() {
    CommandScheduler.getInstance().run()
  }

  override fun disabledInit() {}

  override fun disabledPeriodic() {}

  override fun disabledExit() {}

  override fun autonomousInit() {
    autonCommand = robotContainer.getAutonomousCommand()
    autonCommand?.schedule()
  }

  override fun autonomousPeriodic() {}

  override fun autonomousExit() {}

  override fun teleopInit() {
    autonCommand?.cancel()
  }

  override fun teleopPeriodic() {}

  override fun teleopExit() {}

  override fun testInit() {
    CommandScheduler.getInstance().cancelAll()
  }

  override fun testPeriodic() {}

  override fun testExit() {}
}