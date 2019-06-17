package cc3002;

import cc3002.visitor.card.ICardVisitor;

/**
 * This class implements the ICard interface.
 *
 * @author F. Giovanni Sanguineti
 */
public abstract class AbstractCard implements ICard {
    private String cardName;
    private Trainer trainer;

    /**
     * Constructor that defines the AbstractCard.
     *
     * @param cardName String with the card's name.
     */
    public AbstractCard(String cardName) {
        this.cardName = cardName;
        this.trainer = null;
    }

    /**
     * Returns the card name.
     *
     * @return String with the card name.
     */
    @Override
    public String getCardName() {
        return this.cardName;
    }
    /**
     * Returns the trainer that plays the Pokemon.
     * @return a Trainer that played the Pokemon HP.
     */
    @Override
    public Trainer getTrainer() {
        return this.trainer;
    }

    /**
     * Set the trainer that owns the card.
     * @param aTrainer that owns the card.
     */
    @Override
    public void setTrainer(Trainer aTrainer) {
        this.trainer = aTrainer;
    }

    /**
     * add the card to the selected trainer's discard heap.
     * @param aTrainer that discard the card.
     */
    @Override
    public void discard(Trainer aTrainer) {
        aTrainer.getDiscardHeap().add(this);
    }

    /**
     * Allows a ICardVisitor visit the card.
     * @param v the Visitor that visits the card.
     */
    @Override
    public abstract void accept(ICardVisitor v);
}
