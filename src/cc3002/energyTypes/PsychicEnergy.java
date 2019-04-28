package cc3002.energyTypes;

import cc3002.AbstractEnergy;
import cc3002.IPokemon;


/**
 * This class defines the logic of a psychic type energy.
 *
 * @author F. Giovanni Sanguineti.
 */
public class PsychicEnergy extends AbstractEnergy {

    /**
     * Creates a new psychic energy card.
     */
    public PsychicEnergy() {
        super.setCardName("Psychic Energy");
    }

    /**
     * {@inheritDoc}
     * @param other Pokemon that receives the energy.
     */
    @Override
    public void addEnergyToPokemon(IPokemon other) {
        other.receivePsychicEnergy(this);
    }
}
