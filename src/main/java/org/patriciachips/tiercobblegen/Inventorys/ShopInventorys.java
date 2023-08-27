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
import org.patriciachips.tiercobblegen.zEnums.ShopGUIItems;

import java.text.DecimalFormat;
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

        inventory.setItem(4, ItemStackMethod.createItemStack(InnerConfig.balanceItemName + Bal.getPlayerBalance(p) + "$", Material.GOLD_INGOT, 1, List.of(new String[]{""}), true, false));

        for (ShopGUIItems item : ShopGUIItems.values()) {
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


        ItemStack backItem = ItemStackMethod.createItemStack(InnerConfig.backItemName, Material.PLAYER_HEAD, 1, List.of(new String[]{"&6» &7takes you back to safety, I promise"}), true, false);
        SkullMeta skullMeta = (SkullMeta) backItem.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer("MHF_ArrowLeft"));
        backItem.setItemMeta(skullMeta);
        inventory.setItem(0, backItem);

        inventory.setItem(4, ItemStackMethod.createItemStack(InnerConfig.balanceItemName + Bal.getPlayerBalance(p) + "$", Material.GOLD_INGOT, 1, List.of(new String[]{""}), true, false));

        int i = 10;

        for (ShopGUIItems item : ShopGUIItems.values()) {
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

    public static void buyItemInventory(Player p, Material itemToBuy, Integer itemBuyAmount, ShopGUIItems shopItem) {

        Inventory inventory = Bukkit.createInventory(p, 54, ColoredText.t(InnerConfig.buyInventoryNameString));

        if (itemBuyAmount < 1) {
            itemBuyAmount = 1;
        }

        int slot = 0;

        for (Material glassPane : getInventoryPanes()) {
            inventory.setItem(slot, ItemStackMethod.createItemStack(" ", glassPane, 1, Arrays.asList(""), false, false));
            slot++;

            if (slot == 10 || slot == 19 || slot == 28 || slot == 37) {
                slot = slot + 7;
            }
        }

        ItemStack backItem = ItemStackMethod.createItemStack(InnerConfig.backItemName, Material.PLAYER_HEAD, 1, List.of(new String[]{"&6» &7takes you back to safety, I promise"}), true, false);
        SkullMeta skullMeta = (SkullMeta) backItem.getItemMeta();
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer("MHF_ArrowLeft"));
        backItem.setItemMeta(skullMeta);
        inventory.setItem(0, backItem);

        inventory.setItem(4, ItemStackMethod.createItemStack(InnerConfig.balanceItemName + Bal.getPlayerBalance(p) + "$", Material.GOLD_INGOT, 1, List.of(new String[]{""}), true, false));

        List<Material> itemMaterial = new ArrayList<>();
        itemMaterial.add(itemToBuy);
        itemMaterial.add(Material.RED_STAINED_GLASS_PANE);
        itemMaterial.add(Material.RED_STAINED_GLASS_PANE);
        itemMaterial.add(Material.RED_STAINED_GLASS_PANE);
        itemMaterial.add(Material.EMERALD);
        itemMaterial.add(Material.LIME_STAINED_GLASS_PANE);
        itemMaterial.add(Material.LIME_STAINED_GLASS_PANE);
        itemMaterial.add(Material.LIME_STAINED_GLASS_PANE);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        List<String> itemDisplayName = new ArrayList<>();
        String name = itemToBuy.toString();
        name = name.replace("_", " ");
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        itemDisplayName.add(ColoredText.t("&#b4bccc" + itemBuyAmount + "x &#d4ed98&l" + name));
        itemDisplayName.add(ColoredText.t("&c&l- 32x"));
        itemDisplayName.add(ColoredText.t("&c&l- 8x"));
        itemDisplayName.add(ColoredText.t("&c&l- 1x"));
        itemDisplayName.add(ColoredText.t("&#2f8e44&lP&#319d49&lu&#33ad4d&lr&#34bc52&lc&#36cb56&lh&#34bc52&la&#33ad4d&ls&#319d49&le&#2f8e44&l? &7" + itemBuyAmount + "x " + name + " &7[&#3cb457" + decimalFormat.format((double) shopItem.getBuyPrice() * itemBuyAmount) + "$&7]"));
        itemDisplayName.add(ColoredText.t("&a&l+ 1x"));
        itemDisplayName.add(ColoredText.t("&a&l+ 8x"));
        itemDisplayName.add(ColoredText.t("&a&l+ 32x"));

        List<String[]> itemLore = new ArrayList<>();
        itemLore.add(new String[]{""});
        itemLore.add(new String[]{""});
        itemLore.add(new String[]{""});
        itemLore.add(new String[]{""});
        itemLore.add(new String[]{""});
        itemLore.add(new String[]{""});
        itemLore.add(new String[]{""});
        itemLore.add(new String[]{""});
        itemLore.add(new String[]{""});

        if (itemBuyAmount > 64) {
            itemBuyAmount = 64;
        }
        List<Integer> itemAmount = new ArrayList<>();
        itemAmount.add(itemBuyAmount);
        itemAmount.add(32);
        itemAmount.add(8);
        itemAmount.add(1);
        itemAmount.add(1);
        itemAmount.add(1);
        itemAmount.add(8);
        itemAmount.add(32);

        int itemInt = 0;
        int i = 13;

        for (Material material : itemMaterial) {

            if (i > 13) {
                itemBuyAmount = 1;
            }

            inventory.setItem(i, ItemStackMethod.createItemStack(ColoredText.t(itemDisplayName.get(itemInt)), itemMaterial.get(itemInt), itemAmount.get(itemInt), List.of(itemLore.get(itemInt)), true, false));

            i++;
            itemInt++;
            if (i == 14) {
                i = i + 14;
            }
        }

        p.openInventory(inventory);


    }

}
