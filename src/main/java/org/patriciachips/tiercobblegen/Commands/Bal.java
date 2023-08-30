package org.patriciachips.tiercobblegen.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.InnerConfig;

import java.text.DecimalFormat;
import java.util.UUID;

public class Bal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player p) {

            OfflinePlayer offlinePlayer = null;

            if (args.length == 1) {
                offlinePlayer = Bukkit.getOfflinePlayer(args[0]);
                if (Eco.hasJoinedBefore(offlinePlayer) == true) {
                    offlinePlayer = offlinePlayer;
                } else {
                    p.sendMessage(InnerConfig.genericCommandFailure);
                    offlinePlayer = null;
                    p = null;
                }
            }

            if (p != null) {
                Double playerBalance = getPlayerBalance(p.getUniqueId());
                if (offlinePlayer != null) {
                    playerBalance = getPlayerBalance(offlinePlayer.getUniqueId());
                }

                p.sendMessage(InnerConfig.currentBalance + playerBalance + "$");
            }

        }

        return false;
    }

    public static Double getPlayerBalance(UUID p) {

        Double playerBalance = PlayerDataConfig.get().getDouble(p.toString() + ".bal");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        playerBalance = Double.valueOf(decimalFormat.format(playerBalance));

        return playerBalance;

    }
}
