package server.managers;

import java.io.InputStream;
import java.util.Scanner;

public class Console {
    public static String data_path;

    public void start(InputStream input) {
        Scanner scanner = new Scanner(input);
        CommandManager commandManager = new CommandManager();
        new CollectionManager();
        System.out.println("Welcome to app!\n" + "Print 'help' to view information about using commands\n" +
                "If you want to load your preset, print 'load + NAME of your file'");
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();
            if (!command.isEmpty()) {
                try {
                    commandManager.startExecuting(command);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}