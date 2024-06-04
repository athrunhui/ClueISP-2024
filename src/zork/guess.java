package zork;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class guess {
    private static ArrayList<String> weapons;
    private static ArrayList<String> rooms;
    private static ArrayList<String> people;

    private static Room murRoom;
    private boolean room = false;

    private static Item murWep;
    public boolean wep = false;

    private static String murPers;

    private String guessW;
    private String guessR;
    private String guessP;

    public boolean guessWep(Scanner in){
        System.out.print("\u001B[?25l");  // Hide the cursor
        boolean isValid = false;
        String result = "";
        while(!isValid){
            System.out.print("(y/n): ");
            try{
                result = (in.nextLine()).toLowerCase(); //turns next thing put to lowercase
                if ((result.equals("n"))||(result.equals("y"))){
                    isValid = true; //if it is y or n continue to line 61
                }
            }catch(InputMismatchException badThing){
                System.out.println("Please enter y or n."); //if it is not y or n, prompt again
            }
        }
        if (result.equals("n")){ //if answer is n end game, otherwise play new game
            System.out.println("Thanks for playing.");
            return true;
        }  
        return false;
    }
    public void printCorrect(){
        System.out.println("The murder weapon used was the " + murWep.getName() + 
                           ", the room the murder took place in was the " + murRoom.getRoomName() +
                           ", and the person who committed the murder was " + murPers + ".");
    }

    public void printLists(){
        for(String a : weapons)
            System.out.println(a);
        for(String b : rooms)
            System.out.println(b);
        for(String c : people)
            System.out.println(c);
    }

    // lists
    public static ArrayList<String> getWeapons() {
        return weapons;
    }
    public static void setWeapons(ArrayList<String> weapons) {
        guess.weapons = weapons;
    }
    public static ArrayList<String> getRooms() {
        return rooms;
    }
    public static void setRooms(ArrayList<String> rooms) {
        guess.rooms = rooms;
    }
    public static ArrayList<String> getPeople() {
        return people;
    }
    public static void setPeople(ArrayList<String> people) {
        guess.people = people;
    }

    // rooms

    public Room getMurRoom() {
        return murRoom;
    }

    public static void setMurRoom(Room murRoom) {
        guess.murRoom = murRoom;
    }

    public boolean isRoomFound() {
        return room;
    }

    public void setRoomFound(boolean foundRoom) {
        this.room = foundRoom;
    }

    //  weapons
    public Item getMurWep() {
        return murWep;
    }
    
    public static void setMurWep(Item murWep) {
        guess.murWep = murWep;
    }

    public boolean isWepFound() {
        return wep;
    }

    public void setWepFound(boolean foundWep) {
        this.wep = foundWep;
    }

    //  person
    public String getMurPers() {
        return murPers;
    }

    public static void setMurPers(String murPers) {
        guess.murPers = murPers;
    }    
}
