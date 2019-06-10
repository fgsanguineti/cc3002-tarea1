package cc3002;

import cc3002.cardvisitors.ICardVisitor;

public abstract class AbstractCard implements ICard {
    private String cardName;
    private Trainer trainer;

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
     *
     * @return a Trainer that played the Pokemon HP.
     */
    @Override
    public Trainer getTrainer() {
        return this.trainer;
    }

    @Override
    public void setTrainer(Trainer aTrainer) {
        this.trainer = aTrainer;
    }

    @Override
    public void discard(Trainer aTrainer) {
        aTrainer.getDiscardHeap().add(this);
    }

    @Override
    public abstract void accept(ICardVisitor v);
}
