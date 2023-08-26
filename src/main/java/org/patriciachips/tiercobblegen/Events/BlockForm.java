package org.patriciachips.tiercobblegen.Events;

import org.bukkit.Material;
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



                    }
                }

            }
        }.runTaskTimer(tiercobblegen.getProvidingPlugin(tiercobblegen.class), 0L, 1L);

    }

}
