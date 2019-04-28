package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;

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
        other.receiveFightingEnergy(this);
    }

}
