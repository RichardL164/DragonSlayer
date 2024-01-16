import java.util.Scanner;
public class DragonSlayer {
    private Scanner scan;
    private boolean repeat;
    private Player p1;
    private Room room;
    private Dragon dragon;

    public DragonSlayer() {
        scan = new Scanner(System.in);
        repeat = true;
    }

    public void play() {
        System.out.println("Welcome...play the dragon game");
        System.out.print("What's your name? ");
        String name = scan.nextLine();
        p1 = new Player(name);
        room = new Room(p1);
        while (repeat) {
            System.out.println("You have arrived in " + room.getRoomName());
            while (!room.roomCleared()) {
                dragon = new Dragon(p1);
                System.out.println("The dragon is level " + dragon.getLevel());
                while (p1.getHealth() > 0 && dragon.getHealth() > 0) {
                    System.out.println("Would you like to:\n1) search the room\n2) attack the dragon\n3) use a health pot\n4) spend your gold");
                    int userChoice = scan.nextInt();
                    scan.nextLine();
                    processChoice(userChoice);
                    if (dragon.getHealth() < 0) {
                        dragon.dragonReward();
                        break;
                    }
                    int randomDodge = (int) (Math.random() * 100) + 1;
                    if (p1.getSword().getDodge() > randomDodge) {
                        System.out.println("You dodge the dragons attack and take no damage");
                    } else {
                        System.out.println("The dragon deals " + dragon.dragonAttack() + " damage");
                    }
                }
            }
        }
    }

    public void processChoice(int num) {
        if (num == 1) {
            choice1();
        } else if (num == 2) {
            choice2();
        } else if (num == 3) {
            choice3();
        } else if (num == 4) {
            choice4();
        }
    }

    public void choice1() {
        if (!room.roomSearched()) {
            room.searchRoom();
            if (room.getHasHealthPot()) {
                System.out.println("You've found a health pot");
            } else {
                System.out.println("You did not find anything");
            }
        }
    }

    public void choice2() {
        int dmg = p1.playerAttack();
        if (dmg > p1.getSword().getPlayerAttack()) {
            System.out.println("Your sword shines and deals critical damage");
        }
        System.out.println("You deal " + dmg + " damage to the dragon");
        dragon.setDragonHealth(dmg);
    }

    public void choice3() {
        p1.useHealthPot();
        System.out.println("Your health increased by 50\nYou now have " + p1.getHealth() + " health");
    }

    public void choice4() {
//        implement later
    }
}
