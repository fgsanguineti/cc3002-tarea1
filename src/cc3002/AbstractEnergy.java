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
        this.addEnergyToPokemon(aTrainer.getActivePokemon());
    }
}
