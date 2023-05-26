package fr.sharpheberg.sharpuhchost.config;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

public class ConfigManager {

    public static Config CONFIG = new Config("configuration");
    public static Config MESSAGE = new Config("message");

    public static class Config {

        private final File file;

        public Config(String name) {
            name = name + ".yml";

            File data_folder = fr.sharpheberg.sharpuhchost.Main.get().getDataFolder();
            if (!data_folder.exists()) {
                data_folder.mkdir();
            }

            this.file = new File(fr.sharpheberg.sharpuhchost.Main.get().getDataFolder(), name);
            if (!this.file.exists()) {
                try {
                    this.file.createNewFile();
                    FileConfiguration config = getConfig();
                    config.options().copyDefaults(true);
                    save(config);
                } catch (Exception e) {
                    System.out.println("Error while creating the file " + name);
                }
            }

        }

        public void addValue(String path, Object value) {
            FileConfiguration config = getConfig();
            if (config.get(path) != null) return;
            config.set(path, value);
            save(config);
        }

        public int getInteger(String path, int default_value) {
            addValue(path, default_value);
            return getConfig().getInt(path);
        }

        public double getDouble(String path, double default_value) {
            addValue(path, default_value);
            return getConfig().getDouble(path);
        }

        public String getString(String path, String default_value) {
            addValue(path, default_value);
            return getConfig().getString(path);
        }

        public boolean getBoolean(String path, boolean default_value) {
            addValue(path, default_value);
            return getConfig().getBoolean(path);
        }

        public List<String> getStringList(String path, List<String> default_value){
            addValue(path, default_value);
            return getConfig().getStringList(path);
        }

        public List<Integer> getIntegerList(String path, List<Integer> default_value){
            addValue(path, default_value);
            return getConfig().getIntegerList(path);
        }

        public Location getLocation(String path, Location default_value){
            addValue(path, default_value);
            return Location.deserialize(getConfig().getConfigurationSection(path).getValues(false));
        }

        private FileConfiguration getConfig(){
            return YamlConfiguration.loadConfiguration(file);
        }

        public void save(FileConfiguration config){
            try {
                config.save(file);
            } catch (Exception e) {
                System.out.println("Error while saving the file " + file.getName());
            }
        }
    }

}
