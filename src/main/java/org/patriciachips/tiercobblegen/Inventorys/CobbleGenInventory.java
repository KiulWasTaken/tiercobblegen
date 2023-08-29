package org.patriciachips.tiercobblegen.Inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Methods.ColoredText;
import org.patriciachips.tiercobblegen.Methods.ItemStackMethod;
import org.patriciachips.tiercobblegen.zEnums.CobbleGUIItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CobbleGenInventory {

    public static void cobbleGenInventory(Player p) {

        p.playSound(p.getLocation(), Sound.BLOCK_STONE_PLACE, 0.1F, 1F);

        Inventory inventory = Bukkit.createInventory(p, 54, ColoredText.t(InnerConfig.cobbleGenInventoryNameString));

        List<Material> pane = new ArrayList<>();
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);
        pane.add(Material.GRAY_STAINED_GLASS_PANE);

        int slot = 0;

        for (Material glassPane : pane) {
            inventory.setItem(slot, ItemStackMethod.createItemStack(" ", glassPane, 1, Arrays.asList(""), false, false));
            slot++;

            if (slot == 10 || slot == 19 || slot == 28 || slot == 37) {
                slot = slot + 7;
            }
        }

        int i = 4;

        for (CobbleGUIItems item : CobbleGUIItems.values()) {
            List<String> lore = new ArrayList<>();

            boolean isGlowing = false;

            if (item.isNether() == null) {
                isGlowing = true;
            }

            if (item.getGenerator() != null) {
                if (p.hasPermission("tiercobblegen." + item.name())) {
                    if (item.isNether() == false) {
                        if (PlayerDataConfig.get().getString(p.getUniqueId().toString() + ".activenormalgen").equalsIgnoreCase(item.name())) {
                            isGlowing = true;
                            lore.add(InnerConfig.generatorEnabled);
                        } else {
                            lore.add(InnerConfig.generatorDisabled);
                        }
                    } else if (item.isNether() == true) {
                        if (PlayerDataConfig.get().getString(p.getUniqueId().toString() + ".activenethergen").equalsIgnoreCase(item.name())) {
                            isGlowing = true;
                            lore.add(InnerConfig.generatorEnabled);
                        } else {
                            lore.add(InnerConfig.generatorDisabled);
                        }
                    }
                } else {
                    lore.add(InnerConfig.generatorNotOwned);
                }

                lore.addAll(CobbleGUIItems.convertHashmapToStringList(item.getGenerator()));
            }

            inventory.setItem(i, ItemStackMethod.createItemStack(item.getDisplayName(), item.getMaterial(), 1, lore, true, isGlowing));

            i++;
            if (i == 5) {
                i = i + 5;
            }
            if (i == 17) {
                i = i + 4;
            }
            if (i == 24) {
                i = i + 13;
            }
            if (i == 40) {
                i++;
            }
        }

        p.openInventory(inventory);


    }

}
