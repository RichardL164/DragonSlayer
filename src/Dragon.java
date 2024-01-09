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
        return attack;
    }

    public void setDragonHealth()
}
