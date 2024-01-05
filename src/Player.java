public class Player {
    private String name;
    private int health;
    private int gold;
    private boolean healthPot;
    private Sword sword;

    public Player(String name) {
        this.name = name;
        health = 100;
        gold = 0;
        healthPot = false;
        sword = new Sword();
    }

    public void attack() {
        int bonusDmg = sword.getAttack();
        int randNum = (int) (Math.random() * 2) + 1;
        if (randNum == 1) {
            bonusDmg += (int) (Math.random() * 10) + 1;
            System.out.println("Your sword shines and has received critical damage!");
        }

    }
}
