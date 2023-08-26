package org.patriciachips.tiercobblegen.CustomConfigs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class TeamsConfig {

    private static File dataFolder;

    private static HashMap<UUID, File> leaderFile = new HashMap<>();
    private static HashMap<UUID, FileConfiguration> leaderFileConfig = new HashMap<>();

    public static void setup(Player p) {
        dataFolder = new File(Bukkit.getServer().getPluginManager().getPlugin("PattyEssentialsV2").getDataFolder(), "teamdata");
        File file = new File(dataFolder, p.getUniqueId() + ".yml");

        leaderFile.put(p.getUniqueId(), file);

        if(!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {

            }
        }
         leaderFileConfig.put(p.getUniqueId(), YamlConfiguration.loadConfiguration(file));
    }

    public static void rename(Player fromPlayer, Player toPlayer) {
        File renamedFile = new File(dataFolder, toPlayer.getUniqueId() + ".yml");
        File file = leaderFile.get(fromPlayer.getUniqueId());
        file.renameTo(renamedFile);
        leaderFile.remove(fromPlayer.getUniqueId());
        leaderFileConfig.remove(fromPlayer.getUniqueId());
        leaderFile.put(toPlayer.getUniqueId(), file);
        leaderFileConfig.put(toPlayer.getUniqueId(), YamlConfiguration.loadConfiguration(file));
    }

    public static FileConfiguration get(Player p) {
        if (leaderFileConfig.containsKey(p.getUniqueId())) {
            return leaderFileConfig.get(p.getUniqueId());
        } else {
            return null;
        }
    }

    public static void save(Player p){
        try {
            leaderFileConfig.get(p.getUniqueId()).save(leaderFile.get(p.getUniqueId()));
        } catch (IOException e) {
            System.out.println("Failed to save file.");
        }
    }

}
