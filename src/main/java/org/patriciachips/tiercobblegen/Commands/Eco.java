package org.patriciachips.tiercobblegen.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Methods.ColoredText;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Eco implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player p) {

            if (args.length == 3) {
                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[1]);
                if (hasJoinedBefore(offlinePlayer) == true) {
                    try {
                        Double value = Double.parseDouble(args[2]);
                        switch (args[0]) {
                            case "add":
                                changeBalance(p, offlinePlayer.getUniqueId(), "add", value);
                                break;
                            case "remove":
                                changeBalance(p, offlinePlayer.getUniqueId(), "remove", value);
                                break;
                            case "set":
                                changeBalance(p, offlinePlayer.getUniqueId(), "set", value);
                                break;
                            default:
                                p.sendMessage(InnerConfig.genericCommandFailure);
                        }
                    } catch (NumberFormatException exception) {
                        p.sendMessage(InnerConfig.genericCommandFailure);
                    }
                } else {
                    p.sendMessage(InnerConfig.playerOffline);
                }
            } else {
                p.sendMessage(InnerConfig.genericCommandFailure);
            }

        }

        return false;
    }

    public static void changeBalance(Player op, UUID p, String changeType, Double value) {

        switch (changeType) {
            case "add":
                PlayerDataConfig.get().set(p + ".bal", PlayerDataConfig.get().getDouble(p + ".bal") + value);
                break;
            case "remove":
                PlayerDataConfig.get().set(p + ".bal", PlayerDataConfig.get().getDouble(p + ".bal") - value);
                break;
            case "set":
                PlayerDataConfig.get().set(p + ".bal", value);
                break;
        }

        PlayerDataConfig.save();

        Player affectedPlayer = Bukkit.getOfflinePlayer(p).getPlayer();

        if (affectedPlayer != null) {
            affectedPlayer.sendMessage(ColoredText.t(InnerConfig.affectedPlayerBalanceUpdated + "&7[&#8bd169" + PlayerDataConfig.get().getDouble(p + ".bal") + "$&7]"));
        }

        if (affectedPlayer != op) {
            if (op != null) {
                op.sendMessage(ColoredText.t(InnerConfig.operaterEcoCommandUsed + Bukkit.getOfflinePlayer(p).getName() + " &7[&#8bd169" + PlayerDataConfig.get().getDouble(p + ".bal") + "$&7]"));
            }
        }

    }

    public static Boolean hasJoinedBefore(OfflinePlayer offlinePlayer) {

        for (OfflinePlayer offlinePlayers : Bukkit.getOfflinePlayers()) {
            if (offlinePlayer == offlinePlayers) {
                return true;
            }
        }
        if (Bukkit.getOnlinePlayers().contains(offlinePlayer.getPlayer())) {
            return true;
        }
        return false;

    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {

        List<String> arguments = new ArrayList<>();

        if (args.length == 1) {
            arguments.add("add");
            arguments.add("remove");
            arguments.add("set");

            return arguments;
        } else if (args.length > 2) {
            return arguments;
        }

        return null;
    }

}
