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
        gen1.put(Material.COBBLESTONE, 85.0);
        gen1.put(Material.STONE, 10.0);
        gen1.put(Material.DIORITE, 1.0);
        gen1.put(Material.GRANITE, 1.0);
        gen1.put(Material.ANDESITE, 1.0);
        gen1.put(Material.DEEPSLATE, 1.0);
    }
    public static HashMap<Material, Double> gen2 = new HashMap<>();
    static {
        gen2.put(Material.COBBLESTONE, 71.0);
        gen2.put(Material.STONE, 15.0);
        gen2.put(Material.DIORITE, 1.0);
        gen2.put(Material.GRANITE, 1.0);
        gen2.put(Material.ANDESITE, 1.0);
        gen2.put(Material.DEEPSLATE, 1.0);
        gen2.put(Material.COAL_ORE, 10.0);
    }
    public static HashMap<Material, Double> gen3 = new HashMap<>();
    static {
        gen3.put(Material.COBBLESTONE, 71.0);
        gen3.put(Material.STONE, 13.0);
        gen3.put(Material.DIORITE, 1.0);
        gen3.put(Material.GRANITE, 1.0);
        gen3.put(Material.ANDESITE, 1.0);
        gen3.put(Material.DEEPSLATE, 1.0);
        gen3.put(Material.COAL_ORE, 8.0);
        gen3.put(Material.IRON_ORE, 4.0);
    }
    public static HashMap<Material, Double> gen4 = new HashMap<>();
    static {
        gen4.put(Material.COBBLESTONE, 70.0);
        gen4.put(Material.STONE, 12.0);
        gen4.put(Material.DIORITE, 1.0);
        gen4.put(Material.GRANITE, 1.0);
        gen4.put(Material.ANDESITE, 1.0);
        gen4.put(Material.DEEPSLATE, 1.0);
        gen4.put(Material.COAL_ORE, 7.0);
        gen4.put(Material.IRON_ORE, 4.0);
        gen4.put(Material.GOLD_ORE, 3.0);
    }
    public static HashMap<Material, Double> gen5 = new HashMap<>();
    static {
        gen5.put(Material.COBBLESTONE, 68.0);
        gen5.put(Material.STONE, 12.0);
        gen5.put(Material.DIORITE, 1.0);
        gen5.put(Material.GRANITE, 1.0);
        gen5.put(Material.ANDESITE, 1.0);
        gen5.put(Material.DEEPSLATE, 1.0);
        gen5.put(Material.COAL_ORE, 5.0);
        gen5.put(Material.IRON_ORE, 4.0);
        gen5.put(Material.GOLD_ORE, 3.0);
        gen5.put(Material.LAPIS_ORE, 4.0);
    }

    public static HashMap<Material, Double> gen6 = new HashMap<>();
    static {
        gen6.put(Material.COBBLESTONE, 66.0);
        gen6.put(Material.STONE, 10.0);
        gen6.put(Material.DIORITE, 1.0);
        gen6.put(Material.GRANITE, 1.0);
        gen6.put(Material.ANDESITE, 1.0);
        gen6.put(Material.DEEPSLATE, 1.0);
        gen6.put(Material.COAL_ORE, 5.0);
        gen6.put(Material.IRON_ORE, 4.0);
        gen6.put(Material.GOLD_ORE, 4.0);
        gen6.put(Material.LAPIS_ORE, 4.0);
        gen6.put(Material.DIAMOND_ORE, 3.0);
    }

    public static HashMap<Material, Double> gen7 = new HashMap<>();
    static {
        gen7.put(Material.COBBLESTONE, 60.0);
        gen7.put(Material.STONE, 10.0);
        gen7.put(Material.DIORITE, 1.0);
        gen7.put(Material.GRANITE, 1.0);
        gen7.put(Material.ANDESITE, 1.0);
        gen7.put(Material.DEEPSLATE, 1.0);
        gen7.put(Material.COAL_ORE, 5.0);
        gen7.put(Material.IRON_ORE, 5.0);
        gen7.put(Material.GOLD_ORE, 5.0);
        gen7.put(Material.LAPIS_ORE, 5.0);
        gen7.put(Material.DIAMOND_ORE, 3.0);
        gen7.put(Material.EMERALD_ORE, 3.0);
    }

    public static HashMap<Material, Double> gen8 = new HashMap<>();
    static {
        gen8.put(Material.COBBLESTONE, 60.0);
        gen8.put(Material.STONE, 10.0);
        gen8.put(Material.DIORITE, 1.0);
        gen8.put(Material.GRANITE, 1.0);
        gen8.put(Material.ANDESITE, 1.0);
        gen8.put(Material.DEEPSLATE, 1.0);
        gen8.put(Material.COAL_ORE, 5.0);
        gen8.put(Material.IRON_ORE, 5.0);
        gen8.put(Material.GOLD_ORE, 5.0);
        gen8.put(Material.LAPIS_ORE, 4.0);
        gen8.put(Material.DIAMOND_ORE, 3.0);
        gen8.put(Material.EMERALD_ORE, 3.0);
        gen8.put(Material.OBSIDIAN, 1.0);
    }

    /** NETHER */
    public static HashMap<Material, Double> nethergen1 = new HashMap<>();
    static {
        nethergen1.put(Material.BASALT,80.0);
        nethergen1.put(Material.NETHERRACK,10.0);
        nethergen1.put(Material.NETHER_GOLD_ORE,5.0);
        nethergen1.put(Material.MAGMA_BLOCK,5.0);
    }
    public static HashMap<Material, Double> nethergen2 = new HashMap<>();
    static {
        nethergen2.put(Material.BASALT,70.0);
        nethergen2.put(Material.NETHERRACK,10.0);
        nethergen2.put(Material.NETHER_GOLD_ORE,5.0);
        nethergen2.put(Material.MAGMA_BLOCK,5.0);
        nethergen2.put(Material.BLACKSTONE,5.0);
        nethergen2.put(Material.GILDED_BLACKSTONE,3.0);
        nethergen2.put(Material.GOLD_BLOCK,2.0);
    }
    public static HashMap<Material, Double> nethergen3 = new HashMap<>();
    static {
        nethergen3.put(Material.BASALT,67.0);
        nethergen3.put(Material.NETHERRACK,8.0);
        nethergen3.put(Material.NETHER_GOLD_ORE,5.0);
        nethergen3.put(Material.MAGMA_BLOCK,5.0);
        nethergen3.put(Material.BLACKSTONE,5.0);
        nethergen3.put(Material.GILDED_BLACKSTONE,3.0);
        nethergen3.put(Material.GOLD_BLOCK,2.0);
        nethergen3.put(Material.SOUL_SAND,3.0);
        nethergen3.put(Material.SOUL_SOIL,2.0);
    }

    public static HashMap<Material, Double> nethergen4 = new HashMap<>();
    static {
        nethergen4.put(Material.BASALT,66.0);
        nethergen4.put(Material.NETHERRACK,8.0);
        nethergen4.put(Material.NETHER_GOLD_ORE,5.0);
        nethergen4.put(Material.MAGMA_BLOCK,5.0);
        nethergen4.put(Material.BLACKSTONE,5.0);
        nethergen4.put(Material.GILDED_BLACKSTONE,3.0);
        nethergen4.put(Material.GOLD_BLOCK,2.0);
        nethergen4.put(Material.SOUL_SAND,3.0);
        nethergen4.put(Material.SOUL_SOIL,2.0);
        nethergen4.put(Material.ANCIENT_DEBRIS,1.0);
    }

}
