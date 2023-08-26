package org.patriciachips.tiercobblegen;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.Events.InventoryClick;
import org.patriciachips.tiercobblegen.Events.BlockForm;

import java.lang.reflect.Field;

public final class tiercobblegen extends JavaPlugin {

    @Override
    public void onEnable() {

        /** Commands */
        //getCommand("test").setExecutor(new test());

        /** Events */
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new BlockForm(), this);

        /** Logic */

        registerGlow();

        for (Player players : Bukkit.getOnlinePlayers()) {
            PlayerDataConfig.setup(players);
        }

    }

    @Override
    public void onDisable() {



    }

    public void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            GlintEnchantment glow = new GlintEnchantment(new NamespacedKey(this, "glow"));
            Enchantment.registerEnchantment(glow);
        }
        catch (IllegalArgumentException e){
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
