package client.exceptions;

public class IdCopyEX extends Exception {
    public IdCopyEX(Long id) {
        super(id + "is already used");
    }
}
