package server.managers.commands;

import server.managers.CommandManager;

import java.util.LinkedHashMap;

public class HelpCMD implements BasicCommand {
    @Override
    public String execute(String[] args) {
        LinkedHashMap<String, BasicCommand> commandlist = CommandManager.getCommandList();
        StringBuilder result = new StringBuilder();
        for (String name : commandlist.keySet()){
            BasicCommand command = commandlist.get(name);
            result.append(command.getName()).append(": ").append(command.getDescription()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String getDescription() {
        return "show help for available commands";
    }

    @Override
    public String getName() {
        return "help";
    }
}