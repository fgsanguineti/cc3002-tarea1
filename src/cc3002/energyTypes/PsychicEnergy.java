package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;

import java.util.Objects;

public class PsychicEnergy extends AbstractEnergy {

    public PsychicEnergy() {
        super.setCardName("Psychic Energy");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PsychicEnergy)) return false;
        PsychicEnergy that = (PsychicEnergy) o;
        return Objects.equals(this.getCardName(), that.getCardName());
    }

    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receivePsychicEnergy(this);
    }
}
