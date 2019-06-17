package cc3002.trainercards;

import cc3002.AbstractCard;
import cc3002.abilities.effects.IEffect;
import cc3002.visitor.card.ICardVisitor;

/**
 * This class implements the ITrainerCard interface
 *
 * @author F. Giovanni Sanguineti
 */

public abstract class AbstractTrainerCard extends AbstractCard implements ITrainerCard {
    private String description;
    private IEffect effect;
    private int parameter;

    /**
     * Creates a new trainerCard.
     *
     * @param cardName    The name of the card.
     * @param description the card description.
     * @param anEffect    The Effect of the card
     * @param parameter   The X parameter for some Effects.
     */
    AbstractTrainerCard(String cardName, String description, IEffect anEffect, int parameter) {
        super(cardName);
        this.description = description;
        this.effect = anEffect;
        this.parameter = parameter;
    }

    @Override
    public abstract void accept(ICardVisitor v);

    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Do the card effect.
     */
    @Override
    public void doSelectedEffect() {
        effect.doEffect();
    }

    /**
     * Get the card effect.
     *
     * @return the effect of the card.
     */
    @Override
    public IEffect getEffect() {
        return this.effect;
    }

    /**
     * Get the card parameter.
     * @return the card parameter.
     */
    @Override
    public int getParameter() {
        return this.parameter;
    }

}
