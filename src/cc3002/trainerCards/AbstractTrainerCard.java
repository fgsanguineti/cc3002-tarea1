package cc3002.trainerCards;

import cc3002.Trainer;


public class AbstractTrainerCard implements ITrainerCard {
    private String cardName;
    private String description;

    AbstractTrainerCard(String cardName, String description) {
        this.cardName = cardName;
        this.description = description;
    }
    @Override
    public String getCardName() {
        return this.cardName;
    }

    @Override
    public void playCard(Trainer aTrainer) {
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void doSelectedEffect() {
    }
}
