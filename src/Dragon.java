import java.sql.SQLOutput;

public class Dragon {
    private int level;
    private int health;
    private int attack;
    private Player player;

    public Dragon(Player player) {
        level = (int) (Math.random() * 3) + 1;
        health = 100;
        if (level == 1) {
            attack = 10;
        } else if (level == 2) {
            attack = 15;
        } else {
            attack = 20;
        }
        this.player = player;
    }

    public int dragonAttack() {
        int bonusDmg = attack;
        int randNum = (int) (Math.random() * 5) + 1;
        if (randNum == 1) {
            bonusDmg += (int) (Math.random() * 10) + 1;
        }
        return bonusDmg;
    }

    public void setDragonHealth(Player player) {
        health -= player.playerAttack();
    }

    public void dragonReward() {
        if (health <= 0) {
            int randomChance = (int) (Math.random() * 100) + 1;
            if (randomChance <= 30) {
                int randomSwordChance = (int) (Math.random() * 2) + 1;
                int addedCritOrDodge = (int) (0.75 * randomChance);
                if (randomSwordChance == 1) {
                    System.out.println("The dragon gives you crit");
                    player.getSword().setDodge(addedCritOrDodge);
                } else {
                    System.out.println("The dragon gives you dodge;");
                    player.getSword().setAttack(addedCritOrDodge);
                }
            } else if (randomChance <= 60) {
                System.out.println("The dragon drops gold");
                player.setGold(randomChance);
            } else if (randomChance <= 90) {
                System.out.println("The dragon gives you health");
                int addedHealth = (int) (0.5 * randomChance);
                player.setHealth(addedHealth);
            } else {
                System.out.println("Nothing");
            }
        }
    }
}
