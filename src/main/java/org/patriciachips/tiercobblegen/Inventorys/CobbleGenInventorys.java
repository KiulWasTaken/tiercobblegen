package org.patriciachips.tiercobblegen.Inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.patriciachips.tiercobblegen.Commands.Bal;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Methods.ColoredText;
import org.patriciachips.tiercobblegen.Methods.ItemStackMethod;
import org.patriciachips.tiercobblegen.zEnums.CobbleGUIItems;
import org.patriciachips.tiercobblegen.zEnums.ShopGUIItems;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CobbleGenInventorys {

    public static void cobbleGenInventory(Player p) {

        p.playSound(p.getLocation(), Sound.BLOCK_STONE_PLACE, 0.1F, 1F);

        Inventory inventory = Bukkit.createInventory(p, 45, ColoredText.t(InnerConfig.cobbleGenInventoryNameString));

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

        int slot = 0;

        for (Material glassPane : pane) {
            inventory.setItem(slot, ItemStackMethod.createItemStack(" ", glassPane, 1, Arrays.asList(""), false, false));
            slot++;

            if (slot == 4) {
                slot++;
            }

            if (slot == 10) {
                slot = slot + 7;
            }

            if (slot == 20) {
                slot = slot + 5;
            }
        }

        int i = 4;

        for (CobbleGUIItems item : CobbleGUIItems.values()) {
            List<String> lore = new ArrayList<>();

            boolean isGlowing = false;

            if (item.isNether() == null) {
                isGlowing = true;
            }

            inventory.setItem(i, ItemStackMethod.createItemStack(item.getDisplayName(), item.getMaterial(), 1, Arrays.asList(item.getlore()), true, isGlowing));
            i++;
            if (i == 5) {
                i = i + 5;
            }
            if (i == 17) {
                i = i + 3;
            }
        }

        p.openInventory(inventory);


    }

}
