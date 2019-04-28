package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;

public class FightingEnergy extends AbstractEnergy {

    public FightingEnergy() {
        super.setCardName("Fighting Energy");
    }

    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveFightingEnergy(this);
    }

}
