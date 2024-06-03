package zork;

public class guess {
    private static Room murRoom;
    private static boolean foundRoom = false;

    private static Item murWep;
    public static boolean foundWep = false;

    private static String murPers;
    private static boolean foundPers = false;

    //  rooms

    public static Room getMurRoom() {
        return murRoom;
    }

    public static void setMurRoom(Room murRoom) {
        guess.murRoom = murRoom;
    }

    public static boolean isFoundRoom() {
        return foundRoom;
    }

    public static void setFoundRoom(boolean foundRoom) {
        guess.foundRoom = foundRoom;
    }

    //  weapons
    public static Item getMurWep() {
        return murWep;
    }
    
    public static void setMurWep(Item murWep) {
        guess.murWep = murWep;
    }

    public static boolean isFoundWep() {
        return foundWep;
    }

    public static void setFoundWep(boolean foundWep) {
        guess.foundWep = foundWep;
    }

    //  person
    public static String getMurPers() {
        return murPers;
    }

    public static void setMurPers(String murPers) {
        guess.murPers = murPers;
    }

    public static boolean isFoundPers() {
        return foundPers;
    }

    public static void setFoundPers(boolean foundPers) {
        guess.foundPers = foundPers;
    }
    
}
