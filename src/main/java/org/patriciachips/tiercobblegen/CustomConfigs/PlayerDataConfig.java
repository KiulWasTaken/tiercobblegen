package org.patriciachips.tiercobblegen.CustomConfigs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerDataConfig {

        private static File file;
        private static FileConfiguration configFile;

        public static void setup() {
            file = new File(Bukkit.getServer().getPluginManager().getPlugin("tiercobblegen").getDataFolder(), "playerdata.yml");

            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {

                }
            }
            configFile = YamlConfiguration.loadConfiguration(file);
        }

        public static FileConfiguration get() {
            return configFile;
        }

        public static void save(){
            try {
                configFile.save(file);
            } catch (IOException e) {
                System.out.println("Failed to save, configFile.");
            }
        }

        public static void reload(){
            configFile = YamlConfiguration.loadConfiguration(file);
        }


        
}
