package org.patriciachips.tiercobblegen.CustomConfigs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class PlayerDataConfig {

    private static File dataFolder;

    private static HashMap<UUID, File> playerFile = new HashMap<>();
    private static HashMap<UUID, FileConfiguration> playerFileConfig = new HashMap<>();

    public static void setup(Player p) {
        dataFolder = new File(Bukkit.getServer().getPluginManager().getPlugin("PattyEssentialsV2").getDataFolder(), "playerdata");
        File file = new File(dataFolder, p.getUniqueId() + ".yml");

        playerFile.put(p.getUniqueId(), file);

        if(!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {

            }
        }
         playerFileConfig.put(p.getUniqueId(), YamlConfiguration.loadConfiguration(file));
    }

    public static FileConfiguration get(Player p) {
        return playerFileConfig.get(p.getUniqueId());
    }

    public static void save(Player p){
        try {
            playerFileConfig.get(p.getUniqueId()).save(playerFile.get(p.getUniqueId()));
        } catch (IOException e) {
            System.out.println("Failed to save file.");
        }
    }

}
