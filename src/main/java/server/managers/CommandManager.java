package server.managers;

import server.exceptions.UnknownCmdEX;
import server.managers.commands.*;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;

public class CommandManager {
    private static LinkedHashMap<String, BasicCommand> comandList;
    public static ArrayDeque<BasicCommand> lastSixCommand = new ArrayDeque<>();

    public CommandManager() {
        comandList = new LinkedHashMap<>();
        comandList.put("info", new InfoCMD());
        comandList.put("help", new HelpCMD());
        comandList.put("remove", new RemoveCMD());
        //comandList.put("insert", new InsertCMD());
        comandList.put("clear", new ClearCMD());
        comandList.put("exit", new ExitCMD());
        comandList.put("show", new ShowCMD());
        comandList.put("load", new LoadCMD());
        comandList.put("execute", new ExecuteScriptCMD());
        comandList.put("minId", new IdSort());
        comandList.put("sumsalary", new SumSalaryCMD());
        comandList.put("update", new UpdateByIdCMD());
        comandList.put("history", new HistoryCMD());
        comandList.put("count_by_status", new StatusCounterCMD());
        comandList.put("filter_less", new filter_less_than_position());
        comandList.put("replace", new ReplaceIfGreaterCommand());
    }

    public static LinkedHashMap<String, BasicCommand> getCommandList() {
        return comandList;

    }

    public static String startExecuting(String line) throws Exception {
        String commandName = line.split(" ")[0];
        if (!comandList.containsKey(commandName)) {
            throw new UnknownCmdEX(commandName);
        }
        BasicCommand command = comandList.get(commandName);
        String result = command.execute(line.split(" "));
        if (!(lastSixCommand == null) && lastSixCommand.size() == 12) {
            lastSixCommand.pop();
            lastSixCommand.addLast(command);
        } else {
            assert lastSixCommand != null;
            lastSixCommand.addFirst(command);
        }

        return result;
    }
}