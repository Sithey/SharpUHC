package fr.sharpheberg.sharpuhchost;

import fr.sharpheberg.sharpuhchost.commands.CommandManager;
import fr.sharpheberg.sharpuhchost.events.EventManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        EventManager.load();
        CommandManager.load();
    }

    @Override
    public void onDisable() {

    }

    public static Main get() {
        return instance;
    }
}
