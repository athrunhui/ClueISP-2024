package zork;

public class Item extends OpenableObject {
  private int weight;
  private String name;
  private boolean isOpenable;
  private boolean isExaminable;
  private String description;
  private boolean isBloody;
  private Inventory inventory;
  private boolean isMurWep;

  public Item(int weight, String name, boolean isOpenable, boolean isExaminable, 
  String description, boolean isBloody, boolean isMurWep) {
    this.weight = weight;
    this.name = name;
    this.isOpenable = isOpenable;
    this.isExaminable = isExaminable;
    this.description = description;
    this.isBloody = isBloody;
    this.isMurWep = isMurWep;
    inventory = new Inventory(1);
  }

  public void open() {
    if (!isOpenable)
      System.out.println("The " + name + " cannot be opened.");

  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isOpenable() {
    return isOpenable;
  }

  public void setOpenable(boolean isOpenable) {
    this.isOpenable = isOpenable;
  }

  public boolean isExaminable() {
    return isExaminable;
  }

  public void setExaminable(boolean isExaminable) {
    this.isExaminable = isExaminable;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isBloody() {
    return isBloody;
  }

  public void setBloody(boolean isBloody) {
    this.isBloody = isBloody;
  }
  
  public boolean isMurWep() {
    return isMurWep;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public void setInventory(Inventory inventory) {
    this.inventory = inventory;
  }

  
}
