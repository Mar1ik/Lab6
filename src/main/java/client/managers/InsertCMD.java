package client.managers;

import server.exceptions.BuildWorkerEX;
import server.exceptions.WrongArgEX;
import server.resources.Worker;
import server.resources.randomizer.*;

import java.io.Serializable;
import java.util.Scanner;
import java.util.TreeMap;

public class InsertCMD implements BasicCommand, Serializable {
    private static final long serialVersionUID = 3L;

    public Serializable execute(String[] args) throws Exception {
        TreeMap<String, Worker> table = new TreeMap<>(); // Initialize table
        if (args.length == 2) {
            try {
                Scanner scanner = new Scanner(System.in);
                Worker worker = WorkerGenerator.createWorker(0L, scanner);
                table.put(args[1], worker);
                return  table;
            } catch (WrongArgEX e) {
                return e.getMessage();
            } catch (BuildWorkerEX e) {
                return e.getMessage() + "\nProgram has returned for a safe state";
            }
        } else {
            throw new WrongArgEX("Error!!!\nPRINT KEY");
        }
    }

    @Override
    public String execute() throws Exception {
        return null;
    }

    @Override
    public String getDescription() {
        return "insert element into collection";
    }

    @Override
    public String getName() {
        return "insert";
    }
}
