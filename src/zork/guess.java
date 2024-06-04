package zork;

public class guess {
    private Room murRoom;
    private boolean room = false;

    private Item murWep;
    public boolean wep = false;

    //  rooms

    public Room getMurRoom() {
        return murRoom;
    }

    public void setMurRoom(Room murRoom) {
        this.murRoom = murRoom;
    }

    public boolean isRoomFound() {
        return room;
    }

    public  void setRoomFound(boolean foundRoom) {
        this.room = foundRoom;
    }

    //  weapons
    public  Item getMurWep() {
        return murWep;
    }
    
    public  void setMurWep(Item murWep) {
        this.murWep = murWep;
    }

    public  boolean isWepFound() {
        return wep;
    }

    public  void setWepFound(boolean foundWep) {
        this.wep = foundWep;
    }
    
}
