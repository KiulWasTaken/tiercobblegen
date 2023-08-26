package org.patriciachips.tiercobblegen.Methods;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
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

}
