package org.patriciachips.tiercobblegen.Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.patriciachips.tiercobblegen.CobbleGens;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.tiercobblegen;

import java.util.*;

public class BlockForm implements Listener {

    @EventHandler
    public void blockForm(BlockFormEvent e) {

        BlockState formedBlock = e.getNewState();

        if (formedBlock != null) {
            if (formedBlock.getType() == Material.STONE || formedBlock.getType() == Material.COBBLESTONE) {
                Player p = getGenUser(formedBlock.getLocation());
                if (p != null) {
                    //int tier = getGenTier(p);

                    Material chancedMaterial = getChancedMaterial(CobbleGens.gen1, formedBlock.getType());

                    formedBlock.setType(chancedMaterial);

                }
            } else if (e.getBlock().getType() == Material.BASALT) {

            }
        }

    }

    public Material getChancedMaterial(HashMap<Material, Double> generatorMaterials, Material defaultMaterial) {

        List<Material> generatorMaterialsKeys = new ArrayList<>(generatorMaterials.keySet());
        Collections.shuffle(generatorMaterialsKeys);

        Material chancedMaterial = defaultMaterial;

        Random random = new Random();
        Double randomDouble = random.nextInt(100) + (double) random.nextInt(101) / 100;

        for (Material materials : generatorMaterialsKeys) {
            Double chance = generatorMaterials.get(materials) * generatorMaterialsKeys.size();
            if (randomDouble <= chance) {
                chancedMaterial = materials;
                break;
            }
        }
        return chancedMaterial;
    }

    public Player getGenUser(Location loc) {
        for (Entity nearbyentities : loc.getWorld().getNearbyEntities(loc, 10, 10, 10)) {
            if (nearbyentities instanceof Player) {

                return (Player) nearbyentities;
            }
        }
        return null;
    }

    public int getGenTier(Player p) {
        for (int i = 0; i < 9; i++) {
            if (p.hasPermission("cobblegen." + i)) {
                return i;
            }
        }
        return 0;
    }
}
