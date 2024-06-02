package server.managers.commands;

public interface BasicCommand {
    public String execute(String[] args) throws Exception;

    public String getDescription();

    public String getName();
}
