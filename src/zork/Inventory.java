package zork;

import java.util.ArrayList;

public class Inventory {
  private ArrayList<Item> items;
  private int maxWeight;
  private int currentWeight;

  public Inventory(int maxWeight) {
    this.items = new ArrayList<Item>();
    this.maxWeight = maxWeight;
    this.currentWeight = 0;
  }

  public int getMaxWeight() {
    return maxWeight;
  }

  public int getCurrentWeight() {
    return currentWeight;
  }

  public Item getItem(String item){
    for(Item a : items){
      if(a.getName().toLowerCase().equals(item.toLowerCase()))
        return a;
    }
    return null;
  }

  public boolean addItem(Item item) {
    if (item.getWeight() + currentWeight <= maxWeight)
      return items.add(item);
    else {
      System.out.println("There is no room to add the item.");
      return false;
    }
  }

  public void printItems(){ // done - prints lines of items in the room
    if(items.size() == 0 || items.get(0).equals(null)){
      System.out.println("The room is empty");
    } else{
    for(int i = 0; i < items.size(); i++){
        if(i == 0)
          System.out.println("There is a " + items.get(i).getDescription() + ".");
        else  
          System.out.println("A " + items.get(i).getDescription() + ".");
    }
  }
  }

  public void printPlayerItems(){ // done - prints lines of items in the player's inventory
    if(items.size() == 0 || items.get(0).equals(null)){
      System.out.println("You don't have anything in your inventory.");
    } else{
    for(int i = 0; i < items.size(); i++){
        if(i == 0)
          System.out.println("You have a " + items.get(i).getDescription() + ".");
        else  
          System.out.println("A " + items.get(i).getDescription() + ".");
    }
  }
  }

  public boolean findItem(String command){
    for(Item a : items){
      if(command.equals(a.getName().toLowerCase()))
        return true;
    }
    return false;
  }

  public Item removeItem(String item, int weight) {
    for(int i = 0; i < items.size(); i++){
      if(items.get(i).getName().equals(item)){
        Item temp = items.get(i);
        if(temp.getWeight() > weight){
          System.out.println("There is no room to add the item.");
          return null;
        }
        items.remove(i);
        return temp;
      }
    }
    System.out.println("This " + item + " is not there.");
    return null;
  }
}
