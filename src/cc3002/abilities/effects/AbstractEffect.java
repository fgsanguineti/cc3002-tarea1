package cc3002.abilities.effects;

import cc3002.ICard;
import cc3002.abilities.IAbility;

public abstract class AbstractEffect implements IEffect {
    private IAbility associatedAbility;
    private ICard associatedCard;

    @Override
    public IAbility getAssociatedAbility() {
        return this.associatedAbility;
    }

    @Override
    public void setAssociatedAbility(IAbility anAbility) {
        this.associatedAbility = anAbility;
    }

    @Override
    public abstract void doEffect();

    @Override
    public ICard getAssociatedCard() {
        return this.associatedCard;
    }

    @Override
    public void setAssociatedCard(ICard aCard) {
        this.associatedCard = aCard;
    }
}
