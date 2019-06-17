package cc3002.energies;

import cc3002.pokemon.IPokemon;


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
        super("Psychic Energy");
    }

    /**
     * {@inheritDoc}
     * @param other Pokemon that receives the energy.
     */
    @Override
    public void addEnergyToPokemon(IPokemon other) {
        if (other != null) other.receivePsychicEnergy(this);
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
