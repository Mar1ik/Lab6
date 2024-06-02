package server.managers.commands;

import server.managers.CollectionManager;
import server.resources.Worker;
import server.resources.comparator.SalaryComp;
import server.resources.randomizer.WorkerGenerator;

import java.util.Scanner;
import java.util.TreeMap;

public class ReplaceIfGreaterCommand implements BasicCommand {
    @Override
    public String execute(String[] args) throws Exception {
        String key = args[1];
        TreeMap<String, Worker> table = CollectionManager.getTable();
        SalaryComp c1 = new SalaryComp();
        Scanner scanner = new Scanner(System.in);
        if (table.containsKey(key)) {
            Worker worker = WorkerGenerator.createWorker(0L, scanner);
            if (c1.compare(worker, table.get(key)) > 0) {
                CollectionManager.remove(key);
                CollectionManager.add(key, worker);
                return "Complete";
            }else{
                return "Nothing change";
            }
        }
        return "Key not found";
    }

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    @Override
    public String getDescription() {
        return "null {element} - update element by key if new bigger than element in collection with the same key";
    }
}