package cc3002.energyTypes;

import cc3002.AbstractEnergy;

import java.util.Objects;

public class ElectricEnergy extends AbstractEnergy {
    private String cardName = "Electric Energy";

    ElectricEnergy() {
    }

    @Override
    public String getCardName() {return cardName;}

    @Override
    public void playCard() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricEnergy)) return false;
        ElectricEnergy that = (ElectricEnergy) o;
        return Objects.equals(cardName, that.cardName);
    }
}
