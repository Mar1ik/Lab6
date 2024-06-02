package server.managers.commands;

import server.managers.CommandManager;

public class HistoryCMD implements BasicCommand {
    @Override
    public String execute(String[] args) {
        StringBuilder result = new StringBuilder();
        CommandManager.lastSixCommand.descendingIterator().forEachRemaining(command -> result.append(command.getName()).append("\n"));
        return result.toString();
    }

    @Override
    public String getDescription() {
        return "return last twelve commands";
    }

    @Override
    public String getName() {
        return "history";
    }
}