import java.sql.SQLOutput;

public class Dragon {
    private int level;
    private int health;
    private int attack;
    private Player player;

    public Dragon(Player player) {
        level = (int) (Math.random() * 3) + 1;
        health = 100;
        attack = 10;
        this.player = player;
    }
    public void setDragonHealth(int damage) {
        health -= damage;
    }
    public int getAttack() {
        return attack;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }
    public int dragonAttack() {
        return level;
    }

    public void dragonReward() {
        if (health <= 0) {
            int randomChance = (int) (Math.random() * 100) + 1;
            if (randomChance <= 30) {
                int randomSwordChance = (int) (Math.random() * 2) + 1;
                if (randomSwordChance == 1) {
                    System.out.println("\nThe dragon gives you dodge chance");
                    player.getSword().setDodge(10);
                } else {
                    System.out.println("\nThe dragon gives you additional damage;");
                    player.getSword().setAttack(10);
                }
            } else if (randomChance <= 60) {
                System.out.println("\nThe dragon drops gold");
                player.setGold(randomChance);
            } else if (randomChance <= 90) {
                System.out.println("\nThe dragon gives you health");
                int addedHealth = (int) (0.5 * randomChance);
                player.setHealth(addedHealth);
            } else {
                System.out.println("\nNothing");
            }
        }
    }
}
