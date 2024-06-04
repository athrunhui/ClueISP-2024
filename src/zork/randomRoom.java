package zork;

import java.util.ArrayList;

public class randomRoom {
    // private ArrayList<String> items;
    private ArrayList<String> rooms;

    public randomRoom(){
        rooms = new ArrayList<>();
        rooms.add("Lounge");
        rooms.add("Dining Room");
        rooms.add("Bathroom");
        rooms.add("Ballroom");
        rooms.add("Conservatory");
        rooms.add("Billiard Room");
        rooms.add("Library");
    }

    public String setRoomid(){
        int randInt = (int)(Math.random()*rooms.size());
        return rooms.remove(randInt);
    }

    public void testList(){
        for(String a: rooms){
            System.out.println(a);
        }
    }
}