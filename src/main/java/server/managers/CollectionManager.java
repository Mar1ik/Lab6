package server.managers;


import server.exceptions.*;
import server.resources.*;
import server.resources.Worker;

import java.time.LocalDate;
import java.util.TreeMap;

public class CollectionManager {
    private static TreeMap<String, Worker> table = new TreeMap<>();
    private static LocalDate date;


    public CollectionManager() {
        table = new TreeMap<>();
        date = LocalDate.now();

    }

    public static LocalDate getDate() {
        return date;
    }

    public static void add(String key, Worker worker) throws KeyCopyEX {
        if (table == null) {
            table = new TreeMap<>();
            throw new KeyCopyEX(key);
        } else if (CollectionManager.table.containsKey(key)) {
            throw new KeyCopyEX(key);
        } else {
            table.put(key, worker);
        }

    }

    public static String getKey(String key) throws NoElementEx {
        return CollectionManager.getKey(key);
    }

    public static void remove(String key) throws NoElementEx {
        if (table == null) {
            throw new NoElementEx(key);
        } else if (!CollectionManager.table.containsKey(key)) {
            throw new NoElementEx(key);
        } else {
            table.remove(key);
        }
    }

    public static String getWorker(Worker worker) throws NoElementEx {
        return CollectionManager.getWorker(worker);
    }


    public static TreeMap<String, Worker> getTable() {
        return table;
    }

    public static void setTable(TreeMap<String, Worker> table1) {
        table = table1;
    }

    public static int sumSalary() {
        int count = 0;
        for (String key : table.keySet()) {
            count += table.get(key).getSalary();
        }
        return count;
    }



}
