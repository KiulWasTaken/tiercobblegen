package org.patriciachips.tiercobblegen.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Methods.ColoredText;

import java.text.DecimalFormat;
import java.util.UUID;

public class Pay implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player p) {

            Player player = null;
            Double payAmount = null;

            if (args.length == 2) {
                try {
                    player = Bukkit.getOfflinePlayer(args[0]).getPlayer();
                    payAmount = Double.parseDouble(args[1]);
                    if (player != null && payAmount > 0) {
                    } else {
                        p.sendMessage(InnerConfig.genericCommandFailure);
                        player = null;
                        return false;
                    }
                } catch (NumberFormatException a) {
                    p.sendMessage(InnerConfig.genericCommandFailure);
                    return false;
                }
            }

            if (payAmount <= getPlayerBalance(p.getUniqueId())) {
                PlayerDataConfig.get().set(p.getUniqueId() + ".bal", PlayerDataConfig.get().getDouble(p.getUniqueId() + ".bal") - payAmount);
                PlayerDataConfig.get().set(player.getUniqueId() + ".bal", PlayerDataConfig.get().getDouble(player.getUniqueId() + ".bal") + payAmount);

                PlayerDataConfig.save();

                p.sendMessage(ColoredText.t(InnerConfig.payPlayer + player.getName() + " &7[&c-" + payAmount + "&7]"));
                player.sendMessage(ColoredText.t(InnerConfig.payedByPlayer + p.getName() + " &7[&a+" + payAmount + "&7]"));
            } else {
                p.sendMessage(ColoredText.t(InnerConfig.needMoreBalance));
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
