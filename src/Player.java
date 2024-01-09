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

    public void playerAttack() {
        int bonusDmg = sword.getPlayerAttack();
        int randNum = (int) (Math.random() * 2) + 1;
        if (randNum == 1) {
            bonusDmg += (int) (Math.random() * 10) + 1;
            System.out.println("Your sword shines and has received critical damage!");
        }
        System.out.println("Your sword deals " + bonusDmg + " to the dragon");
        Dragon.health -= bonusDmg;
    }

    public void useHealthPot() {
        health += 50;
        healthPot = false;
    }
}
