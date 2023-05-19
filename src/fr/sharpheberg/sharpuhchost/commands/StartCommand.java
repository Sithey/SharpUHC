package fr.sharpheberg.sharpuhchost.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)){
            sender.sendMessage("§cVous devez être un joueur pour executer cette commande !");
            return false;
        }

        Player player = (Player) sender;

        if (!player.isOp()){
            player.sendMessage("§cVous devez être op pour executer cette commande !");
            return false;
        }

        player.sendMessage("§aLa partie commence !");
        return false;
    }
}
