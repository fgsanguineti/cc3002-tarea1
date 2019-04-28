package cc3002;

public abstract class AbstractEnergy implements IEnergy {
    private String cardName;

    @Override
    public String getCardName() {
        return this.cardName;
    }

    protected void setCardName(String cardName) {
        this.cardName = cardName;
    }
    @Override
    public void playCard(Trainer aTrainer) {
        if (aTrainer.getHand() != null)
            this.addEnergyToPokemon(aTrainer.getActivePokemon());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEnergy)) return false;
        AbstractEnergy that = (AbstractEnergy) o;
        return getCardName().equals(that.getCardName());
    }
}
