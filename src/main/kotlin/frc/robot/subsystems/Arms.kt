package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.PneumaticsModuleType

class Arms: SubsystemBase{

    constructor():super()

    val extendSolenoids = arrayListOf(
        Solenoid(PneumaticsModuleType.CTREPCM, 4),
    )

    val retractSolenoids = arrayListOf(
        Solenoid(PneumaticsModuleType.CTREPCM, 5),
    )


    init{
        catch()
    }

    public fun catch(){
        setExtendSolenoids(true)
        setRetractSolenoids(false)
    }

    public fun release(){
        setExtendSolenoids(false)
        setRetractSolenoids(true)
    }

    public fun rest(){
        setExtendSolenoids(false)
        setRetractSolenoids(false)
    }

    public fun setExtendSolenoids(isOn: Boolean){
        for(solenoid in extendSolenoids){
            solenoid.set(isOn)
        }
    }
    public fun setRetractSolenoids(isOn: Boolean){
        for(solenoid in retractSolenoids){
            solenoid.set(isOn)
        }
    }
}