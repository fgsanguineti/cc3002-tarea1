package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;

import java.util.Objects;

public class FightingEnergy extends AbstractEnergy {

    public FightingEnergy() {
        super.setCardName("Fighting Energy");
    }

    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveFightingEnergy(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FightingEnergy)) return false;
        FightingEnergy that = (FightingEnergy) o;
        return Objects.equals(super.getCardName(), that.getCardName());
    }
}
