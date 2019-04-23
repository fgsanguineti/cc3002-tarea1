package cc3002.energyTypes;

import cc3002.AbstractEnergy;

import java.util.Objects;

public class FightingEnergy extends AbstractEnergy {
    private String cardName = "Fighting Energy";

    FightingEnergy() {
    }

    @Override
    public String getCardName() {
        return cardName;
    }

    @Override
    public void playCard() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FightingEnergy)) return false;
        FightingEnergy that = (FightingEnergy) o;
        return Objects.equals(cardName, that.cardName);
    }
}
