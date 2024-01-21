import java.util.Scanner;
public class DragonSlayer {
    private Scanner scan;
    private boolean repeat;
    private Player p1;
    private Room room;
    private Dragon dragon;
    private int highScore = 0;

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
            System.out.println("\nYou have arrived in " + room.getRoomName());
            room.setDragonCount((int) (Math.random() * 3) + 1);
            System.out.println("There are " + room.getDragonCount() + " dragons");
            dragonSpawn();
            if (Room.currentRoom == 4) {
                System.out.println("You win the game! Would you like to play again? y/n: ");
                String ans = scan.nextLine();
                endingCheck(ans);
                Room.currentRoom = -1;
            }
            Room.currentRoom++;
            room.changeRoomName();
            room.setSearchPot();
        }
    }

    public void dragonSpawn() {
        while (!room.roomCleared()) {
            dragon = new Dragon(p1);
            System.out.println("The dragon is level " + dragon.getLevel());
            fightWithDragon();
            if (!repeat) {
                break;
            }
            System.out.println("There are " + room.getDragonCount() + " dragons");
        }
    }

    public void fightWithDragon() {
        while (p1.getHealth() > 0 && dragon.getHealth() > 0) {
            System.out.println("\nWould you like to:\n1) search the room\n2) attack the dragon\n3) use a health pot\n4) check gold amount");
            int userChoice = scan.nextInt();
            scan.nextLine();
            processChoice(userChoice);
            if (dragon.getHealth() <= 0) {
                dragon.dragonReward();
                room.setDragonCount(-1);
                break;
            }
            dragonAttack();
            if (p1.getHealth() <= 0) {
                System.out.println("The dragon finishes you off! Do you want to play again? y/n ");
                String ans = scan.nextLine();
                endingCheck(ans);
                break;
            }
            checkStats();
        }
    }

    public void dragonAttack() {
        int randomDodge = (int) (Math.random() * 100) + 1;
        if (p1.getSword().getDodge() > randomDodge) {
            System.out.println("You dodge the dragons attack and take no damage");
        } else {
            int dmg = dragon.dragonAttack();
            p1.setHealth(-dmg);
            System.out.println("The dragon deals " + dmg + " damage to you");
            System.out.println("You are at " + p1.getHealth() + " health");
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
        } else {
            System.out.println("You checked the room already");
        }
    }

    public void choice2() {
        int dmg = p1.playerAttack();
        if (dmg > p1.getSword().getPlayerAttack()) {
            System.out.println("Your sword shines and deals critical damage");
        }
        dragon.setDragonHealth(dmg);
        System.out.println("You deal " + dmg + " damage to the dragon");
        if (dragon.getHealth() < 0) {
            System.out.println("The dragon is dead");
        } else {
            System.out.println("The dragon is at " + dragon.getHealth() + " health\n");
        }
    }

    public void choice3() {
        if (Room.hasHealthPot) {
            p1.useHealthPot();
            System.out.println("Your health increased by 50\nYou now have " + p1.getHealth() + " health");
        } else {
            System.out.println("You do not have a health pot");
        }
    }

    public void choice4() {
        System.out.println("You have " + p1.getGold() + " gold");
    }

    public void checkStats() {
        System.out.println("\n------------------------------");
        System.out.println("Current player stats");
        System.out.println("_______________");
        System.out.println("Base Damage: " + p1.getSword().getPlayerAttack());
        System.out.println("Health: " + p1.getHealth());
        System.out.println("Dodge Chance: " + p1.getSword().getDodge());
        System.out.println("Gold: " + p1.getGold());
        System.out.println("\nCurrent dragon stats");
        System.out.println("_______________");
        System.out.println("Base Damage: " + dragon.getAttack());
        System.out.println("Health: " + dragon.getHealth());
        System.out.println("------------------------------");
    }
    public void resetStats() {
        p1.setGold(-p1.getGold());
        p1.setHealth(-p1.getHealth() + 100);
        p1.getSword().setAttack(-p1.getSword().getPlayerAttack() + 10);
        p1.getSword().setDodge(-p1.getSword().getDodge() + 20);
    }
    public void endingCheck(String ans) {
        if (ans.equals("y")) {
            repeat = true;
        } else {
            repeat = false;
        }
        if (p1.getGold() > highScore) {
            highScore = p1.getGold();
        }
        resetStats();
        System.out.println("Current High Score: " + highScore + " gold");
    }
}
