package server.managers.commands;

public class ExitCMD implements BasicCommand {
    @Override
    public String execute(String[] args) {
        System.exit(0);
        return "Server has been shut down";
    }

    @Override
    public String getDescription() {
        return "shut down the server";
    }

    @Override
    public String getName() {
        return "exit";
    }
}