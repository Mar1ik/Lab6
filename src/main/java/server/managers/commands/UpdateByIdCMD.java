package server.managers.commands;

import server.exceptions.NoElementException;
import server.managers.CollectionManager;
import server.resources.Worker;
import server.resources.randomizer.WorkerGenerator;

import java.util.Scanner;

public class UpdateByIdCMD implements BasicCommand {
    @Override
    public String execute(String[] args) throws Exception {
        boolean elementInCollection = false;
        Long id = Long.parseLong(args[1]);
        Scanner scanner = new Scanner(System.in);

        for (String key : CollectionManager.getTable().keySet()) {
            if (CollectionManager.getTable().get(key).getId().equals(id)) {
                elementInCollection = true;
                Long idTrue = CollectionManager.getTable().get(key).getId();
                Worker worker = WorkerGenerator.createWorker(id, scanner);
                CollectionManager.remove(key);
                CollectionManager.add(key, worker);
                worker.setId(idTrue);
                return "Element was updated";
            }
        }
        if (!elementInCollection) {
            try {
                throw new NoElementException(id);
            } catch (NoElementException e) {
                return "No element with id " + id + " found";
            }
        }
        return "Invalid arguments";
    }

    @Override
    public String getDescription() {
        return "this command change you data by ID";
    }

    @Override
    public String getName() {
        return "update";
    }
}