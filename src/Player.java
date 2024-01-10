public class Player {
    private String name;
    public static int health = 100;
    private int gold;
    private boolean healthPot;
    private Sword sword;

    public Player(String name) {
        this.name = name;
        gold = 0;
        healthPot = false;
        sword = new Sword();
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
        int dodge = (int) (Math.random() * 100) + 1;
        if (Sword.dodge <= dodge) {
            health -= dragon.dragonAttack();
        }
    }
    public void useHealthPot() {
        health += 50;
        healthPot = false;
    }
}
