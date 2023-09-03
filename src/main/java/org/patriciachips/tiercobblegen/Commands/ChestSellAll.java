package org.patriciachips.tiercobblegen.Commands;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.patriciachips.tiercobblegen.Methods.ShopMethods;
import org.patriciachips.tiercobblegen.zEnums.ShopGUIItems;

public class ChestSellAll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p) {

            Block block = p.getTargetBlockExact(5);

            if (block != null && block.getType() == Material.CHEST) {
                Chest chest = (Chest) block.getState();
                for (ItemStack itemStack : chest.getBlockInventory().getContents()) {
                    for (ShopGUIItems items : ShopGUIItems.values()) {
                        if (itemStack != null && itemStack.getType() == items.getMaterial() && !items.name().contains("catagory")) {
                            ShopMethods.sellAllItem(p, items.getSellPrice(), items.getMaterial(), chest.getInventory());
                            break;
                        }
                    }
                }
            }

        }

        return false;
    }

}
