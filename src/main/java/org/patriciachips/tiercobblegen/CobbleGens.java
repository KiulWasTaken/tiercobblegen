package org.patriciachips.tiercobblegen;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class CobbleGens {

    public static HashMap<Material, Double> gen0 = new HashMap<>(); //DIRT GEN
    static {

    }
    public static HashMap<Material, Double> gen1 = new HashMap<>();
    static {
        gen1.put(Material.DIRT, 1.0);
        gen1.put(Material.STONE, 5.0);
        gen1.put(Material.DIAMOND_BLOCK, 15.0);
        gen1.put(Material.DRAGON_EGG, 92.0);
        gen1.put(Material.GLASS, 3.0);
    }
    public static HashMap<Material, Double> gen2 = new HashMap<>();
    static {

    }
    public static HashMap<Material, Double> gen3 = new HashMap<>();
    static {

    }
    public static HashMap<Material, Double> gen4 = new HashMap<>();
    static {

    }
    public static HashMap<Material, Double> gen5 = new HashMap<>();
    static {

    }

    /** NETHER */
    public static HashMap<Material, Double> nethergen1 = new HashMap<>();
    static {

    }
    public static HashMap<Material, Double> nethergen2 = new HashMap<>();
    static {

    }
    public static HashMap<Material, Double> nethergen3 = new HashMap<>();
    static {

    }

}
