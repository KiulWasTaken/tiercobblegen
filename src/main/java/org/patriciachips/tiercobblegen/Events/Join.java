package org.patriciachips.tiercobblegen.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;

public class Join implements Listener {

    @EventHandler
    public void blockForm(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        PlayerDataConfig.get().addDefault(p.getUniqueId().toString() + ".bal", 0.0);
        PlayerDataConfig.get().addDefault(p.getUniqueId().toString() + ".activegen", "gen1");

        PlayerDataConfig.save();

    }

}
