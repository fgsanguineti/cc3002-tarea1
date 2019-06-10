package cc3002.energyTypes;

import cc3002.pokemontypes.IPokemon;

/**
 * This class defines the logic of a Fighting type energy.
 *
 * @author F. Giovanni Sanguineti
 */
public class FightingEnergy extends AbstractEnergy {

    /**
     * Creates a new fighting energy card.
     * @author F. Giovanni Sanguineti.
     */
    public FightingEnergy() {
        super.setCardName("Fighting Energy");
    }

    /**
     * {@inheritDoc}
     * @param other Pokemon that receives the energy.
     */
    @Override
    public void addEnergyToPokemon(IPokemon other) {
        if (other != null) other.receiveFightingEnergy(this);
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
        if (!(o instanceof FightingEnergy)) return false;
        FightingEnergy that = (FightingEnergy) o;
        return getCardName().equals(that.getCardName());
    }
}
