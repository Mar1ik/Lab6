package server.managers.commands;

import server.exceptions.BuildWorkerEX;
import server.exceptions.WrongArgEX;
import server.managers.CollectionManager;
import server.resources.Worker;
import server.resources.randomizer.*;

import java.util.Scanner;

public class InsertCMD implements BasicCommand {
    @Override
    public String execute(String[] args) throws Exception {
        if (args.length == 2) {
            try {
                Scanner scanner = new Scanner(System.in);
                Worker worker = WorkerGenerator.createWorker(0L, scanner);
                CollectionManager.add(args[1], worker);
                return "Element was added. ID: " + worker.toString();
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
    public String getDescription() {
        return "insert element into collection";
    }

    @Override
    public String getName() {
        return "insert";
    }
}