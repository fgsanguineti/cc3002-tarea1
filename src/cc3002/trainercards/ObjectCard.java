package cc3002.trainercards;

import cc3002.abilities.effects.IEffect;
import cc3002.visitor.card.ICardVisitor;

public class ObjectCard extends AbstractTrainerCard {
    public ObjectCard(String cardName, String description, IEffect effect) {
        super(cardName, description, effect);
    }

    @Override
    public void accept(ICardVisitor v) {
        v.visitObjectCard(this);
    }
}
