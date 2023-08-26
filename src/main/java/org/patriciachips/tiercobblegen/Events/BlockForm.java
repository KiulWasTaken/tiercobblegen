package org.patriciachips.tiercobblegen.Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.patriciachips.tiercobblegen.tiercobblegen;

public class BlockForm implements Listener {

    @EventHandler
    public void blockForm(BlockFormEvent e) {

        new BukkitRunnable() {
            public void run() {


                if (e.getBlock() != null) {
                    if (e.getBlock().getType() == Material.STONE || e.getBlock().getType() == Material.COBBLESTONE) {
                        Player p = getGenUser(e.getBlock());
                        if (p != null) {
                            int tier = getGenTier(p);
                        }
                    } else if (e.getBlock().getType() == Material.BASALT) {

                    }
                }

            }
        }.runTaskTimer(tiercobblegen.getProvidingPlugin(tiercobblegen.class), 0L, 1L);

    }


    public Player getGenUser (Block b) {
        for (Entity nearbyentities : b.getWorld().getNearbyEntities(b.getLocation(),10,10,10) ) {
            if (nearbyentities instanceof Player) {

                return (Player) nearbyentities;
            }
        }
    return null;
    }

    public int getGenTier (Player p) {
        for (int i = 0; i < 9; i++) {
            if (p.hasPermission("cobblegen." + i)) {
                return i;
            }
        }
    return 0;}
}
