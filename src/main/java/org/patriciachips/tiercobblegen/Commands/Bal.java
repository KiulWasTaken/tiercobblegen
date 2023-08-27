package org.patriciachips.tiercobblegen.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Inventorys.ShopInventorys;

import java.text.DecimalFormat;

public class Bal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p) {

            Double playerBalance = getPlayerBalance(p);

            p.sendMessage(InnerConfig.currentBalance + playerBalance +"$");

        }

        return false;
    }

    public static Double getPlayerBalance(Player p) {

        Double playerBalance = PlayerDataConfig.get().getDouble(p.getUniqueId().toString() + ".bal");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        playerBalance = Double.valueOf(decimalFormat.format(playerBalance));

        return playerBalance;

    }
}
