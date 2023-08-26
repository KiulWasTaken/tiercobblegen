package org.patriciachips.tiercobblegen.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.patriciachips.tiercobblegen.Inventorys.ShopInventorys;

public class Shop implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p) {

            ShopInventorys.MainInventory(p);

        }

        return false;
    }
}
