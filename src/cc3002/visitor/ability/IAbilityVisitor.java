package cc3002.visitor.ability;

import cc3002.abilities.Ability;
import cc3002.abilities.Attack;

public interface IAbilityVisitor {
    void visitAttack(Attack anAttack);

    void visitAbility(Ability anAbility);
}
