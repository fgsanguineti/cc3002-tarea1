package cc3002.visitor.card;

import cc3002.energies.AbstractEnergy;

public class FrozenCityCardVisitor extends CardVisitor {
    @Override
    public void visitEnergyCard(AbstractEnergy aEnergy) {
        if (!aEnergy.getTrainer().getPokemonGameController().isAnEnergyPlayedInTurn())
            aEnergy.getTrainer().getSelectedPokemon().modifyHP(-10 * aEnergy.getTrainer().getPokemonGameController()
                    .viewActiveStadiumCard().getParameter());
    }

}
