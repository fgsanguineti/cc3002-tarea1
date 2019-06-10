package cc3002.trainercards;
import cc3002.ICard;

interface ITrainerCard extends ICard {
    String getDescription();
    void doSelectedEffect();
}
