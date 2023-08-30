package org.patriciachips.tiercobblegen.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.InnerConfig;
import org.patriciachips.tiercobblegen.Methods.ColoredText;
import org.patriciachips.tiercobblegen.zEnums.CobbleGUIItems;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class Baltop implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player p) {
            if (args.length <= 1) {

                ConfigurationSection cf = PlayerDataConfig.get().getConfigurationSection("");

                HashMap<String, Double> unsortedBalance = new HashMap<>();
                for (String keys : cf.getKeys(false)) {
                    unsortedBalance.put(keys, PlayerDataConfig.get().getDouble(keys + ".bal"));
                }

                LinkedHashMap<String, Double> sortedBalance = new LinkedHashMap<>();
                unsortedBalance.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .forEachOrdered(x -> sortedBalance.put(x.getKey(), x.getValue()));

                List<String> keys = new ArrayList<>(sortedBalance.keySet());

                int playersPerPage = 5;
                int page = 1;
                if (args.length == 1) {
                    try {
                        page = Integer.parseInt(args[0]);
                    } catch (NumberFormatException ea) {
                    }
                }

                int i = (page - 1) * playersPerPage;

                try {
                    String keya = keys.get(i);
                    if (page > 0 && sortedBalance.size() > 0 && sortedBalance.size() <= (sortedBalance.size() - 1 / playersPerPage) * playersPerPage) {
                        p.sendMessage(ColoredText.t("&#39f782Balance leaderboard &6- &#578063page &c" + page + "&#578063 of &c" + (sortedBalance.size() / playersPerPage + 1)));
                        for (i = (page - 1) * playersPerPage; i >= page - 1 * 5 && i <= page * 5; i++) {
                            String key = keys.get(i);
                            p.sendMessage(ColoredText.t("&#baad49#" + (i + 1) + "&6. &#8d959e" + Bukkit.getOfflinePlayer(UUID.fromString(key)).getName() + " &8» &#7bd488" + sortedBalance.get(key) + "$"));
                            if (i == page * playersPerPage - 1 || i == sortedBalance.size() - 1) {
                                break;
                            }
                        }
                    } else {
                        p.sendMessage(InnerConfig.genericCommandFailure);
                    }
                } catch (IndexOutOfBoundsException exa) {
                    p.sendMessage(InnerConfig.genericCommandFailure);
                }
            }
        }
        return false;
    }
}
