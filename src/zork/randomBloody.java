package zork;

import java.util.ArrayList;

public class randomBloody {
    private ArrayList<String> items;
    private static int itemNumber;
    public static String bloodyItem; 

    public randomBloody(){
        items = new ArrayList<>();
        items.add("Candle");
        items.add("Wrench");
        items.add("Rope");
        items.add("Pipe");
        items.add("Knife");
        items.add("Gun");
        items.add("Baseball Bat");
        items.add("Shovel");
        items.add("Letter Opener");
        items.add("Golf Club");
        itemNumber = (int)(Math.random()*items.size());
    }

    public Boolean setBloodyItem(String item){
        for(String a : items){
            if(a.equals(item)){
              if(items.get(itemNumber).equals(a)){
                bloodyItem = a;
                return true;
              }
            }
        }
        return false;
    }

    public String getBloodyItem() {
        return bloodyItem;
    }
}