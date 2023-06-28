package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj2.command.InstantCommand
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup
import edu.wpi.first.wpilibj2.command.WaitCommand
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.PneumaticsModuleType
import edu.wpi.first.wpilibj.Compressor

class Shooter: SubsystemBase{
    constructor():super()

    val comp = Compressor(0, PneumaticsModuleType.CTREPCM)

    val extendSolenoids = arrayListOf(
        Solenoid(PneumaticsModuleType.CTREPCM, 1),
        Solenoid(PneumaticsModuleType.CTREPCM, 2),
        Solenoid(PneumaticsModuleType.CTREPCM, 3),
    )
    val retractSolenoids = arrayListOf(
        Solenoid(PneumaticsModuleType.CTREPCM, 0),
    )
    
    init{
        comp.enableDigital()
        reset()
    }



    public fun shoot(power: Int){
        if(power > 3) return;
        setRetractSolenoids(false)
        for (i in 0..power) {
            extendSolenoids[i].set(true)
        }

    }

    public fun retract(){
        setExtendSolenoids(false)
        setRetractSolenoids(true)
    }

    public fun reset(){
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

    public fun getShootCommand(arm: Arms, power: Int): Command{
        return SequentialCommandGroup(
            InstantCommand(arm::release),
            WaitCommand(0.6),
            InstantCommand({this.shoot(power)}),
        )
    }

    public fun getShootReleaseCommand(arm: Arms): Command {
        return SequentialCommandGroup(
            WaitCommand(0.2),
            InstantCommand(arm::catch),
            InstantCommand(this::retract),
            WaitCommand(0.2),
            InstantCommand(this::reset)
        )

    }

}