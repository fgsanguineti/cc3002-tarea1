package cc3002.abilities.effects;

import cc3002.ICard;
import cc3002.abilities.IAbility;

/**
 * This class implements the IEffect interface.
 *
 * @author F. Giovanni Sanguineti
 */
public abstract class AbstractEffect implements IEffect {
    private IAbility associatedAbility;
    private ICard associatedCard;

    /**
     * Returns the associated ability.
     *
     * @return the associated ability.
     */
    @Override
    public IAbility getAssociatedAbility() {
        return this.associatedAbility;
    }

    /**
     * Set the associated ability.
     *
     * @param anAbility ability to associate.
     */
    @Override
    public void setAssociatedAbility(IAbility anAbility) {
        this.associatedAbility = anAbility;
    }

    /**
     * Performs a effect.
     */
    @Override
    public abstract void doEffect();

    /**
     * get the associated card to the effect.
     *
     * @return the associated ICard.
     */
    @Override
    public ICard getAssociatedCard() {
        return this.associatedCard;
    }

    /**
     * set the associated card to the effect.
     *
     * @param aCard associated ICard.
     */
    @Override
    public void setAssociatedCard(ICard aCard) {
        this.associatedCard = aCard;
    }
}
