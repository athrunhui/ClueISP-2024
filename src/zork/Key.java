package zork;

public class Key extends Item {
  private String keyId;

  public Key(String keyId, String keyName, String description) {
    super(1, keyName, false, true, description, false, false);
    this.keyId = keyId;
  }

  public String getKeyId() {
    return keyId;
  }
}
