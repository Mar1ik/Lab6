package client.managers;

public interface BasicCommand {
    public String execute() throws Exception;

    public String getDescription();

    public String getName();
}
