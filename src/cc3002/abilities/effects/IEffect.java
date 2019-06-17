package cc3002.abilities.effects;

import cc3002.ICard;
import cc3002.abilities.IAbility;

/**
 * Common interface for all the effects.
 *
 * @author F. Giovanni Sanguineti
 */
public interface IEffect {
    IAbility getAssociatedAbility();
    void setAssociatedAbility(IAbility anAbility);
    void doEffect();
    ICard getAssociatedCard();
    void setAssociatedCard(ICard aCard);
}

