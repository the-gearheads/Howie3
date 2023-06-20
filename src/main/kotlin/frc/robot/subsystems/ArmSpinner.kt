package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj.motorcontrol.Spark
import frc.robot.commands.SpinArm
import edu.wpi.first.wpilibj.XboxController


class ArmSpinner: SubsystemBase{

    constructor():super()
    val spinMotor = Spark(0)

    init{
        this.defaultCommand = SpinArm(this, XboxController(1))
    }


   
    public fun spin(effort: Double){
        spinMotor.set(effort)
    }
}