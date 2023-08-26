package org.patriciachips.tiercobblegen.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Methods.ColoredText;
import org.patriciachips.tiercobblegen.Inventorys.ShopInventorys;
import org.patriciachips.tiercobblegen.ShopItems;

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
                }
                for (ShopItems shopItems : ShopItems.values()) {
                    String shopItemName = ChatColor.stripColor(ColoredText.t(shopItems.getDisplayName()));
                    if (shopItemName.equalsIgnoreCase(currentItemName)) { /** Item Contained within Enum */
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
                        }
                        break;
                    }
                }

            }

        }
    }

}
