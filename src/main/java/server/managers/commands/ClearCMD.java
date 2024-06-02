package server.managers.commands;

import server.managers.CollectionManager;

public class ClearCMD implements BasicCommand {
    @Override
    public String execute(String[] args) {
        CollectionManager.getTable().clear();
        return "Collection has been cleared";
    }

    @Override
    public String getDescription() {
        return "clear data from collection";
    }

    @Override
    public String getName() {
        return "clear";
    }
}