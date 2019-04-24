package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;

import java.util.Objects;

public class FireEnergy extends AbstractEnergy {

    FireEnergy() { super.setCardName("Fire Energy");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FireEnergy)) return false;
        FireEnergy that = (FireEnergy) o;
        return Objects.equals(super.getCardName(), that.getCardName());
    }

    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveFireEnergy(this);
    }
}
