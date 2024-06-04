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

    public void guessWep(Scanner in){
        System.out.print("\u001B[?25l");  // Hide the cursor
        boolean isValid = false;
        while(!isValid){
            System.out.println("What weapon do you think was used in the murder?");
            try{
                guessW = (in.nextLine()).toLowerCase(); //turns next thing put to lowercase
                for(String a : weapons){
                    if(guessW.equals(a.toLowerCase()))
                        isValid = true;
                }
                if(!isValid)
                    System.out.println("Please enter a weapon.");
            }catch(InputMismatchException badThing){
                System.out.println("Please enter a weapon."); //if it is not y or n, prompt again
            }
        }
    }

    public void guessRoom(Scanner in){
        System.out.print("\u001B[?25l");  // Hide the cursor
        boolean isValid = false;
        while(!isValid){
            System.out.println("What room do you think the murder occured in?");
            try{
                guessR = (in.nextLine()).toLowerCase(); //turns next thing put to lowercase
                for(String a : rooms){
                    if(guessR.equals(a.toLowerCase()))
                        isValid = true;
                }
                if(!isValid)
                    System.out.println("Please enter a room.");
            }catch(InputMismatchException badThing){
                System.out.println("Please enter a room."); //if it is not y or n, prompt again
            }
        }
    }

    public void guessPers(Scanner in){
        System.out.print("\u001B[?25l");  // Hide the cursor
        boolean isValid = false;
        while(!isValid){
            System.out.println("Who do you think committed the murder?");
            try{
                guessP = (in.nextLine()).toLowerCase(); //turns next thing put to lowercase
                for(String a : people){
                    if(guessP.equals(a.toLowerCase()))
                        isValid = true;
                }
                if(!isValid)
                    System.out.println("Please enter a person.");
            }catch(InputMismatchException badThing){
                System.out.println("Please enter a person."); //if it is not y or n, prompt again
            }
        }
    }

    public boolean checkCorrect(){
        int i = 0;
        if(guessW.equals(murWep.getName().toLowerCase())){
            System.out.println("You got the murder weapon right! :)");
            i++;
        } else   
            System.out.println("You got the murder weapon wrong... :( TT");

        if(guessR.equals(murRoom.getRoomName().toLowerCase())){
            System.out.println("You got the room the murder took place in right! :)");
            i++;
        } else 
            System.out.println("You got the room the murder took place in wrong... :( TT");

        if(guessP.equals(murPers.toLowerCase())){
            System.out.println("You got the person who commmitted the murder right! :)");
            i++;
        } else 
            System.out.println("You got the person who committed the murder wrong... :( TT");
        
        if(i == 3){
            System.out.println("You got them all right! You solved the mystery! Congratulations!!!");
            return true;
        } else {
            System.out.println("You got " + i + "/3 correct :(. You did not solve the mystery.");
            printCorrect();
            return false;
        }
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
