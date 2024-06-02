package client.exceptions;

//import managers.CollectionManager;

public class KeyCopyEX extends Exception {
    public KeyCopyEX(String key) {
        super(key + " is already used");
    }
}
