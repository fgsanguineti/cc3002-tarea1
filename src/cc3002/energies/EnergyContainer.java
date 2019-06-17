package cc3002.energies;

import java.util.HashMap;

/**
 * This class creates a EnergyContainer object that allows to store six energies quantity: electric, fighting, fire,
 * grass, psychic and water.
 *
 * @author F. Giovanni Sanguineti
 */
public class EnergyContainer {
    private HashMap<String, Integer> container = new HashMap<>();

    /**
     * Constructor for the EnergyContainer.
     * @param el quantity of electric energies to store.
     * @param fig quantity of fighting energies to store.
     * @param fir quantity of fire energies to store.
     * @param gr quantity of grass energies to store.
     * @param psy quantity of psychic energies to store.
     * @param wa quantity of water energies to store.
     */
    public EnergyContainer(int el, int fig, int fir, int gr, int psy, int wa) {
        container.put("Electric", el);
        container.put("Fighting", fig);
        container.put("Fire", fir);
        container.put("Grass", gr);
        container.put("Psychic", psy);
        container.put("Water", wa);
    }

    /**
     * Add one (1) energy of the specified type to the EnergyContainer.
     * @param type String with the name of the energy to add to the EnergyContainer. "Electric" adds 1 electric energy,
     *              Fighting adds 1 fighting energy, "Fire" adds 1 fire energy, "Grass" adds 1 grass energy,
     *             "Psychic" adds 1 psychic energy and "Water" adds 1 water energy.
     */
    public void addEnergy(String type) {
        int aux = container.get(type);
        aux++;
        container.replace(type, aux);
    }

    /**
     * Gets the number of electric energies
     * @return Integer with the value of electric energies available.
     */
    public int getElectric() {
        return container.get("Electric");
    }

    /**
     * Gets the number of fighting energies
     * @return Integer with the value of fighting energies available.
     */
    public int getFighting() {
        return container.get("Fighting");
    }

    /**
     * Gets the number of fire energies
     * @return Integer with the value of fire energies available.
     */
    public int getFire() {
        return container.get("Fire");
    }

    /**
     * Gets the number of grass energies
     * @return Integer with the value of grass energies available.
     */
    public int getGrass() {
        return container.get("Grass");
    }

    /**
     * Gets the number of psychic energies
     * @return Integer with the value of psychic energies available.
     */
    public int getPsychic() {
        return container.get("Psychic");
    }

    /**
     * Gets the number of water energies
     * @return Integer with the value of water energies available.
     */
    public int getWater() {
        return container.get("Water");
    }

    /**
     * Gets the total number of all energies
     *
     * @return Integer with the value of the total number of all energies
     */
    public int getTotalEnergyQuantity() {
        return this.getFighting() + this.getElectric() + this.getFire() + this.getGrass()
                + this.getPsychic() + this.getWater();
    }

    /**
     * Compares the EnergyContainer with another EnergyContainer.
     * @param o  Another EnergyContainer .
     * @return true if are equals. False otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnergyContainer)) return false;
        EnergyContainer that = (EnergyContainer) o;
        return container.equals(that.container);
    }
}
