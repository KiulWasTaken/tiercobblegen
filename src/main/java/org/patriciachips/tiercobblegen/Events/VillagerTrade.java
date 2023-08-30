package org.patriciachips.tiercobblegen.Events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class VillagerTrade implements Listener {

    @EventHandler
    public void tradeWithVillager(VillagerAcquireTradeEvent e) {

            ItemStack resultItem = new ItemStack(Material.PAPER, 1);

            MerchantRecipe currentRecipe = e.getRecipe();
            MerchantRecipe newRecipe = new MerchantRecipe(resultItem, currentRecipe.getUses(), currentRecipe.getMaxUses(), currentRecipe.hasExperienceReward(), currentRecipe.getVillagerExperience(), currentRecipe.getPriceMultiplier(), currentRecipe.getDemand(), currentRecipe.getSpecialPrice());

            switch (currentRecipe.getResult().getType()) {
                case REDSTONE:
                    e.setRecipe(newRecipe);
                    break;
                case ENDER_PEARL:
                    e.setRecipe(newRecipe);
                    break;
                case NAME_TAG:
                    e.setRecipe(newRecipe);
                    break;
            }

    }
}
