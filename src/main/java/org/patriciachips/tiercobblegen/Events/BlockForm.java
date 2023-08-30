package org.patriciachips.tiercobblegen.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.zEnums.CobbleGUIItems;

import java.util.*;

public class BlockForm implements Listener {

    @EventHandler
    public void blockForm(BlockFormEvent e) {

        BlockState formedBlock = e.getNewState();

        if (formedBlock != null) {
            if (formedBlock.getType() == Material.STONE || formedBlock.getType() == Material.COBBLESTONE) {
                Player p = getGenUser(formedBlock.getLocation());
                if (p != null) {
                    CobbleGUIItems generator = getGenTier(p, "activenormalgen");

                    if (generator != null) {
                        Material chancedMaterial = getChancedMaterial(generator.getGenerator(), formedBlock.getType());

                        formedBlock.setType(chancedMaterial);
                    }

                }
            } else if (formedBlock.getType() == Material.BASALT) {
                Player p = getGenUser(formedBlock.getLocation());
                if (p != null) {
                    CobbleGUIItems generator = getGenTier(p, "activenethergen");

                    if (generator != null) {
                        Material chancedMaterial = getChancedMaterial(generator.getGenerator(), formedBlock.getType());

                        formedBlock.setType(chancedMaterial);
                    }

                }

            }
        }

    }

    public Material getChancedMaterial(HashMap<Material, Double> generatorMaterials, Material defaultMaterial) {

        List<Material> generatorMaterialsKeys = new ArrayList<>(generatorMaterials.keySet());
        List<Material> randomMaterialList = new ArrayList<>();

        for (Material materials : generatorMaterialsKeys) {
            Double chance = generatorMaterials.get(materials) * 10;
            for (int i = 0; i < chance; i++) {
                randomMaterialList.add(materials);
            }
        }
        while (randomMaterialList.size() < 1000) {
            randomMaterialList.add(defaultMaterial);
        }
        Collections.shuffle(randomMaterialList);
        return randomMaterialList.get(0);
    }

    public Player getGenUser(Location loc) {
        for (Entity nearbyentities : loc.getWorld().getNearbyEntities(loc, 10, 10, 10)) {
            if (nearbyentities instanceof Player) {

                return (Player) nearbyentities;
            }
        }
        return null;
    }

    public CobbleGUIItems getGenTier(Player p, String gentype) {
        if (!PlayerDataConfig.get().getString(p.getUniqueId().toString() + "." + gentype).equalsIgnoreCase("null")) {
            for (CobbleGUIItems generators : CobbleGUIItems.values()) {
                if (PlayerDataConfig.get().getString(p.getUniqueId().toString() + "." + gentype).equalsIgnoreCase(generators.name())) {
                    return generators;
                }
            }
        } else {
            return null;
        }
        return null;
    }
}
