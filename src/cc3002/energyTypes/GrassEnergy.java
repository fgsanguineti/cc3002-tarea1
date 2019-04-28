package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;


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
        other.receiveGrassEnergy(this);
    }
}
