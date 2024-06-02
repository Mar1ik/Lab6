package server.managers.commands;

import server.exceptions.NoElementEx;
import server.managers.CollectionManager;

public class RemoveCMD implements BasicCommand {
    @Override
    public String execute(String[] args) throws Exception {
        try {
            CollectionManager.remove(args[1]);
            return "Element has been removed.";
        } catch (NoElementEx e) {
            return e.getMessage() + "\nProgram has returned to safe state";
        }
    }

    @Override
    public String getDescription() {
        return "remove element from collection";
    }

    @Override
    public String getName() {
        return "remove element";
    }
}