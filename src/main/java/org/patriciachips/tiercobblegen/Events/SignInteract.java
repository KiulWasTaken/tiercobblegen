package org.patriciachips.tiercobblegen.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.block.data.Attachable;
import org.bukkit.block.data.type.WallSign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSignOpenEvent;
import org.bukkit.inventory.*;
import org.patriciachips.tiercobblegen.Commands.Bal;
import org.patriciachips.tiercobblegen.Commands.Eco;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Methods.ColoredText;

import java.text.DecimalFormat;
import java.util.UUID;

public class SignInteract implements Listener {

    @EventHandler
    public void signInteract(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        if (e.getHand() == EquipmentSlot.HAND && e.getClickedBlock() != null) {
            boolean isWallSign = Tag.WALL_SIGNS.isTagged(e.getClickedBlock().getType());
            if (isWallSign == true) {

                Sign sign = (Sign) e.getClickedBlock().getState();

                Block attachedBlock = e.getClickedBlock().getRelative(((org.bukkit.material.Sign) e.getClickedBlock().getState().getData()).getAttachedFace());

                String line1 = sign.getLine(0);
                String line2 = sign.getLine(1);
                String line3 = sign.getLine(2);
                String line4 = sign.getLine(3);

                String setLine1sell = ColoredText.t("&#af0000&lS&#e40000&le&#e40000&ll&#af0000&ll: ");
                String setLine1buy = ColoredText.t("&#45af63&lB&#4cc06c&lu&#4cc06c&ly&#45af63&l: ");
                String setLine3 = ColoredText.t("&#ffffff");
                String setLine4 = ColoredText.t("&8" + p.getName());

                double buyPrice = 0;
                double sellPrice = 0.0;
                int amount = 0;

                if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (line1.equalsIgnoreCase("[shop]") && !line2.equalsIgnoreCase("") && !line3.equalsIgnoreCase("") && !line4.equalsIgnoreCase("") && p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() != Material.AIR && attachedBlock != null && attachedBlock.getType() == Material.CHEST) {
                        e.setCancelled(true);

                        try {
                            amount = Integer.parseInt(line3);

                            if (amount <= 0) {
                                return;
                            }

                            if (line2.equalsIgnoreCase("buy")) {
                                buyPrice = Double.parseDouble(line4);

                                int maxAmount = p.getInventory().getItemInMainHand().getType().getMaxStackSize();

                                if (amount > maxAmount) {
                                    amount = maxAmount;
                                }

                                if (buyPrice >= 0.001) {
                                    sign.setLine(0, setLine1buy + ChatColor.GRAY + amount + "x");
                                    sign.setLine(1, ChatColor.WHITE + "" + buyPrice + "$");
                                } else {
                                    return;
                                }
                            } else if (line2.equalsIgnoreCase("sell")) {
                                sellPrice = Double.parseDouble(line4);

                                int maxAmount = p.getInventory().getItemInMainHand().getType().getMaxStackSize();

                                if (amount > maxAmount) {
                                    amount = maxAmount;
                                }

                                if (sellPrice >= 0.001) {
                                    sign.setLine(0, setLine1sell + ChatColor.GRAY + amount + "x");
                                    sign.setLine(1, ChatColor.WHITE + "" + sellPrice + "$");
                                } else {
                                    return;
                                }
                            }
                        } catch (NumberFormatException a) {
                            return;
                        }

                        sign.setLine(2, setLine3 + p.getInventory().getItemInMainHand().getType());
                        sign.setLine(3, setLine4);

                        sign.update();

                        return;
                    }

                    Integer itemAmount = Integer.parseInt(ChatColor.stripColor(line1).replaceAll("[\\D]", ""));
                    if (line1.equalsIgnoreCase(setLine1buy + ChatColor.GRAY + itemAmount + "x") || line1.equalsIgnoreCase(setLine1sell + ChatColor.GRAY + itemAmount + "x")) {
                        Double cost = Double.parseDouble(ChatColor.stripColor(line2).replace("$", ""));
                        Material material = Material.valueOf(ChatColor.stripColor(line3));
                        UUID seller = Bukkit.getServer().getOfflinePlayer(ChatColor.stripColor(line4)).getUniqueId();

                        Chest chest = (Chest) attachedBlock.getState();

                        String type = ChatColor.stripColor(line1).charAt(0) + "";

                        DecimalFormat decimalFormat = new DecimalFormat("0.00");

                        switch (type.toLowerCase()) {
                            case "b":
                                if (p.getUniqueId() != seller) {
                                    if (Bal.getPlayerBalance(p.getUniqueId()) >= cost) {
                                        if (shopItemAmount(chest.getInventory(), material) >= itemAmount) {
                                            if (invSpace(p.getInventory(), material) >= itemAmount) {

                                                removeInvItems(chest.getInventory(), material, itemAmount);

                                                p.getInventory().addItem(new ItemStack(material, itemAmount));

                                                p.sendMessage(ColoredText.t(InnerConfig.chestShopBuy + itemAmount + "x " + material + " &7[&#ab4a30-" + decimalFormat.format(cost) + "$&7]"));

                                                if (Bukkit.getOfflinePlayer(seller).getPlayer() != null) {
                                                    Bukkit.getOfflinePlayer(seller).getPlayer().sendMessage(ColoredText.t("&7[&#f07e75»&7] &#3cb560" + p.getName() + " has purchased &8» &7" + itemAmount + "x " + material + " &7[&#3cb560+" + decimalFormat.format(cost) + "$&7]"));
                                                }

                                                Eco.changeBalance(null, p.getUniqueId(), "remove", cost);
                                                Eco.changeBalance(null, seller, "add", cost);

                                            } else {
                                                p.sendMessage(InnerConfig.lackInventorySpace);
                                            }
                                        } else {
                                            p.sendMessage(InnerConfig.shopOutOfStock);
                                        }
                                    } else {
                                        p.sendMessage(InnerConfig.insufficientFunds);
                                    }
                                } else {
                                    p.sendMessage(InnerConfig.cantBuyToself);
                                }
                                break;
                            case "s":
                                if (p.getUniqueId() != seller) {
                                    if (playerItemAmount(p.getInventory(), material) >= itemAmount) {
                                        if (Bal.getPlayerBalance(seller) >= cost) {
                                            if (chestIntSpace(chest.getInventory(), material) >= itemAmount) {

                                                removeInvItems(p.getInventory(), material, itemAmount);

                                                chest.getInventory().addItem(new ItemStack(material, itemAmount));

                                                p.sendMessage(ColoredText.t(InnerConfig.chestShopSell + itemAmount + "x " + material + " &7[&#3cb560+" + decimalFormat.format(cost) + "$&7]"));

                                                if (Bukkit.getOfflinePlayer(seller).getPlayer() != null) {
                                                    Bukkit.getOfflinePlayer(seller).getPlayer().sendMessage(ColoredText.t("&7[&#f07e75»&7] &#3cb560" + p.getName() + " has sold items to you &8» &7" + itemAmount + "x " + material + " &7[&#ab4a30-" + decimalFormat.format(cost) + "$&7]"));
                                                }

                                                Eco.changeBalance(null, p.getUniqueId(), "add", cost);
                                                Eco.changeBalance(null, seller, "remove", cost);

                                            } else {
                                                p.sendMessage(InnerConfig.chestShopLacksSpace);
                                            }
                                        } else {
                                            p.sendMessage(InnerConfig.sellerLacksFunds);
                                        }
                                    } else {
                                        p.sendMessage(InnerConfig.lackOfMaterial);
                                    }
                                } else {
                                    p.sendMessage(InnerConfig.cantSellToself);
                                }
                                break;
                        }
                    }

                } else if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    if (!p.isSneaking()) {
                        try {
                            if (attachedBlock.getType() == Material.CHEST) {
                                Integer itemAmount = Integer.parseInt(ChatColor.stripColor(line1).replaceAll("[\\D]", ""));
                                if (line1.equalsIgnoreCase(setLine1buy + ChatColor.GRAY + itemAmount + "x") || line1.equalsIgnoreCase(setLine1sell + ChatColor.GRAY + itemAmount + "x")) {
                                    e.setCancelled(true);

                                    Chest chest = (Chest) attachedBlock.getState();

                                    Inventory inventory = Bukkit.createInventory(p, chest.getInventory().getSize(), "Shop Inventory");

                                    inventory.setContents(chest.getInventory().getContents());

                                    p.openInventory(inventory);
                                }
                            }
                        } catch (NumberFormatException a) {
                        }
                    }
                }

            }
        }

    }

    public static void removeInvItems(Inventory inventory, Material mat, int amount) {

        for (ItemStack item : inventory.getContents()) {
            if (item != null && item.getType() == mat) {
                if (item.getAmount() <= amount) {
                    amount = amount - item.getAmount();
                    item.setAmount(0);
                } else {
                    item.setAmount(item.getAmount() - amount);
                    amount = 0;
                }
                if (amount == 0) {
                    return;
                }
            }
        }

    }

    public static int playerItemAmount(PlayerInventory playerInventory, Material mat) {
        int amount = 0;

        for (ItemStack item : playerInventory.getStorageContents()) {
            if (item != null && item.getType() == mat) {
                amount = amount + item.getAmount();
            }
        }

        return amount;
    }

    public static int shopItemAmount(Inventory shopInventory, Material mat) {

        int amount = 0;

        for (ItemStack item : shopInventory.getStorageContents()) {
            if (item != null && item.getType() == mat) {
                amount = amount + item.getAmount();
            }
        }

        return amount;
    }

    public static int invSpace(PlayerInventory playerInventory, Material mat) {

        int amount = 0;

        for (ItemStack item : playerInventory.getContents()) {
            if (item == null || item.getType() == Material.AIR) {
                amount = amount + mat.getMaxStackSize();
            }
            if (item != null && item.getType() == mat) {
                if (item.getAmount() < item.getMaxStackSize()) {
                    amount = amount + (item.getMaxStackSize() - item.getAmount());
                }
            }
        }

        return amount;
    }

    public static int chestIntSpace(Inventory chestInventory, Material mat) {

        int amount = 0;

        for (ItemStack item : chestInventory.getContents()) {
            if (item == null || item.getType() == Material.AIR) {
                amount = amount + mat.getMaxStackSize();
            }
            if (item != null && item.getType() == mat) {
                if (item.getAmount() < item.getMaxStackSize()) {
                    amount = amount + (item.getMaxStackSize() - item.getAmount());
                }
            }
        }

        return amount;
    }

}
