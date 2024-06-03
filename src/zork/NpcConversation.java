package zork;

public class NpcConversation {
    private String Npc;
    private static randomRoom randRoom = new randomRoom();

    public NpcConversation(String n){
        this.Npc = n;
    }


    public void talkToPeacock(Parser parser){
        System.out.println("Hey There! My name is Mrs. Peacock! Did you hear the news, MURDER in the house!");
        System.out.println("What would you like to ask me?");
        System.out.println("1. Where were you at the time of the murder?");
        System.out.println("2. How do you know the host, Mr. Boddy?");
        int response = parser.getConversationResponse();
        if(response == 1){
            System.out.println("Well, looking around at the beautiful decor of the " +
            randRoom.setRoomid() + ". I was so shocked to hear of the murder!");
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
            " this place has so many rooms! I believe I was in the " + randRoom.setRoomid());
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
            " to find something exciting. I believe I was in the " + randRoom.setRoomid() + ".");
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
            randRoom.setRoomid() + ", there was a particular bird species I wanted her opinion on.");
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
            randRoom.setRoomid() + ".");
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
            randRoom.setRoomid() + ". Now it seems I have even more work, cleaning up all the blood.");
        }
        if(response == 2){
            System.out.println("How I knew him? He was my boss!");
        }
    }
}
