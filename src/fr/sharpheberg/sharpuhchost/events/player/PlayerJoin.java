package fr.sharpheberg.sharpuhchost.events.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(null);

        Player player = event.getPlayer();

        Bukkit.broadcastMessage("§e" + player.getName() + " §7a rejoint la partie !");

        player.teleport(player.getWorld().getSpawnLocation());
    }
}
