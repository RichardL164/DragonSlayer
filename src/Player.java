public class Player {
    private String name;
    private int health = 100;
    private int gold;
    private Sword sword;

    public Player(String name) {
        this.name = name;
        gold = 0;
        sword = new Sword();
    }

    public void setGold(int addedGold) {
        gold += addedGold;
    }
    public int getGold() {
        return gold;
    }

    public void setHealth(int health) {
        this.health += health;
    }

    public Sword getSword() {
        return sword;
    }
    public int getHealth() {
        return health;
    }
    public int playerAttack() {
        int bonusDmg = sword.getPlayerAttack();
        int randNum = (int) (Math.random() * 2) + 1;
        if (randNum == 1) {
            bonusDmg += (int) (Math.random() * 10) + 1;
        }
        return bonusDmg;
    }

    public void playerSetHealth(Dragon dragon) {
        int dodgeRandom = (int) (Math.random() * 100) + 1;
        if (Sword.dodge <= dodgeRandom) {
            health -= dragon.dragonAttack();
        }
    }

    public void useHealthPot() {
        health += 50;
    }
}
