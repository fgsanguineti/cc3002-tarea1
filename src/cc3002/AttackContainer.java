package cc3002;

public class AttackContainer {
    private Attack[] attackContainer;

    AttackContainer(Attack a, Attack b, Attack c, Attack d){
        attackContainer = new Attack[4];
        this.attackContainer[0] = a;
        this.attackContainer[1] = b;
        this.attackContainer[2] = c;
        this.attackContainer[3] = d;
    }
    Attack getAttack(int n){
        return this.attackContainer[n-1];
    }
}

