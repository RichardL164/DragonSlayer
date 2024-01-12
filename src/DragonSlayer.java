import java.util.Scanner;
public class DragonSlayer {
    private Scanner scan;
    private boolean repeat;

    public DragonSlayer() {
        scan = new Scanner(System.in);
        repeat = true;
    }

    public void play() {
        System.out.println("Welcome...play the dragon game");
        System.out.print("What's your name? ");
        String name = scan.nextLine();
        Player p1 = new Player(name);
        Room room = new Room(p1);
        while (repeat) {
            System.out.println("You have arrived in " + room.getRoomName());
            while (!room.roomCleared()) {
                Dragon dragon = new Dragon(p1);
                System.out.println("The dragon is level " + dragon.getLevel());
                System.out.println("Would you like to:\n1) search the room\n2) attack the dragon\n3) use a health pot\n4) spend your gold");
                int userChoice = scan.nextInt();
                scan.nextLine();
                if (userChoice == 1) {
                    if (!room.roomSearched()) {
                        room.searchRoom();
                        if (room.getHasHealthPot()) {
                            System.out.println("You've found a health pot");
                        } else {
                            System.out.println("You did not find anything");
                        }
                    }
                }
                if
            }
        }
    }
}
