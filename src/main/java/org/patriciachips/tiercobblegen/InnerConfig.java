package org.patriciachips.tiercobblegen;

import org.bukkit.plugin.Plugin;
import org.patriciachips.tiercobblegen.Methods.ColoredText;

public class InnerConfig {

    public static Plugin plugin = tiercobblegen.getPlugin(tiercobblegen.class);

    public static String shopInventoryNameString = ColoredText.t("&#1ca22a&lT&#1fb22e&li&#21c132&le&#24d136&lr&#27e03a&lb&#29f03e&ll&#2cff42&lo&#29f03e&lc&#27e03a&lk &#24d136&lS&#21c132&lh&#1fb22e&lo&#1ca22a&lp");

    public static String buyPriceString = ColoredText.t("&#57a26c&lC&#61b578&ll&#6bc784&li&#74da91&lc&#7eec9d&lk &#88ffa9&lt&#7eec9d&lo &#74da91&lb&#6bc784&lu&#61b578&ly&#57a26c&l: ");

    public static String sellPriceString = ColoredText.t("&#be3c3c&lC&#ca4040&ll&#d64444&li&#e14747&lc&#ed4b4b&lk &#f94f4f&lt&#f94f4f&lo &#ed4b4b&ls&#e14747&le&#d64444&ll&#ca4040&ll&#be3c3c&l: ");

}
