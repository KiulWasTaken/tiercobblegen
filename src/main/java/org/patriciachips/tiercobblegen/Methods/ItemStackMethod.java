package org.patriciachips.tiercobblegen.Methods;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.patriciachips.tiercobblegen.GlintEnchantment;
import org.patriciachips.tiercobblegen.Methods.ColoredText;
import org.patriciachips.tiercobblegen.tiercobblegen;

import java.util.ArrayList;
import java.util.List;

public class ItemStackMethod {

    public static ItemStack createItemStack(String displayName, Material itemMaterial, Integer itemAmount, List<String> lore, Boolean isUnbreaking, Boolean isGlowing) {

        List<String> adjustedLore = new ArrayList<>();
        for (String loreString : lore) {
            adjustedLore.add(ColoredText.t(loreString));
        }

        ItemStack itemStack = new ItemStack(itemMaterial, itemAmount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ColoredText.t(displayName));
        itemMeta.setLore(adjustedLore);
        itemMeta.setUnbreakable(isUnbreaking);
        if (isGlowing == true) {
            GlintEnchantment glow = new GlintEnchantment(new NamespacedKey(tiercobblegen.getPlugin(tiercobblegen.class), "glow"));
            itemMeta.addEnchant(glow, 1, true);
        }
        itemStack.setItemMeta(itemMeta);

        return itemStack;

    }

    public static Integer getIntWithinName(String displayName) {
        String itemName = ChatColor.stripColor(displayName);
        int nameLength = itemName.length();
        String containedNumber = "";
        for (int i = 0; i < nameLength; i++) {
            Character character = itemName.charAt(i);
            if (Character.isDigit(character)) {
                containedNumber += character;
            }
        }

        return Integer.parseInt(containedNumber);

    }

    public static Integer getItemInvSpace(Player p, Material checkItemType) {

        int itemFreespace = 0;

        for (ItemStack itemStack : p.getInventory().getStorageContents()) {
            if (itemStack == null) {
                itemFreespace = itemFreespace + checkItemType.getMaxStackSize();
            } else {
                if (itemStack.getType() == checkItemType) {
                    if (!itemStack.hasItemMeta() || itemStack.hasItemMeta() && !itemStack.getItemMeta().hasDisplayName()) {
                        itemFreespace = itemFreespace + (checkItemType.getMaxStackSize() - itemStack.getAmount());
                    }
                }
            }
        }
        return itemFreespace;
    }
}
