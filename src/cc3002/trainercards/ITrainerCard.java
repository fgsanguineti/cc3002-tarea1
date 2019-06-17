package cc3002.trainercards;

import cc3002.abilities.effects.IEffect;

/**
 * Common interface for all the TrainerCards, that also is a card.
 *
 * @author F. Giovanni Sanguineti
 */
public interface ITrainerCard {
    String getDescription();

    void doSelectedEffect();

    int getParameter();

    IEffect getEffect();
}
