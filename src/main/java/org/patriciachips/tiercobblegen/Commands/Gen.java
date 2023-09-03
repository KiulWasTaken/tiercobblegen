package org.patriciachips.tiercobblegen.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.patriciachips.tiercobblegen.Inventorys.CobbleGenInventory;

public class Gen implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p) {

            CobbleGenInventory.cobbleGenInventory(p);

        }
        return false;

    }
}
