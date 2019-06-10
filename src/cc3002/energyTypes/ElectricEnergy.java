package cc3002.energyTypes;

import cc3002.pokemontypes.IPokemon;

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

    /**
     * {@inheritDoc}
     *
     * @param o The target energy object.
     * @return True if both are equals, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricEnergy)) return false;
        ElectricEnergy that = (ElectricEnergy) o;
        return getCardName().equals(that.getCardName());
    }
}