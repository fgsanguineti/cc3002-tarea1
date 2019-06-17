package cc3002.visitor.card;

import cc3002.energies.AbstractEnergy;
import cc3002.pokemon.IBasicPokemon;
import cc3002.pokemon.IPhaseOnePokemon;
import cc3002.pokemon.IPhaseTwoPokemon;
import cc3002.trainercards.ObjectCard;
import cc3002.trainercards.StadiumCard;
import cc3002.trainercards.SupportCard;

public interface ICardVisitor {
    void visitBasicPokemon(IBasicPokemon basicPokemon);

    void visitPhaseOnePokemon(IPhaseOnePokemon phaseOnePokemon);

    void visitPhaseTwoPokemon(IPhaseTwoPokemon phaseTwoPokemon);

    void visitEnergyCard(AbstractEnergy aEnergy);

    void visitObjectCard(ObjectCard aObject);

    void visitStadiumCard(StadiumCard aStadium);

    void visitSupportCard(SupportCard aSupport);
}

