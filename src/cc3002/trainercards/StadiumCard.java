package cc3002.trainercards;


import cc3002.abilities.effects.IEffect;
import cc3002.visitor.card.ICardVisitor;

/**
 * This class defines the logic of a StadiumCard.
 *
 * @author F. Giovanni Sanguineti
 */
public class StadiumCard extends AbstractTrainerCard {
    /**
     * Constructor for the ObjectCard class
     *
     * @param cardName    the card name
     * @param description the card description
     * @param effect      the card Effect
     * @param parameter   the X parameter for the card.
     */
    StadiumCard(String cardName, String description, IEffect effect, int parameter) {
        super(cardName, description, effect, parameter);
    }

    @Override
    public void accept(ICardVisitor v) {
        v.visitStadiumCard(this);
    }
}
