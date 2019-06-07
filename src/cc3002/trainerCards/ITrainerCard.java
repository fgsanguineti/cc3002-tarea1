package cc3002.trainerCards;
import cc3002.ICard;

interface ITrainerCard extends ICard {
    String getDescription();
    void doSelectedEffect();
}
