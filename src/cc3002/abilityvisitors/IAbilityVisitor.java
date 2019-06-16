package cc3002.abilityvisitors;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;

public interface IAbilityVisitor {
    void visitAttack(Attack anAttack);

    void visitAbility(Ability anAbility);
}
