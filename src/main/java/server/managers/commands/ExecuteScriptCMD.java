package server.managers.commands;

import server.exceptions.NoElementEx;
import server.managers.CollectionManager;
import server.managers.CommandManager;
import server.resources.Worker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class ExecuteScriptCMD implements BasicCommand {
    private static Stack<File> st = new Stack<>();

    @Override
    public String execute(String[] args) throws Exception {
        File file = new File(args[1] );
        if (!file.canRead()) {
            throw new NoElementEx("You do not have enough rights to read the file");
        }

        if (st.isEmpty()) {
            st.add(file);
        } else if (st.contains(file)) {
            throw new NoElementEx("You're having a recursion in your script&, please, delete your execute to another script and try again");
        }
        st.add(file);
        String path = args[1];
        var br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String line;
        String[] work = new String[10];
        StringBuilder result = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.split(" ")[0].equals("insert")) {
                String key = line.split(" ")[1];
                for (int n = 1; n < 10; n++) {
                    if ((line = br.readLine()) != null) {
                        work[n] = line;
                    }
                }
                CollectionManager.add(key, new Worker(work));
                result.append("Element was added. ID: " + new Worker(work).toString()).append("\n");
            } else {
                result.append(CommandManager.startExecuting(line)).append("\n");
            }
        }
        st.pop();
        return result.toString();
    }

    @Override
    public String getDescription() {
        return "execute your script file";
    }

    @Override
    public String getName() {
        return "execute";
    }
}