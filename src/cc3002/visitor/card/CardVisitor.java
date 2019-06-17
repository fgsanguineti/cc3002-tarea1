package cc3002.visitor.card;

import cc3002.energytypes.AbstractEnergy;
import cc3002.pokemontypes.IBasicPokemon;
import cc3002.pokemontypes.IPhaseOnePokemon;
import cc3002.pokemontypes.IPhaseTwoPokemon;
import cc3002.trainercards.ObjectCard;
import cc3002.trainercards.StadiumCard;
import cc3002.trainercards.SupportCard;

public class CardVisitor implements ICardVisitor {
    @Override
    public void visitBasicPokemon(IBasicPokemon basicPokemon) {
    }

    @Override
    public void visitPhaseOnePokemon(IPhaseOnePokemon phaseOnePokemon) {

    }

    @Override
    public void visitPhaseTwoPokemon(IPhaseTwoPokemon phaseTwoPokemon) {

    }

    @Override
    public void visitEnergyCard(AbstractEnergy aEnergy) {

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
