package org.patriciachips.tiercobblegen;

import org.bukkit.plugin.Plugin;
import org.patriciachips.tiercobblegen.Methods.ColoredText;

public class InnerConfig {

    public static Plugin plugin = tiercobblegen.getPlugin(tiercobblegen.class);

    public static String shopInventoryNameString = ColoredText.t("&#1ca22a&lT&#1fb22e&li&#21c132&le&#24d136&lr&#27e03a&lb&#29f03e&ll&#2cff42&lo&#29f03e&lc&#27e03a&lk &#24d136&lS&#21c132&lh&#1fb22e&lo&#1ca22a&lp");

    public static String cobbleGenInventoryNameString = ColoredText.t("&#8e7575&lS&#878387&le&#80929a&ll&#78a0ac&le&#71afbf&lc&#6abdd1&lt &#63cbe3&la &#5cdaf6&lg&#5cdaf6&le&#63cbe3&ln&#6abdd1&le&#71afbf&lr&#78a0ac&la&#80929a&lt&#878387&lo&#8e7575&lr");

    public static String buyInventoryNameString = ColoredText.t(shopInventoryNameString + " &7[&#4f8e51&oB&#569a58&ou&#5ca65f&oy&#63b266&oi&#6abe6d&on&#71ca74&og &#71ca74&oi&#6abe6d&ot&#63b266&oe&#5ca65f&om&#569a58&o.&#4f8e51&o.&7]");

    public static String backItemName = ColoredText.t("&#a20000&lT&#b70606&lA&#cb0d0d&lK&#e01313&lE &#f51a1a&lM&#f51a1a&lE &#e01313&lB&#cb0d0d&lA&#b70606&lC&#a20000&lK");

    public static String balanceItemName = ColoredText.t("&#87bd75" + "Current balance &8» &7");

    public static String purchasedItemsString = ColoredText.t("&7[&#f07e75»&7] &#36d660Purchase Successful! &7");

    public static String purchaseAdjustedString = ColoredText.t("&7[&4lack of space!&7]");

    public static String notEnoughSpaceBuyString = ColoredText.t("&7[&#f07e75»&7] &cYou dont have enough inventory space!");

    public static String buyPriceString = ColoredText.t("&#52b963&lL&#59c36c&le&#61cd74&lf&#68d77d&lt&#70e186&l-&#77eb8f&lc&#7ff597&ll&#86ffa0&li&#7ff597&lc&#77eb8f&lk &#70e186&lt&#68d77d&lo &#61cd74&lb&#59c36c&lu&#52b963&ly &8» ");

    public static String sellPriceString = ColoredText.t("&#b43131&lR&#b83538&li&#bd393e&lg&#c13d45&lh&#c5414c&lt&#ca4552&l-&#ce4959&lc&#d24d5f&ll&#d75166&li&#db556d&lc&#db556d&lk &#d75166&lt&#d24d5f&lo &#ce4959&ls&#ca4552&le&#c5414c&ll&#c13d45&ll &#bd393e&la&#b83538&ll&#b43131&ll &8» ");

    public static String currentBalance = ColoredText.t("&7[&#f07e75»&7] &#87bd75" + "Current balance &8» &7");

    public static String soldAllItem = ColoredText.t("&7[&#f07e75»&7] &#b33737" + "Items sold &8» &7");

    public static String cantSellItem = ColoredText.t("&7[&#f07e75»&7] &#c42525" + "You have no items to sell!");

    public static String cantBuyItem = ColoredText.t("&7[&#f07e75»&7] &#c42525" + "You cannot purchase this item!");

    public static String insufficientFunds = ColoredText.t("&7[&#f07e75»&7] &#c42525" + "You cannot afford this many items!");

}
