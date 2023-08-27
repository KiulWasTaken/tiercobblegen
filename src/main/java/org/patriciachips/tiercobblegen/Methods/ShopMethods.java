package org.patriciachips.tiercobblegen.Methods;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.InnerConfig;

public class ShopMethods {

    public static void sellAllItem(Player p, Double sellPrice, ItemStack clickedItem) {

        Integer itemAmount = 0;
        Double balMade = 0.0;
        for (ItemStack itemStack : p.getInventory().getContents()) {
            if (itemStack != null && itemStack.getType() == clickedItem.getType()) {
                balMade = balMade + itemStack.getAmount() * sellPrice;
                itemAmount = itemAmount + itemStack.getAmount();
                itemStack.setAmount(0);
            }
        }

        if (balMade > 0) {
            PlayerDataConfig.get().set(p.getUniqueId().toString() + ".bal", PlayerDataConfig.get().getDouble(p.getUniqueId().toString() + ".bal") + balMade);
            PlayerDataConfig.save();

            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.1f, 2);
            p.sendMessage(ColoredText.t(InnerConfig.soldAllItem + itemAmount + "x " + clickedItem.getType() + " &7[&#8bd169" + balMade + "$&7]"));
        } else {
            p.sendMessage(InnerConfig.cantSellItem);
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 0.1f, 0.5f);
        }

    }

}
