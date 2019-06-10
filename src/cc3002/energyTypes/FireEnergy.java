package cc3002.energyTypes;

import cc3002.pokemontypes.IPokemon;


/**
 * This class defines the logic of a fire type energy.
 *
 * @author F. Giovanni Sanguineti.
 */
public class FireEnergy extends AbstractEnergy {

    /**
     * Creates a new fire energy card.
     * @author F. Giovanni Sanguineti.
     */
    public FireEnergy() { super.setCardName("Fire Energy");
    }

    /**
     * {@inheritDoc}
     * @param other Pokemon that receives the energy.
     */
    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveFireEnergy(this);
    }


    /**
     * {@inheritDoc}
     *
     * @param o The target energy object.
     * @return True if both are equals, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FireEnergy)) return false;
        FireEnergy that = (FireEnergy) o;
        return getCardName().equals(that.getCardName());
    }
}
