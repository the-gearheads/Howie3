package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.PneumaticsModuleType

class Shooter: SubsystemBase{
    constructor():super()

    val extendSolenoids = arrayListOf(
        Solenoid(PneumaticsModuleType.CTREPCM, 1),
        Solenoid(PneumaticsModuleType.CTREPCM, 2),
        Solenoid(PneumaticsModuleType.CTREPCM, 3),
    )
    val retractSolenoids = arrayListOf(
        Solenoid(PneumaticsModuleType.CTREPCM, 0),
    )
    
    init{
        rest()
    }



    public fun shoot(){
        setExtendSolenoids(true)
        setRetractSolenoids(false)
    }

    public fun retract(){
        setExtendSolenoids(false)
        setRetractSolenoids(true)
    }

    public fun rest(){
        setExtendSolenoids(false)
        setRetractSolenoids(false)
    }

    public fun setExtendSolenoids(isOn: Boolean){
        for(extendSolenoid in extendSolenoids){
            extendSolenoid.set(isOn)
        }
    }
    public fun setRetractSolenoids(isOn: Boolean){
        for(retractSolenoid in retractSolenoids){
            retractSolenoid.set(isOn)
        }
    }
}