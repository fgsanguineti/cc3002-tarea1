package cc3002;


/**
 * This class implements the IPokemon interface.
 *
 * @author F. Giovanni Sanguineti
 */
public abstract class AbstractEnergy implements IEnergy {
    private String cardName;

    /**
     * Returns the card name.
     * @return String with the card name.
     */
    @Override
    public String getCardName() {
        return this.cardName;
    }

    protected void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /** Let's a trainer plays a card.
     * @param aTrainer The trainer that plays the card.
     */
    @Override
    public void playCard(Trainer aTrainer) {
        if (aTrainer.getHand() != null)
            this.addEnergyToPokemon(aTrainer.getActivePokemon());
    }

    /**
     * Add the energy to a target Pokemon
     *
     * @param other Pokemon that receives the energy.
     */
    @Override
    public abstract void addEnergyToPokemon(IPokemon other);

    /**
     * Check if the energy object are the same that the target energy object.
     *
     * @param o The target energy object.
     * @return True if both are equals, false otherwise.
     */
    @Override

    public abstract boolean equals(Object o);
}
