package server.managers.commands;

import server.managers.CollectionManager;
import server.resources.*;

import java.util.ArrayList;

public class filter_less_than_position implements BasicCommand {
    @Override
    public String execute(String[] args) throws Exception {
        Worker worker;
        Position position = Position.valueOf(args[1].toUpperCase());
        ArrayList<String> keySet = new ArrayList<>();
        for (String key : CollectionManager.getTable().keySet()) {
            if (position.getValue() < CollectionManager.getTable().get(key).getPosition().getValue()) {
                keySet.add(key);
            }
        }
        int k = keySet.size();
        StringBuilder result = new StringBuilder();
        for (String key : keySet) {
            worker = CollectionManager.getTable().get(key);
            result.append(worker.toString()).append("\n");
        }
        if (k == CollectionManager.getTable().size()) {
            result.append("Nothing was changed");
        }
        return result.toString();
    }

    @Override
    public String getDescription() {
        return "filter less than position your worker have";
    }

    @Override
    public String getName() {
        return "filter_less";
    }
}