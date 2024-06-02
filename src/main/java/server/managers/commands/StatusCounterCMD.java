package server.managers.commands;

import server.managers.CollectionManager;
import server.resources.Status;

public class StatusCounterCMD implements BasicCommand {
    @Override
    public String execute(String[] args) throws Exception {
        if (args.length == 2) {
            try {
                int count = 0;
                Status myNewEnum = Status.valueOf(args[1].toUpperCase());

                for (String key : CollectionManager.getTable().keySet()) {
                    if (CollectionManager.getTable().get(key).getStatus().equals(myNewEnum)) {
                        count += 1;
                    }
                }
                return String.valueOf(count);

            } catch (Exception e) {
                return e.getMessage();
            }
        }
        return "Invalid arguments";
    }

    @Override
    public String getDescription() {
        return "return count of your worker's status";
    }

    @Override
    public String getName() {
        return "count_by_status";
    }
}