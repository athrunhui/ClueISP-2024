package zork;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Game {

  public static HashMap<String, Room> roomMap = new HashMap<String, Room>(); // "master map"
  public static HashMap<String, Item> itemMap = new HashMap<String, Item>(); // "master map"

  private Parser parser;
  private static Room currentRoom;

  /**
   * Create the game and initialise its internal map.
   */
  public Game() {
    try {
      initRooms("src\\zork\\data\\rooms.json");
      initItems("src\\zork\\data\\items.json");
      currentRoom = roomMap.get("Front Step");
    } catch (Exception e) {
      e.printStackTrace();
    }
    parser = new Parser();
  }

  private void initItems(String fileName) throws Exception {
    Path path = Path.of(fileName); // file name i pass in to know where i read it from
    String jsonString = Files.readString(path); // turn the jsonfile into a massive string 
    JSONParser parser = new JSONParser();
    JSONObject j2son = (JSONObject) parser.parse(jsonString); // parse to make it one big object
    JSONObject json = (JSONObject) parser.parse(jsonString); // parse to make it one big object
    randomRoom randRoom = new randomRoom();
    randomBloody randBlood = new randomBloody();

    JSONArray jsonItems = (JSONArray) json.get("items");

    for (Object itemObj: jsonItems){
      int weight = Integer.parseInt((String)((JSONObject) itemObj).get("weight"));
      String name = (String)((JSONObject) itemObj).get("name");
      Boolean open = Boolean.parseBoolean((String)((JSONObject) itemObj).get("isOpenable"));
      String id = (String)((JSONObject) itemObj).get("id");
      Boolean bloody = randBlood.setBloodyItem(id);
      Boolean examine = Boolean.parseBoolean((String)((JSONObject) itemObj).get("IsExaminable"));
      String description = (String)((JSONObject) itemObj).get("description");
      Boolean murWep = Boolean.parseBoolean((String)((JSONObject) itemObj).get("murderWeapon"));
      String keyid = (String)((JSONObject) itemObj).get("keyid");
      if(name.indexOf("key") > 0){
        Key key = new Key(keyid, name, description);
        String itemId = (String)((JSONObject) itemObj).get("item_id");
        itemMap.put(itemId, key);
      } else {
        Item item = new Item(weight, name, open, examine, description, bloody, murWep);
        Boolean idNThere = Objects.isNull(((JSONObject) itemObj).get("room_id"));
        if(!idNThere){
          String roomid = (String)((JSONObject) itemObj).get("room_id");
          roomMap.get(roomid).getInventory().addItem(item);
        } else if(murWep){
          String roomid = randRoom.setRoomid();
          roomMap.get(roomid).getInventory().addItem(item);
        } else if(id.equals("Blood")) {
          String itemId = randBlood.getBloodyItem();
          itemMap.get(itemId).getInventory().addItem(item);
        } else if(id.equals("Bloody")){}
        else {
          String itemId = (String)((JSONObject) itemObj).get("item_id");
          itemMap.get(itemId).getInventory().addItem(item);
        }      
      itemMap.put(id, item);
      }
    }
  }

  private void initRooms(String fileName) throws Exception {
    Path path = Path.of(fileName); // file name i pass in to know where i read it from
    String jsonString = Files.readString(path); // turn the jsonfile into a massive string 
    JSONParser parser = new JSONParser();
    JSONObject json = (JSONObject) parser.parse(jsonString); // parse to make it one big object

    JSONArray jsonRooms = (JSONArray) json.get("rooms"); // creates array of rooms (in rooms.json) first line

    for (Object roomObj : jsonRooms) { 
      Room room = new Room();
      String roomName = (String) ((JSONObject) roomObj).get("name"); // turns into json object and gets the name
      String roomId = (String) ((JSONObject) roomObj).get("id");
      String roomShortDescription = (String) ((JSONObject) roomObj).get("shortDescription");
      String roomLongDescription = (String) ((JSONObject) roomObj).get("longDescription");
      
      room.setShortDescription(roomShortDescription);
      room.setLongDescription(roomLongDescription);
      room.setRoomName(roomName);

      JSONArray jsonExits = (JSONArray) ((JSONObject) roomObj).get("exits");
      ArrayList<Exit> exits = new ArrayList<Exit>();
      for (Object exitObj : jsonExits) { // iterate through exits
        String direction = (String) ((JSONObject) exitObj).get("direction");
        String adjacentRoom = (String) ((JSONObject) exitObj).get("adjacentRoom");
        String keyId = (String) ((JSONObject) exitObj).get("keyId");
        Boolean isLocked = (Boolean) ((JSONObject) exitObj).get("isLocked");
        Boolean isOpen = (Boolean) ((JSONObject) exitObj).get("isOpen");
        Exit exit = new Exit(direction, adjacentRoom, isLocked, keyId, isOpen);
        exits.add(exit); 
      }
      room.setExits(exits); // set exits for room
      roomMap.put(roomId, room); // puts room in hash map and links to room ID
    }
  }

  /**
   * Main play routine. Loops until end of play.
   */
  public void play() {
    printWelcome();

    boolean finished = false;
    while (!finished) {
      Command command;
      try {
        command = parser.getCommand();
        finished = processCommand(command);
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
    System.out.println("Thank you for playing.  Good bye.");
  }

  /**
   * Print out the opening message for the player.
   */
  private void printWelcome() {
    System.out.println();
    System.out.println("Welcome to Clue!");
    System.out.println("A clue inspired, text based adventure game.");
    System.out.println("Explore the manor, pickup clues, and uncover the killer!");
    System.out.println("You are a detective invited to a dinner party at the grand manor of Mr. Boddy");
    System.out.println("Upon arrival, you find six other guests, Mrs. Peacock, Mr. Green, Ms. Scarlet, Prof. Plum, Col. Mustard, and the maid Mrs. White.");
    System.out.println("A short while after dinner, the party has split up. You start exploring the various rooms of the manor when you hear a scream.");
    System.out.println("A patron comes running, shouting that Mr. Boddy has been killed. You and the others go to explore but the body is gone!");
    System.out.println("As a detective it is now your duty to figure out what happened here and bring the killer to justice.");
    System.out.println("Examine rooms and items for traces of blood, and place everyone at the time of the murder.");
    System.out.println("Type 'help' if you need help.");
    System.out.println();
    System.out.println(currentRoom.getLongDescription());
  }

  /**
   * Given a command, process (that is: execute) the command. If this command ends
   * the game, true is returned, otherwise false is returned.
   */
  private boolean processCommand(Command command) {
    if (command.isUnknown()) {
      System.out.println("I don't know what you mean...");
      return false;
    }

    String commandWord = command.getCommandWord();
    if (commandWord.equals("help"))
      printHelp();
    else if (commandWord.equals("go"))
      goRoom(command);
    else if (commandWord.equals("quit")) {
      if (command.hasSecondWord())
        System.out.println("Quit what?");
      else
        return true; // signal that we want to quit
    } else if (commandWord.equals("eat")) {
      System.out.println("Do you really think you should be eating at a time like this?");
    } else if (commandWord.equals("look"))
    currentRoom.getInventory().printItems();
    else if(commandWord.equals("examine")){
      if (!command.hasSecondWord()){
        System.out.println("What do you want to examine?");
        return false;
      }else{
        examine(command.getSecondWord());
      }
      
    }
    else if (commandWord.equals("talk"))
    talkToNpc(command.getSecondWord());
    return false;
  }
  // implementations of user commands:

  private void examine(String secondWord){
    if(currentRoom.getInventory().findItem(secondWord)){
      Item a = currentRoom.getInventory().getItem(secondWord);
      System.out.println(a.getDescription());
      if(a.isBloody()){
        System.out.println("Upon further inspection of the item, you find that its bloody!!!" +
        "This is the weapon used for the murder!");
      } else if(a.isMurWep()){
        System.out.println("As you examine the item, you find that this is a potential murder weapon.");
      }
    }
  }

  private void talkToNpc(String secondWord) {
    if(secondWord.equalsIgnoreCase("Mrs. Peacock") || secondWord.equalsIgnoreCase("peacock") || currentRoom.getNpc().equals("Peacock")){
      NpcConversation peacock = new NpcConversation(secondWord);
      peacock.talkToPeacock(parser);
    }

    if(secondWord.equalsIgnoreCase("Mr. Green") || secondWord.equalsIgnoreCase("green")){
      NpcConversation peacock = new NpcConversation(secondWord);
      peacock.talkToGreen(parser);
    }

    if(secondWord.equalsIgnoreCase("Mr. Scarlet") || secondWord.equalsIgnoreCase("scarlet")){
      NpcConversation peacock = new NpcConversation(secondWord);
      peacock.talkToScarlet(parser);
    }

    if(secondWord.equalsIgnoreCase("Prof. Plum") || secondWord.equalsIgnoreCase("plum")){
      NpcConversation peacock = new NpcConversation(secondWord);
      peacock.talkToPlum(parser);
    }

    if(secondWord.equalsIgnoreCase("Col. Mustard") || secondWord.equalsIgnoreCase("mustard")){
      NpcConversation peacock = new NpcConversation(secondWord);
      peacock.talkToMustard(parser);
    }

    if(secondWord.equalsIgnoreCase("Mrs. White") || secondWord.equalsIgnoreCase("white")){
      NpcConversation peacock = new NpcConversation(secondWord);
      peacock.talkToWhite(parser);
    }
  }

  /**
   * Print out some help information. Here we print some stupid, cryptic message
   * and a list of the command words.
   */
  private void printHelp() {
    System.out.println("You are a detective in the middle of a murder myster. You are alone. You wander");
    System.out.println("around the vast halls of the mansion looking for clues that will point you to your murderer.");
    System.out.println();
    System.out.println("Your command words are:");
    parser.showCommands();
  }

  /**
   * Try to go to one direction. If there is an exit, enter the new room,
   * otherwise print an error message.
   */
  private void goRoom(Command command) {
    if (!command.hasSecondWord()) {
      // if there is no second word, we don't know where to go...
      System.out.println("Go where?");
      return;
    }

    String direction = command.getSecondWord();

    // Try to leave current room.
    Room nextRoom = currentRoom.nextRoom(direction);

    if (nextRoom == null)
      System.out.println("There is no door!");
    else {
      currentRoom = nextRoom;
      System.out.println(currentRoom.longDescription());
    }
  }
}
