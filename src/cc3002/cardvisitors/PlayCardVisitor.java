package cc3002.cardvisitors;

import cc3002.Trainer;
import cc3002.energyTypes.AbstractEnergy;
import cc3002.pokemontypes.IBasicPokemon;
import cc3002.pokemontypes.IPhaseOnePokemon;
import cc3002.pokemontypes.IPhaseTwoPokemon;
import cc3002.trainercards.ObjectCard;
import cc3002.trainercards.StadiumCard;
import cc3002.trainercards.SupportCard;

public class PlayCardVisitor implements ICardVisitor {
    @Override
    public void visitBasicPokemon(IBasicPokemon basicPokemon) {
        Trainer theTrainer = basicPokemon.getTrainer();
        if ((theTrainer.getActivePokemon() == null)) theTrainer.setActivePokemon(basicPokemon);
        else if (theTrainer.getBench().size() < 5) theTrainer.getBench().add(basicPokemon);
    }

    @Override
    public void visitPhaseOnePokemon(IPhaseOnePokemon phaseOnePokemon) {
        Trainer theTrainer = phaseOnePokemon.getTrainer();
    }

    @Override
    public void visitPhaseTwoPokemon(IPhaseTwoPokemon phaseTwoPokemon) {

    }

    @Override
    public void visitEnergyCard(AbstractEnergy aEnergy) {
        aEnergy.addEnergyToPokemon(aEnergy.getTrainer().getActivePokemon());
    }

    @Override
    public void visitObjectCard(ObjectCard aObject) {
    }

    @Override
    public void visitStadiumCard(StadiumCard aStadium) {

    }

    @Override
    public void visitSupportCard(SupportCard aSupport) {

    }
}
