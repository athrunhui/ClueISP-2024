package zork;

import java.util.Scanner;

public class Parser {
  private CommandWords commands; // holds all valid command words
  private Scanner in;
  private static boolean inConversation;

  public Parser() {
    commands = new CommandWords();
    in = new Scanner(System.in);
    inConversation = false;

  }

  public Command getCommand() throws java.io.IOException {
    String inputLine = "";
    String[] words;

    System.out.print("> "); // print prompt

    inputLine = in.nextLine();

    words = inputLine.split(" ");

    String word1 = words[0];
    String word2 = null;
    if (words.length > 1)
      word2 = "";
      for (int i = 1; i < words.length; i++){
        word2 += words[i] + " ";
      }
      word2 = word2.trim();

    if (commands.isCommand(word1))
      return new Command(word1, word2);
    else
      return new Command(null, word2);
  }

  public int getConversationResponse(){
    System.out.print("> "); // print prompt

    String inputLine = in.nextLine();

    while(true){
      try{
        int resp = Integer.parseInt(inputLine);
        return resp;
      }catch (Exception ex){
        System.out.println("Not sure what you mean. Select a numerical optoin.");
      }
    }

  }

  public static void startConversation(){
    inConversation = true;
  }

  public static void endConversation(){
    inConversation = false;
  }

  /**
   * Print out a list of valid command words.
   */
  public void showCommands() {
    commands.showAll();
  }
}
