package fr.sharpheberg.sharpuhchost.events.player;

import fr.sharpheberg.sharpuhchost.config.message.Messages;
import org.apache.commons.lang3.tuple.Pair;
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

        Messages.Message.PLAYER_JOIN.broadcastMessage(Pair.of("player", player.getName()));

        player.teleport(player.getWorld().getSpawnLocation());
    }
}
