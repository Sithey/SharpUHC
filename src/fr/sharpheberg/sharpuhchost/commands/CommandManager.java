package fr.sharpheberg.sharpuhchost.commands;

import fr.sharpheberg.sharpuhchost.Main;
import org.bukkit.command.CommandExecutor;

public class CommandManager {

    public static void registerCommand(String command, CommandExecutor executor){
        Main.get().getCommand(command).setExecutor(executor);
    }

    public static void load(){
        registerCommand("start", new StartCommand());
    }

}
