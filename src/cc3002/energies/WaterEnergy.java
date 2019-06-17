package cc3002.energies;

import cc3002.pokemon.IPokemon;

/**
 * This class defines the logic of a electric type energy.
 *
 * @author F. Giovanni Sanguineti
 */
public class WaterEnergy extends AbstractEnergy {

    /**
     * Creates a new water energy card.
     */
    public WaterEnergy() {
        super("Water Energy");
    }

    /**
     * {@inheritDoc}
     * @param other Pokemon that receives the energy.
     */
    @Override
    public void addEnergyToPokemon(IPokemon other) {
        if (other != null) other.receiveWaterEnergy(this);
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
        if (!(o instanceof WaterEnergy)) return false;
        WaterEnergy that = (WaterEnergy) o;
        return getCardName().equals(that.getCardName());
    }
}