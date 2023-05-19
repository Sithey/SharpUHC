package fr.sharpheberg.sharpuhchost.events;

import fr.sharpheberg.sharpuhchost.Main;
import fr.sharpheberg.sharpuhchost.events.player.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;

public class EventManager {

    public static void registerListener(Listener listener){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(listener, Main.get());
    }

    public static void load(){
        registerListener(new PlayerJoin());

        Bukkit.getOnlinePlayers().forEach(player -> Bukkit.getPluginManager().callEvent(new PlayerJoinEvent(player, null)));
    }

}
