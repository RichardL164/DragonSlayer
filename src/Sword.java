public class Sword {
    private int attack;
    public static int dodge = 2;

    public Sword() {
        attack = 10;
    }

    public int getPlayerAttack() {
        return attack;
    }

    public int getDodge() {
        return dodge;
    }
    public void setAttack(int addDamage) {
        attack += addDamage;
    }

    public void setDodge(int addChance) {
        dodge += addChance;
    }

}
