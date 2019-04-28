package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;

/**
 * This class defines the logic of a electric type energy.
 *
 * @author F. Giovanni Sanguineti
 */
public class ElectricEnergy extends AbstractEnergy {

    /**
     * Creates a new electric energy card.
     * @author F. Giovanni Sanguineti.
     */
    public ElectricEnergy() {
        super.setCardName("Electric Energy");
    }

    /**
     * {@inheritDoc}
     * @param other Pokemon that receives the energy.
     */
    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receiveElectricEnergy(this);
    }

}