package org.patriciachips.tiercobblegen.Inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Methods.ColoredText;
import org.patriciachips.tiercobblegen.Methods.ItemStackMethod;
import org.patriciachips.tiercobblegen.ShopItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopInventorys {

    public static List<Material> getInventoryPanes() {

        List<Material> pane = new ArrayList<>();
        pane.add(Material.BLUE_STAINED_GLASS_PANE);
        pane.add(Material.PURPLE_STAINED_GLASS_PANE);
        pane.add(Material.MAGENTA_STAINED_GLASS_PANE);
        pane.add(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        pane.add(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        pane.add(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        pane.add(Material.MAGENTA_STAINED_GLASS_PANE);
        pane.add(Material.PURPLE_STAINED_GLASS_PANE);
        pane.add(Material.BLUE_STAINED_GLASS_PANE);
        pane.add(Material.PURPLE_STAINED_GLASS_PANE);
        pane.add(Material.PURPLE_STAINED_GLASS_PANE);
        pane.add(Material.MAGENTA_STAINED_GLASS_PANE);
        pane.add(Material.MAGENTA_STAINED_GLASS_PANE);
        pane.add(Material.MAGENTA_STAINED_GLASS_PANE);
        pane.add(Material.MAGENTA_STAINED_GLASS_PANE);
        pane.add(Material.PURPLE_STAINED_GLASS_PANE);
        pane.add(Material.PURPLE_STAINED_GLASS_PANE);
        pane.add(Material.BLUE_STAINED_GLASS_PANE);
        pane.add(Material.PURPLE_STAINED_GLASS_PANE);
        pane.add(Material.MAGENTA_STAINED_GLASS_PANE);
        pane.add(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        pane.add(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        pane.add(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        pane.add(Material.MAGENTA_STAINED_GLASS_PANE);
        pane.add(Material.PURPLE_STAINED_GLASS_PANE);
        pane.add(Material.BLUE_STAINED_GLASS_PANE);

        return pane;

    }

    public static void MainInventory(Player p) {

        p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 0.1F, 1F);

        Inventory inventory = Bukkit.createInventory(p, 54, ColoredText.t(InnerConfig.shopInventoryNameString));

        int slot = 0;

        for (Material glassPane : getInventoryPanes()) {
            inventory.setItem(slot, ItemStackMethod.createItemStack(" ", glassPane, 1, Arrays.asList(""), false, false));
            slot++;

            if (slot == 10 || slot == 19 || slot == 28 || slot == 37) {
                slot = slot + 7;
            }
        }

        int i = 20;

        for (ShopItems item : ShopItems.values()) {
            if (item.getItemInventory().equalsIgnoreCase("main")) {
                List<String> lore = new ArrayList<>();

                inventory.setItem(i, ItemStackMethod.createItemStack(item.getDisplayName(), item.getMaterial(), 1, Arrays.asList(item.getlore()), true, false));
                i++;
                if (i == 25) {
                    i = i + 6;
                }
            }
        }

        p.openInventory(inventory);


    }

    public static void shopInventory(Player p, String inventoryItems) {

        switch (inventoryItems) {
            case "farming":
                p.playSound(p.getLocation(), Sound.BLOCK_GRASS_PLACE, 0.1F, 1F);
                break;
            case "foraging":
                p.playSound(p.getLocation(), Sound.BLOCK_WOOD_PLACE, 0.1F, 1F);
                break;
            case "mining":
                p.playSound(p.getLocation(), Sound.BLOCK_STONE_PLACE, 0.1F, 1F);
                break;
            case "mobdrops":
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 0.1F, 1F);
                break;
            case "fishing":
                p.playSound(p.getLocation(), Sound.ENTITY_FISHING_BOBBER_THROW, 0.1F, 0.3F);
                break;
        }

        Inventory inventory = Bukkit.createInventory(p, 54, ColoredText.t(InnerConfig.shopInventoryNameString));

        int slot = 0;

        for (Material glassPane : getInventoryPanes()) {
            inventory.setItem(slot, ItemStackMethod.createItemStack(" ", glassPane, 1, Arrays.asList(""), false, false));
            slot++;

            if (slot == 10 || slot == 19 || slot == 28 || slot == 37) {
                slot = slot + 7;
            }
        }

        inventory.setItem(0, ItemStackMethod.createItemStack("&#a20000&lT&#b70606&lA&#cb0d0d&lK&#e01313&lE &#f51a1a&lM&#f51a1a&lE &#e01313&lB&#cb0d0d&lA&#b70606&lC&#a20000&lK", Material.RED_STAINED_GLASS_PANE, 1, List.of(new String[]{"&6» &7takes you back to safety, I promise"}), true, false));

        int i = 10;

        for (ShopItems item : ShopItems.values()) {
            if (item.getItemInventory().equalsIgnoreCase(inventoryItems)) {
                List<String> lore = new ArrayList<>();
                if (item.getBuyPrice() > 0) {
                    lore.add(ColoredText.t(InnerConfig.buyPriceString + "&7" + item.getBuyPrice() + "&#bfbfbf$"));
                } else {
                    lore.add(ColoredText.t(InnerConfig.buyPriceString + "&cCannot buy this item!"));
                }

                if (item.getSellPrice() > 0) {
                    lore.add(ColoredText.t(InnerConfig.sellPriceString + "&7" + item.getSellPrice() + "&#bfbfbf$"));
                } else {
                    lore.add(ColoredText.t(InnerConfig.sellPriceString + "&cCannot sell this item!"));
                }

                String name = item.getMaterial().toString();
                name = name.replace("_", " ");
                name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

                inventory.setItem(i, ItemStackMethod.createItemStack(ColoredText.t("&#d4ed98&l" + name), item.getMaterial(), 1, lore, true, false));
                i++;
                if (i == 17 || i == 26 || i == 35 || i == 44) {
                    i = i + 2;
                }
            }
        }

        p.openInventory(inventory);


    }

}
