package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;

import java.util.Objects;

public class ElectricEnergy extends AbstractEnergy {

    public ElectricEnergy() {
        super.setCardName("Electric Energy");
    }

    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveElectricEnergy(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricEnergy)) return false;
        ElectricEnergy that = (ElectricEnergy) o;
        return Objects.equals(super.getCardName(), that.getCardName());
    }
}