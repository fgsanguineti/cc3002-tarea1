package cc3002.abilityvisitors;

import cc3002.Trainer;
import cc3002.abilities.Ability;
import cc3002.abilities.Attack;

public class PlayAbilityVisitor implements IAbilityVisitor {
    @Override
    public void visitAttack(Attack anAttack) {
        Trainer opponent = anAttack.getAssociatedPokemon().getTrainer().getOpponent();
        anAttack.getAssociatedPokemon().getTrainer().getActivePokemon().setActiveAttack(anAttack);
        opponent.receiveAnAttack(anAttack.getAssociatedPokemon().getTrainer());
    }

    @Override
    public void visitAbility(Ability anAbility) {
    }
}
