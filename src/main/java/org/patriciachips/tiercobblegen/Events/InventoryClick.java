package org.patriciachips.tiercobblegen.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Methods.ColoredText;
import org.patriciachips.tiercobblegen.Inventorys.ShopInventorys;
import org.patriciachips.tiercobblegen.ShopItems;

import java.util.ArrayList;
import java.util.List;

public class InventoryClick implements Listener {

    @EventHandler
    public void playerJoin(InventoryClickEvent e) {

        if (ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase(ChatColor.stripColor(InnerConfig.shopInventoryNameString))) {
            e.setCancelled(true);
        }

        if (e.getWhoClicked() instanceof Player p) {
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                String currentItemName = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
                switch (currentItemName.toLowerCase()) {
                    case "take me back":
                        ShopInventorys.MainInventory(p);
                        break;
                    default:
                        for (ShopItems shopItems : ShopItems.values()) {
                            if (e.getCurrentItem().getType() == shopItems.getMaterial()) {
                                switch (shopItems.getItemInventory()) {
                                    case "main": /** Inventory Item */
                                        switch (shopItems.name()) {
                                            case "catagory_farming":
                                                ShopInventorys.shopInventory(p, "farming");
                                                break;
                                            case "catagory_foraging":
                                                ShopInventorys.shopInventory(p, "foraging");
                                                break;
                                            case "catagory_mining":
                                                ShopInventorys.shopInventory(p, "mining");
                                                break;
                                            case "catagory_mobdrops":
                                                ShopInventorys.shopInventory(p, "mobdrops");
                                                break;
                                            case "catagory_fishing":
                                                ShopInventorys.shopInventory(p, "fishing");
                                                break;
                                            case "catagory_redstone":
                                                break;
                                        }
                                        break;
                                    default:
                                        Integer itemAmount = 0;
                                        for (ItemStack itemStack : p.getInventory().getContents()) {
                                            if (itemStack != null && itemStack.getType() == e.getCurrentItem().getType()) {
                                                itemAmount = itemAmount + itemStack.getAmount();
                                            }
                                        }
                                        p.sendMessage(itemAmount + " " + shopItems.getBuyPrice() * itemAmount);
                                }
                                if (p.hasPermission("e")) {

                                } else {

                                }
                                break;
                            }
                        }
                }
            }
        }
    }

}
