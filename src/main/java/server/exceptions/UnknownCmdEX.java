package server.exceptions;

public class UnknownCmdEX extends Exception {
    public UnknownCmdEX(String message) {
        super("'" + message + "'" + " doesn't applicable command in this program, try another command or print 'help' to view all commands");
    }
}
