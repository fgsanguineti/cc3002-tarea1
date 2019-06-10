package cc3002.energyTypes;

import cc3002.pokemontypes.IPokemon;


/**
 * This class defines the logic of a grass type energy.
 *
 * @author F. Giovanni Sanguineti.
 */
public class GrassEnergy extends AbstractEnergy {

    /**
     * Creates a new grass energy card.
     */
    public GrassEnergy() { super.setCardName("Grass Energy");
    }


    /**
     * {@inheritDoc}
     * @param other Pokemon that receives the energy.
     */
    @Override
    public void addEnergyToPokemon(IPokemon other) {
        if (other != null) other.receiveGrassEnergy(this);
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
        if (!(o instanceof GrassEnergy)) return false;
        GrassEnergy that = (GrassEnergy) o;
        return getCardName().equals(that.getCardName());
    }
}
