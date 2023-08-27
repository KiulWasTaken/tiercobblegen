package org.patriciachips.tiercobblegen.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.patriciachips.tiercobblegen.CobbleGens;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Inventorys.CobbleGenInventorys;
import org.patriciachips.tiercobblegen.zEnums.CobbleGUIItems;

import java.text.DecimalFormat;

public class Gen implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p) {

            CobbleGenInventorys.cobbleGenInventory(p);

            p.sendMessage(CobbleGUIItems.convertHashmapToString(CobbleGens.gen1));

        }
        return false;
    }
}
