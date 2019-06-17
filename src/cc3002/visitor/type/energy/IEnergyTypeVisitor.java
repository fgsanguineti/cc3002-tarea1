package cc3002.visitor.type.energy;

import cc3002.energies.*;

public interface IEnergyTypeVisitor {
    void visitElectricEnergy(ElectricEnergy electricEnergy);

    void visitFightingEnergy(FightingEnergy fightingEnergy);

    void visitFireEnergy(FireEnergy fireEnergy);

    void visitGrassEnergy(GrassEnergy grassEnergy);

    void visitPsychicEnergy(PsychicEnergy psychicEnergy);

    void visitWaterEnergy(WaterEnergy waterEnergy);
}
