public class Dragon {
    private int level;
    public static int health;
    private int attack;
    public static int dragonCount = 1;


    public Dragon() {
        level = (int) (Math.random() * 3) + 1;
        health = 100;
        if (level == 1) {
            attack = 10;
        } else if (level == 2) {
            attack = 15;
        } else {
            attack = 20;
        }
    }

    public int dragonAttack() {
        int bonusDmg = attack;
        int randNum = (int) (Math.random() * 5) + 1;
        if (randNum == 1) {
            bonusDmg += (int) (Math.random() * 10) + 1;
        }
        return bonusDmg;
    }

    public void dragonSetHealth(Player player) {
        health -= player.playerAttack();
    }

    public void setDragonHealth() {

    }
}
