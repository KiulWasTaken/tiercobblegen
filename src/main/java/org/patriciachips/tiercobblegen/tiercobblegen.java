package org.patriciachips.tiercobblegen;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import org.patriciachips.tiercobblegen.Commands.Bal;
import org.patriciachips.tiercobblegen.Commands.Gen;
import org.patriciachips.tiercobblegen.Commands.Shop;
import org.patriciachips.tiercobblegen.CustomConfigs.PlayerDataConfig;
import org.patriciachips.tiercobblegen.Events.InventoryClick;
import org.patriciachips.tiercobblegen.Events.BlockForm;
import org.patriciachips.tiercobblegen.Events.Join;

import java.lang.reflect.Field;

public final class tiercobblegen extends JavaPlugin {

    @Override
    public void onEnable() {

        /** Commands */
        getCommand("shop").setExecutor(new Shop());
        getCommand("bal").setExecutor(new Bal());
        getCommand("gen").setExecutor(new Gen());

        /** Events */
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new BlockForm(), this);
        getServer().getPluginManager().registerEvents(new Join(), this);

        /** Logic */

        PlayerDataConfig.setup();
        PlayerDataConfig.get().options().copyDefaults(true);
        PlayerDataConfig.save();

        registerGlow();

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
