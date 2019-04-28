package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;


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
}
