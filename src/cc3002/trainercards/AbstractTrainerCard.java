package cc3002.trainercards;

import cc3002.AbstractCard;
import cc3002.abilities.effects.IEffect;
import cc3002.visitor.card.ICardVisitor;


public abstract class AbstractTrainerCard extends AbstractCard implements ITrainerCard {
    private String description;
    private IEffect effect;

    AbstractTrainerCard(String cardName, String description, IEffect anEffect) {
        super(cardName);
        this.description = description;
        this.effect = anEffect;
    }

    @Override
    public abstract void accept(ICardVisitor v);

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void doSelectedEffect() {
        effect.doEffect();
    }

    @Override
    public IEffect getEffect() {
        return this.effect;
    }

}
