package fr.sharpheberg.sharpuhchost.config.message;

import fr.sharpheberg.sharpuhchost.config.ConfigManager;
import fr.sharpheberg.sharpuhchost.config.settings.Settings;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Messages {

    public enum Message {
        PREFIX("&7[&bSharpUHC&7] &3"),
        PLAYER_JOIN("<prefix>&a<player> &3a rejoint la partie ! &8(&a<online>&8/&c<max>&8)"),
        PLAYER_LEAVE("<prefix>&c<player> &3a quitté la partie ! &8(&a<online>&8/&c<max>&8)"),
        ;

        private final String message;
        Message(String message){
            this.message = ConfigManager.MESSAGE.getString(this.name().toLowerCase().replace("_", "."), message);
        }

        @SafeVarargs
        public final String getMessage(Pair<String, Object>... pairs){
            return replace(null, message, pairs);
        }

        @SafeVarargs
        public final void broadcastMessage(Pair<String, Object>... pairs){
            Bukkit.broadcastMessage(getMessage(pairs));
        }
    }


    private static String replace(Player player, String message, Pair<String, Object>... pairs){

        message = message.replace("&", "§");

        for (Pair<String, Object> pair : pairs){
            String key = "<" + pair.getKey() + ">";
            if (message.contains(key)){
                message = message.replace(key, pair.getValue().toString());
            }
        }

        if (message.contains("<prefix>")){
            message = message.replace("<prefix>", Message.PREFIX.getMessage());
        }

        if (message.contains("<online>")){
            message = message.replace("<online>", String.valueOf(Bukkit.getOnlinePlayers().size()));
        }

        if (message.contains("<max>")){
            message = message.replace("<max>", String.valueOf(Settings.Integer.SLOTS.getValue()));
        }

        return message;
    }

    public static void setup(){
        for (Message message : Message.values()){

        }
    }

}
