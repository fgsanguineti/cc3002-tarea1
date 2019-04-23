package cc3002.energyTypes;

import cc3002.AbstractEnergy;

import java.util.Objects;

public class FireEnergy extends AbstractEnergy {
    private String cardName = "Fire Energy";

    public FireEnergy() {
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
        if (!(o instanceof FireEnergy)) return false;
        FireEnergy that = (FireEnergy) o;
        return Objects.equals(cardName, that.cardName);
    }

}
