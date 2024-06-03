package zork;

public class character {
    private String name;
    private Inventory inventory;
    
    public character(String name){
        this.name = name;
        inventory = new Inventory(20);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

}
