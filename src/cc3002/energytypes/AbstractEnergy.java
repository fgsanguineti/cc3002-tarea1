package cc3002.energytypes;


import cc3002.AbstractCard;
import cc3002.pokemontypes.IPokemon;
import cc3002.visitor.card.ICardVisitor;

/**
 * This class implements the IPokemon interface.
 *
 * @author F. Giovanni Sanguineti
 */
public abstract class AbstractEnergy extends AbstractCard implements IEnergy {

    AbstractEnergy(String cardName) {
        super(cardName);
    }

    @Override
    public void accept(ICardVisitor v) {
        v.visitEnergyCard(this);
    }
    /**
     * Add the energy to a target Pokemon
     *
     * @param other Pokemon that receives the energy.
     */
    @Override
    public abstract void addEnergyToPokemon(IPokemon other);

    /**
     * Check if the energy object are the same that the target energy object.
     *
     * @param o The target energy object.
     * @return True if both are equals, false otherwise.
     */

    @Override

    public abstract boolean equals(Object o);
}
