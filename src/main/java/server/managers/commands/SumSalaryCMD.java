package server.managers.commands;

import server.managers.CollectionManager;

public class SumSalaryCMD implements BasicCommand {
    @Override
    public String execute(String[] args) throws Exception {
        return "A salary count of your worker's is " + CollectionManager.sumSalary();
    }

    @Override
    public String getDescription() {
        return "this program calculate all salary of your workers";
    }

    @Override
    public String getName() {
        return "sumsalary";
    }
}