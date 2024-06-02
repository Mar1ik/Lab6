package client.exceptions;

public class NoElementEx extends Exception {
    public NoElementEx(String key) {
        super(key);
    }

    public NoElementEx(Long id) {
        super(String.valueOf(id));
    }
}
