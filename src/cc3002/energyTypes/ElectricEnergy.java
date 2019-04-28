package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;

public class ElectricEnergy extends AbstractEnergy {

    public ElectricEnergy() {
        super.setCardName("Electric Energy");
    }

    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveElectricEnergy(this);
    }

}