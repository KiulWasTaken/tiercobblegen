package org.patriciachips.tiercobblegen;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class CobbleGens {

    public static HashMap<Material, Double> gen1 = new HashMap<>();
    static {
        gen1.put(Material.GRAVEL, 1.0);
        gen1.put(Material.GRANITE, 1.0);
        gen1.put(Material.DIORITE, 1.0);
        gen1.put(Material.ANDESITE, 1.0);
        gen1.put(Material.COAL_ORE, 5.0);
        gen1.put(Material.IRON_ORE, 4.0);
        gen1.put(Material.GOLD_ORE, 3.0);
        gen1.put(Material.LAPIS_ORE, 2.0);
        gen1.put(Material.REDSTONE_ORE, 2.0);

    }

}
