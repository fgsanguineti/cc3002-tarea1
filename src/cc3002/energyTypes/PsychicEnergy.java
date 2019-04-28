package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;


public class PsychicEnergy extends AbstractEnergy {

    public PsychicEnergy() {
        super.setCardName("Psychic Energy");
    }

    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receivePsychicEnergy(this);
    }
}
