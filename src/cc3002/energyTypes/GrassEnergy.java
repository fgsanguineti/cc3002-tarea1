package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;


public class GrassEnergy extends AbstractEnergy {

    public GrassEnergy() { super.setCardName("Grass Energy");
    }


    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveGrassEnergy(this);
    }
}
