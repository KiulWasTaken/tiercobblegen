package org.patriciachips.tiercobblegen.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.patriciachips.tiercobblegen.Commands.Bal;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Inventorys.CobbleGenInventory;
import org.patriciachips.tiercobblegen.Inventorys.ShopInventorys;
import org.patriciachips.tiercobblegen.Methods.ColoredText;
import org.patriciachips.tiercobblegen.Methods.ItemStackMethod;
import org.patriciachips.tiercobblegen.Methods.ShopMethods;
import org.patriciachips.tiercobblegen.zEnums.CobbleGUIItems;
import org.patriciachips.tiercobblegen.zEnums.ShopGUIItems;

import java.util.List;

public class InventoryClick implements Listener {

    @EventHandler
    public void playerJoin(InventoryClickEvent e) {

        String currentItemName = "";

        if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
            currentItemName = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
        }

        if (e.getWhoClicked() instanceof Player p) {
            if (ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase(ChatColor.stripColor(InnerConfig.shopInventoryNameString))) {
                e.setCancelled(true);
                if (!ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase(ChatColor.stripColor(InnerConfig.balanceItemName + Bal.getPlayerBalance(p) + "$"))) {
                    switch (currentItemName.toLowerCase()) {
                        case "take me back":
                            ShopInventorys.MainInventory(p);
                            break;
                        default:
                            for (ShopGUIItems shopItems : ShopGUIItems.values()) {
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
                                            if (e.getClick().isRightClick()) { /** Sell */
                                                ShopMethods.sellAllItem(p, shopItems.getSellPrice(), e.getCurrentItem().getType(), p.getInventory());
                                                ShopInventorys.shopInventory(p, shopItems.getItemInventory());
                                            } else if (e.getClick().isLeftClick()) { /** Buy */
                                                if (shopItems.getBuyPrice() > 0) {
                                                    ShopInventorys.buyItemInventory(p, e.getCurrentItem().getType(), e.getCurrentItem().getAmount(), shopItems);
                                                } else {
                                                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 0.1f, 0.5f);
                                                    p.sendMessage(InnerConfig.cantBuyItem);
                                                }
                                            }
                                    }
                                    break;
                                }
                            }
                    }
                }
            } else if (ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase(ChatColor.stripColor(InnerConfig.buyInventoryNameString))) {
                e.setCancelled(true);
                Inventory inv = e.getView().getTopInventory();
                Integer buyItemAmount = ItemStackMethod.getIntWithinName(inv.getItem(13).getItemMeta().getDisplayName());
                Integer constantItemAmount = ItemStackMethod.getIntWithinName(inv.getItem(13).getItemMeta().getDisplayName());
                switch (currentItemName.toLowerCase()) {
                    case "take me back":
                        ShopInventorys.MainInventory(p);
                        break;
                    default:
                        for (ShopGUIItems shopItems : ShopGUIItems.values()) {
                            if (inv.getItem(13).getType() == shopItems.getMaterial()) {
                                switch (e.getCurrentItem().getType()) {
                                    case RED_STAINED_GLASS_PANE:
                                        int removeAmount = ItemStackMethod.getIntWithinName(e.getCurrentItem().getItemMeta().getDisplayName());
                                        if (removeAmount > buyItemAmount) {
                                            removeAmount = removeAmount - buyItemAmount;
                                        }
                                        ShopInventorys.buyItemInventory(p, inv.getItem(13).getType(), buyItemAmount - removeAmount, shopItems);
                                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 0.03f, 1.5f);
                                        break;
                                    case LIME_STAINED_GLASS_PANE:
                                        int addAmount = ItemStackMethod.getIntWithinName(e.getCurrentItem().getItemMeta().getDisplayName());
                                        ShopInventorys.buyItemInventory(p, inv.getItem(13).getType(), buyItemAmount + addAmount, shopItems);
                                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 0.03f, 1f);
                                        break;
                                    case EMERALD:
                                        if (Bal.getPlayerBalance(p) > (double) buyItemAmount * shopItems.getBuyPrice()) {
                                            Integer freeSpace = ItemStackMethod.getItemInvSpace(p, inv.getItem(13).getType());
                                            if (freeSpace > 0) {
                                                if (buyItemAmount > freeSpace) {
                                                    buyItemAmount = freeSpace;
                                                    p.sendMessage(ColoredText.t(InnerConfig.purchasedItemsString + buyItemAmount + "x " + inv.getItem(13).getType() + " &7[&c-" + buyItemAmount * shopItems.getBuyPrice() + "$&7] " + InnerConfig.purchaseAdjustedString));
                                                } else {
                                                    p.sendMessage(ColoredText.t(InnerConfig.purchasedItemsString + buyItemAmount + "x " + inv.getItem(13).getType() + " &7[&c-" + buyItemAmount * shopItems.getBuyPrice() + "$&7] "));
                                                }
                                                PlayerDataConfig.get().set(p.getUniqueId().toString() + ".bal", PlayerDataConfig.get().getDouble(p.getUniqueId().toString() + ".bal") - (buyItemAmount * shopItems.getBuyPrice()));
                                                PlayerDataConfig.save();
                                                p.getInventory().addItem(new ItemStack(inv.getItem(13).getType(), buyItemAmount));
                                                p.playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_PREPARE_MIRROR, 0.1f, 1);
                                                ShopInventorys.buyItemInventory(p, inv.getItem(13).getType(), constantItemAmount, shopItems);
                                            } else {
                                                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 0.1f, 0.5f);
                                                p.sendMessage(InnerConfig.notEnoughSpaceBuyString);
                                            }
                                        } else {
                                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 0.1f, 0.5f);
                                            p.sendMessage(InnerConfig.insufficientFunds);
                                        }
                                        break;
                                }
                                break;
                            }
                        }
                }
            } else if (ChatColor.stripColor(e.getView().getTitle()).equalsIgnoreCase(ChatColor.stripColor(InnerConfig.cobbleGenInventoryNameString))) {

                e.setCancelled(true);

                if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasLore()) {

                    for (CobbleGUIItems generators : CobbleGUIItems.values()) {
                        if (e.getCurrentItem().getType() == generators.getMaterial()) {
                            if (generators.getGenerator() != null) {
                                if (p.hasPermission("tiercobblegen." + generators.name())) {
                                    if (generators.isNether() != true) {

                                        if (!PlayerDataConfig.get().getString(p.getUniqueId().toString() + ".activenormalgen").equalsIgnoreCase(generators.name())) {
                                            PlayerDataConfig.get().set(p.getUniqueId().toString() + ".activenormalgen", generators.name());
                                        } else {
                                            PlayerDataConfig.get().set(p.getUniqueId().toString() + ".activenormalgen", "null");
                                        }

                                    } else {

                                        if (!PlayerDataConfig.get().getString(p.getUniqueId().toString() + ".activenethergen").equalsIgnoreCase(generators.name())) {
                                            PlayerDataConfig.get().set(p.getUniqueId().toString() + ".activenethergen", generators.name());
                                        } else {
                                            PlayerDataConfig.get().set(p.getUniqueId().toString() + ".activenethergen", "null");
                                        }

                                    }
                                    PlayerDataConfig.save();
                                    CobbleGenInventory.cobbleGenInventory(p);
                                } else {
                                    p.sendMessage(InnerConfig.dontOwnGenerator);
                                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 0.1f, 0.5f);
                                }
                                break;
                            }
                        }
                    }

                }

            }
        }
    }
}
