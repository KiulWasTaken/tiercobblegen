package org.patriciachips.tiercobblegen.Events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.patriciachips.tiercobblegen.CobbleGens;

import java.util.Random;

public class BreakOre implements Listener {

    @EventHandler
    public void antiAFK (BlockBreakEvent e) {
        if (CobbleGens.gen8.containsKey(e.getBlock().getType()) || CobbleGens.nethergen4.containsKey(e.getBlock().getType())) {
            Random random = new Random();
            if (random.nextDouble() < 0.01) {
                e.getPlayer().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.SILVERFISH);
                e.getPlayer().sendMessage(ChatColor.RED + "A silverfish broke out of your cobblegen!");
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE,2,1);
            }
        }
    }
}
