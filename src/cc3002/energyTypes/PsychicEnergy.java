package cc3002.energyTypes;

import cc3002.pokemontypes.IPokemon;


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


    /**
     * {@inheritDoc}
     *
     * @param o The target energy object.
     * @return True if both are equals, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PsychicEnergy)) return false;
        PsychicEnergy that = (PsychicEnergy) o;
        return getCardName().equals(that.getCardName());
    }
}
