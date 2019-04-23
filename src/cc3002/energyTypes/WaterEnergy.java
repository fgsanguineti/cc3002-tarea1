package cc3002.energyTypes;

import cc3002.AbstractEnergy;

import java.util.Objects;

public class WaterEnergy extends AbstractEnergy {
    private String cardName = "Water Energy";

    public WaterEnergy() {
    }

    @Override
    public String getCardName() {
        return null;
    }

    @Override
    public void playCard() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WaterEnergy)) return false;
        WaterEnergy that = (WaterEnergy) o;
        return Objects.equals(cardName, that.cardName);
    }

}
