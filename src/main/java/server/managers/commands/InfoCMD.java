package server.managers.commands;

import server.managers.CollectionManager;

public class InfoCMD implements BasicCommand {
    @Override
    public String execute(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        result.append("Data type - ").append(CollectionManager.getTable().getClass().getName()).append("\n");
        result.append("Count of workers - ").append(CollectionManager.getTable().keySet().size()).append("\n");
        result.append("Init date - ").append(CollectionManager.getDate());
        return result.toString();
    }

    @Override
    public String getDescription() {
        return "return information about program";
    }

    @Override
    public String getName() {
        return "info";
    }
}