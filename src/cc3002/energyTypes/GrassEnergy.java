package cc3002.energyTypes;

import cc3002.AbstractEnergy;

import java.util.Objects;

public class GrassEnergy extends AbstractEnergy {
    private String cardName = "Grass Energy";

    public GrassEnergy() {
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
        if (!(o instanceof GrassEnergy)) return false;
        GrassEnergy that = (GrassEnergy) o;
        return Objects.equals(cardName, that.cardName);
    }
}
