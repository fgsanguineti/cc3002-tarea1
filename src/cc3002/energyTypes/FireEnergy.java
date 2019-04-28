package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;


public class FireEnergy extends AbstractEnergy {

    public FireEnergy() { super.setCardName("Fire Energy");
    }

    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveFireEnergy(this);
    }
}
