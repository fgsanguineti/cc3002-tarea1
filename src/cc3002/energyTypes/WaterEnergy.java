package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;

public class WaterEnergy extends AbstractEnergy {

    public WaterEnergy() {
        super.setCardName("Water Energy");
    }

    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveWaterEnergy(this);
    }

}