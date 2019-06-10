package cc3002.trainercards;

import cc3002.AbstractCard;
import cc3002.cardvisitors.ICardVisitor;


public abstract class AbstractTrainerCard extends AbstractCard implements ITrainerCard {
    private String description;

    AbstractTrainerCard(String cardName, String description) {
        super(cardName);
        this.description = description;
    }

    @Override
    public void accept(ICardVisitor v) {
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void doSelectedEffect() {
    }
}
