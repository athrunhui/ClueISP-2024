package zork;

import java.util.ArrayList;

public class NpcConversation {
    private randomRoom randRoom = new randomRoom();
    private ArrayList<String> rooms = new ArrayList<String>();
    private guess guess = new guess();
    private String[] setRoom = new String[6];
    private ArrayList<String> people = new ArrayList<String>();
    private String bloodyPerson;
    private String peacockRoom;
    private String greenRoom;
    private String scarletRoom;
    private String plumRoom;
    private String mustardRoom;
    private String whiteRoom;    

    public NpcConversation(String bloodyRoom){
        people.add("Mrs. Peacock");
        people.add("Mr. Green");
        people.add("Ms. Scarlet");
        people.add("Prof. Plum");
        people.add("Col. Mustard");
        people.add("Ms. White");
        zork.guess.setPeople(people);
        rooms.add(bloodyRoom);
        for(int i = 1; i < 6; i++){
            String roomId = randRoom.setRoomid();
            if(roomId.equals(bloodyRoom))
                roomId = randRoom.setRoomid();
            rooms.add(roomId);
        }

        for(int j = 0; j < 6; j++){
            setRoom[j] = rooms.remove((int)(Math.random()*rooms.size()));
        }

        peacockRoom = setRoom[0];
        greenRoom = setRoom[1];
        scarletRoom = setRoom[2];
        plumRoom = setRoom[3];
        mustardRoom = setRoom[4];
        whiteRoom = setRoom[5];  

        for(int i = 0; i < 6; i++){
            if(bloodyRoom.equals(setRoom[i]))
                bloodyPerson = people.get(i);
        }
        zork.guess.setMurPers(bloodyPerson);
    }

    public ArrayList<String> getPeople(){
        return people;
    }
    public String getBloodyPerson(){
        return bloodyPerson;
    }
    public String getPeacockRoom() {
        return peacockRoom;
    }
    public String getGreenRoom() {
        return greenRoom;
    }
    public String getScarletRoom() {
        return scarletRoom;
    }   
    public String getPlumRoom() {
        return plumRoom;
    }
    public String getMustardRoom() {
        return mustardRoom;
    }
    public String getWhiteRoom() {
        return whiteRoom;
    }

    public void talkToPeacock(Parser parser){
        System.out.println("Hey There! My name is Mrs. Peacock! Did you hear the news, MURDER in the house!");
        System.out.println("What would you like to ask me?");
        System.out.println("1. Where were you at the time of the murder?");
        System.out.println("2. How do you know the host, Mr. Boddy?");
        int response = parser.getConversationResponse();
        if(response == 1){
            System.out.println("Well, looking around at the beautiful decor of the " +
            peacockRoom + ". I was so shocked to hear of the murder!");
        }
        if(response == 2){
            System.out.println("I didn't really know Mr. Boddy personally. To be honest, I had to call in a million favors in order to attend tonights event.");
        }
    }

    public void talkToGreen(Parser parser){
        System.out.println("Howdy There! My name is Mr. Green! Pleasure to meet y'all!");
        System.out.println("What would ya like to ask me?");
        System.out.println("1. Where were you at the time of the murder?");
        System.out.println("2. How do you know the host, Mr. Boddy?");
        int response = parser.getConversationResponse();
        if(response == 1){
            System.out.println("I was wandering around, exploring the manor when I may have gotten lost," +
            " this place has so many rooms! I believe I was in the " + greenRoom + ".");
        }
        if(response == 2){
            System.out.println("Mr Broddy? We go way back! Ever since middle school!");
        }
    }

    public void talkToScarlet(Parser parser){
        System.out.println("Hey Darling! My name is Miss. Scarlet! Gosh, a murder tonight! Way to ruin the party.");
        System.out.println("What's on your mind?");
        System.out.println("1. Where were you at the time of the murder?");
        System.out.println("2. How do you know the host, Mr. Boddy?");
        int response = parser.getConversationResponse();
        if(response == 1){
            System.out.println("The party was starting to get dreadful boring, so I started trying" + 
            " to find something exciting. I believe I was in the " + scarletRoom + ".");
        }
        if(response == 2){
            System.out.println("I know him from some business deals I was involved in. He's a nice guy, really!");
        }
    }

    public void talkToPlum(Parser parser){
        System.out.println("Greetings visitor. Such an unfortunate situation we are in!");
        System.out.println("What question would you like to ask me?");
        System.out.println("1. Where were you at the time of the murder?");
        System.out.println("2. How do you know the host, Mr. Boddy?");
        int response = parser.getConversationResponse();
        if(response == 1){
            System.out.println("I was looking for Mrs. Peacock in the " + 
            plumRoom + ", there was a particular bird species I wanted her opinion on.");
        }
        if(response == 2){
            System.out.println("I knew him from a friend of a friend. He seemed fun, such a shame this happened to him.");
        }
    }

    public void talkToMustard(Parser parser){
        System.out.println("Hey there! Did you hear, a murder occured! Too much stress for an old folk like me.");
        System.out.println("What can I do you for?");
        System.out.println("1. Where were you at the time of the murder?");
        System.out.println("2. How do you know the host, Mr. Boddy?");
        int response = parser.getConversationResponse();
        if(response == 1){
            System.out.println("I needed to find a place to smoke my cigar, I ended up heading to the " +
            mustardRoom + ".");
        }
        if(response == 2){
            System.out.println("Mr Broddy! I knew his folks, we went way back.");
        }
    }

    public void talkToWhite(Parser parser){
        System.out.println("Hi there! My name is Mrs. White, the maid of this manor. God, my boss just died! At least I'm free! ");
        System.out.println("What do you want to talk about??");
        System.out.println("1. Where were you at the time of the murder?");
        System.out.println("2. How do you know the host, Mr. Boddy?");
        int response = parser.getConversationResponse();
        if(response == 1){
            System.out.println("I was just tidying up, doing some dusting in the " +
            whiteRoom + ". Now it seems I have even more work, cleaning up all the blood.");
        }
        if(response == 2){
            System.out.println("How I knew him? He was my boss!");
        }
    }
}
