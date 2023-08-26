package org.patriciachips.tiercobblegen.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.patriciachips.tiercobblegen.CustomConfigs.BalanceConfig;
import org.patriciachips.tiercobblegen.tiercobblegen;

public class Join implements Listener {

    @EventHandler
    public void blockForm(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        BalanceConfig.get().addDefault(p.getUniqueId().toString(), 0);

    }

}
