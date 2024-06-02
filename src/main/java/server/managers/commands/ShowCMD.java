package server.managers.commands;

import server.managers.CollectionManager;
import server.resources.Worker;

public class ShowCMD implements BasicCommand {
    @Override
    public String execute(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        Worker worker;
        for(String key : CollectionManager.getTable().keySet()){
            worker = CollectionManager.getTable().get(key);
            result.append(worker.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String getDescription() {
        return "this command is showing your collection";
    }

    @Override
    public String getName() {
        return "show";
    }
}