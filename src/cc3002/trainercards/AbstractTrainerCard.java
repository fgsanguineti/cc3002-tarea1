package cc3002.trainercards;

import cc3002.Trainer;
import cc3002.cardvisitors.ICardVisitor;


public class AbstractTrainerCard implements ITrainerCard {
    private String cardName;
    private String description;
    private Trainer trainer;

    AbstractTrainerCard(String cardName, String description) {
        this.cardName = cardName;
        this.description = description;
    }
    @Override
    public String getCardName() {
        return this.cardName;
    }


    @Override
    public void accept(ICardVisitor v) {

    }

    @Override
    public Trainer getTrainer() {
        return this.trainer;
    }

    @Override
    public void setTrainer(Trainer aTrainer) {
        this.trainer = aTrainer;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void doSelectedEffect() {
    }
}
