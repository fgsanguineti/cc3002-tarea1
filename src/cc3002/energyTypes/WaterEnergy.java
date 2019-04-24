package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;

import java.util.Objects;

public class WaterEnergy extends AbstractEnergy {

    WaterEnergy() {
        super.setCardName("Water Energy");
    }

    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveWaterEnergy(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WaterEnergy)) return false;
        WaterEnergy that = (WaterEnergy) o;
        return Objects.equals(this.getCardName(), that.getCardName());
    }
}