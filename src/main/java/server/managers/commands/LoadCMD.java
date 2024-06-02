package server.managers.commands;

import server.exceptions.WrongArgEX;
import server.managers.CollectionManager;
import server.managers.Validator;
import server.resources.Worker;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class LoadCMD implements BasicCommand {
    @Override
    public String execute(String[] args) throws Exception {
        String filename = args[1] + ".json";
        TreeMap<String, Worker> collectionManager = CollectionManager.getTable();
        new TreeMap<String, Worker>().getClass();
        Worker worker;
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JavaType mapType = objectMapper.getTypeFactory().constructMapType(TreeMap.class, String.class, Worker.class);
            TreeMap<String, Worker> myMap = objectMapper.readValue(new File(filename), mapType);
            TreeMap<String, Worker> table;
            table = myMap;
            StringBuilder result = new StringBuilder();
            for (String key : table.keySet()) {

                try {
                    Validator.WorkerISValid(table.get(key));
                    result = new StringBuilder("Load has completed successfully");
                    System.out.println("Load has completed successfully");
                } catch (WrongArgEX e) {
                    System.out.println("Error in json table " + key);
                    break;


                }
            }

        } catch (IOException | NullPointerException e) {
            System.out.println("Error to read your file " + e.getMessage());
        }
        return "Load has completed successfully";
    }

    @Override
    public String getDescription() {
        return "this command load a list from your saved json file";
    }

    @Override
    public String getName() {
        return "load";
    }
}
