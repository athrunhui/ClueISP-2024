package zork;

public class guess {
    private static Room murRoom;
    
    private static Item murWep;
    
    private static String murPers;

    public static Room getMurRoom() {
        return murRoom;
    }

    public static void setMurRoom(Room murRoom) {
        guess.murRoom = murRoom;
    }

    public static Item getMurWep() {
        return murWep;
    }
    
    public static void setMurWep(Item murWep) {
        guess.murWep = murWep;
    }

    public static String getMurPers() {
        return murPers;
    }

    public static void setMurPers(String murPers) {
        guess.murPers = murPers;
    }
    
}
