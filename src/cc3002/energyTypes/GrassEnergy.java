package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;

import java.util.Objects;

public class GrassEnergy extends AbstractEnergy {

    GrassEnergy() { super.setCardName("Grass Energy");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrassEnergy)) return false;
        GrassEnergy that = (GrassEnergy) o;
        return Objects.equals(super.getCardName(), that.getCardName());
    }

    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveGrassEnergy(this);
    }
}
