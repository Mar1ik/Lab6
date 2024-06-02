package server.managers.commands;

import server.managers.CollectionManager;
import server.resources.Worker;

import java.util.TreeMap;

public class IdSort implements BasicCommand {
    @Override
    public String execute(String[] args) throws Exception {
        Worker worker = null;
        StringBuilder result = new StringBuilder();
        TreeMap<String, Worker> table = CollectionManager.getTable();
        for (String key : table.keySet()) {
            if (worker == null) {
                worker = table.get(key);
            } else if (worker.compareTo(table.get(key)) < 0) {
                worker = table.get(key);
            }
            result.append(worker.toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String getDescription() {
        return "this command reduce your collection by id";
    }

    @Override
    public String getName() {
        return "minId";
    }
}