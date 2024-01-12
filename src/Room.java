public class Room {
    public static int room = 0;
    private int dragonCount;
    private String[] roomNames = new String[] {"the den", "the lair", "the cave", "the refuge", "the home"};
    private String roomName;
    private boolean searchPot;
    private boolean isHealthPotInRoom;
    public static boolean hasHealthPot = false;
    private Player player;

    public Room(Player player) {
        roomName = roomNames[room];
        room++;
        dragonCount = (int) (Math.random() * 3) + 1;
        searchPot = false;
        this.player = player;
        if ((int) (Math.random() * 2) + 1 == 1) {
            isHealthPotInRoom = true;
        } else {
            isHealthPotInRoom = false;
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean getHasHealthPot() {
        return hasHealthPot;
    }
    public boolean roomCleared() {
        return dragonCount == 0;
    }

    public boolean roomSearched() {
        return searchPot;
    }

    public void searchRoom() {
        if (isHealthPotInRoom) {
            hasHealthPot = true;
        }
        searchPot = true;
    }
}
