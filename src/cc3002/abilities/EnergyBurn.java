package cc3002.abilities;

import cc3002.abilities.effects.concrete.EnergyBurnEffect;
import cc3002.energytypes.EnergyContainer;

public class EnergyBurn extends Ability {
    public EnergyBurn() {
        super("Energy Burn", "As often as you like during your turn (before your attack) " +
                        "you may turn all Energy " + "attached to your Pokemon into type-of-yor-Pokemon Energies.",
                new EnergyContainer(0, 0, 0, 0, 0, 0),
                new EnergyBurnEffect());
    }
}
