package org.patriciachips.tiercobblegen;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class CobbleGens {

    /** DONT DO ANY LESS THEN 0.1 (EACH) OR OVER 100.0 (TOTAL) */
    /** the part of the 100.0 total not filled with a material will be the generators default material */

    public static LinkedHashMap<Material, Double> gen0 = new LinkedHashMap<>(); //DIRT GEN
    static {
        gen0.put(Material.GRASS_BLOCK, 5.0);
        gen0.put(Material.RED_SAND, 4.0);
        gen0.put(Material.MYCELIUM, 1.0);
        gen0.put(Material.CLAY, 5.0);
        gen0.put(Material.DIRT, 40.0);
        gen0.put(Material.GRAVEL, 15.0);
        gen0.put(Material.SAND, 30.0);
    }
    public static LinkedHashMap<Material, Double> gen1 = new LinkedHashMap<>();
    static {
        gen1.put(Material.DIORITE, 1.0);
        gen1.put(Material.GRANITE, 1.0);
        gen1.put(Material.ANDESITE, 1.0);
        gen1.put(Material.DEEPSLATE, 1.0);
        gen1.put(Material.COPPER_ORE, 1.0);
    }
    public static LinkedHashMap<Material, Double> gen2 = new LinkedHashMap<>();
    static {
        gen2.put(Material.DIORITE, 1.0);
        gen2.put(Material.GRANITE, 1.0);
        gen2.put(Material.ANDESITE, 1.0);
        gen2.put(Material.DEEPSLATE, 1.0);
        gen2.put(Material.COPPER_ORE, 1.0);
        gen2.put(Material.COAL_ORE, 10.0);
    }
    public static LinkedHashMap<Material, Double> gen3 = new LinkedHashMap<>();
    static {
        gen3.put(Material.DIORITE, 1.0);
        gen3.put(Material.GRANITE, 1.0);
        gen3.put(Material.ANDESITE, 1.0);
        gen3.put(Material.DEEPSLATE, 1.0);
        gen3.put(Material.COPPER_ORE, 1.0);
        gen3.put(Material.COAL_ORE, 8.0);
        gen3.put(Material.IRON_ORE, 4.0);
    }
    public static LinkedHashMap<Material, Double> gen4 = new LinkedHashMap<>();
    static {
        gen4.put(Material.DIORITE, 1.0);
        gen4.put(Material.GRANITE, 1.0);
        gen4.put(Material.ANDESITE, 1.0);
        gen4.put(Material.DEEPSLATE, 1.0);
        gen2.put(Material.COPPER_ORE, 2.0);
        gen4.put(Material.COAL_ORE, 7.0);
        gen4.put(Material.IRON_ORE, 4.0);
        gen4.put(Material.GOLD_ORE, 3.0);
    }
    public static LinkedHashMap<Material, Double> gen5 = new LinkedHashMap<>();
    static {
        gen5.put(Material.DIORITE, 1.0);
        gen5.put(Material.GRANITE, 1.0);
        gen5.put(Material.ANDESITE, 1.0);
        gen5.put(Material.DEEPSLATE, 1.0);
        gen2.put(Material.COPPER_ORE, 3.0);
        gen5.put(Material.COAL_ORE, 5.0);
        gen5.put(Material.IRON_ORE, 4.0);
        gen5.put(Material.GOLD_ORE, 3.0);
        gen5.put(Material.LAPIS_ORE, 4.0);
    }

    public static LinkedHashMap<Material, Double> gen6 = new LinkedHashMap<>();
    static {
        gen6.put(Material.DIORITE, 1.0);
        gen6.put(Material.GRANITE, 1.0);
        gen6.put(Material.ANDESITE, 1.0);
        gen6.put(Material.DEEPSLATE, 1.0);
        gen2.put(Material.COPPER_ORE, 3.0);
        gen6.put(Material.COAL_ORE, 5.0);
        gen6.put(Material.IRON_ORE, 4.0);
        gen6.put(Material.GOLD_ORE, 4.0);
        gen6.put(Material.LAPIS_ORE, 4.0);
        gen6.put(Material.DIAMOND_ORE, 3.0);
    }

    public static LinkedHashMap<Material, Double> gen7 = new LinkedHashMap<>();
    static {
        gen7.put(Material.DIORITE, 1.0);
        gen7.put(Material.GRANITE, 1.0);
        gen7.put(Material.ANDESITE, 1.0);
        gen7.put(Material.DEEPSLATE, 1.0);
        gen2.put(Material.COPPER_ORE, 4.0);
        gen7.put(Material.COAL_ORE, 5.0);
        gen7.put(Material.IRON_ORE, 5.0);
        gen7.put(Material.GOLD_ORE, 5.0);
        gen7.put(Material.LAPIS_ORE, 5.0);
        gen7.put(Material.DIAMOND_ORE, 3.0);
        gen7.put(Material.EMERALD_ORE, 3.0);
    }

    public static LinkedHashMap<Material, Double> gen8 = new LinkedHashMap<>();
    static {
        gen8.put(Material.DIORITE, 1.0);
        gen8.put(Material.GRANITE, 1.0);
        gen8.put(Material.ANDESITE, 1.0);
        gen8.put(Material.DEEPSLATE, 1.0);
        gen2.put(Material.COPPER_ORE, 4.0);
        gen8.put(Material.COAL_ORE, 5.0);
        gen8.put(Material.IRON_ORE, 5.0);
        gen8.put(Material.GOLD_ORE, 5.0);
        gen8.put(Material.LAPIS_ORE, 4.0);
        gen8.put(Material.DIAMOND_ORE, 3.0);
        gen8.put(Material.EMERALD_ORE, 3.0);
        gen8.put(Material.OBSIDIAN, 1.0);
    }

    /** NETHER */
    public static LinkedHashMap<Material, Double> nethergen1 = new LinkedHashMap<>();
    static {
        nethergen1.put(Material.NETHERRACK,10.0);
        nethergen1.put(Material.QUARTZ, 2.0);
        nethergen1.put(Material.NETHER_GOLD_ORE,5.0);
        nethergen1.put(Material.MAGMA_BLOCK,5.0);
    }
    public static LinkedHashMap<Material, Double> nethergen2 = new LinkedHashMap<>();
    static {
        nethergen2.put(Material.NETHERRACK,10.0);
        nethergen2.put(Material.QUARTZ, 3.0);
        nethergen2.put(Material.NETHER_GOLD_ORE,5.0);
        nethergen2.put(Material.MAGMA_BLOCK,5.0);
        nethergen2.put(Material.BLACKSTONE,5.0);
        nethergen2.put(Material.GILDED_BLACKSTONE,3.0);
        nethergen2.put(Material.GOLD_BLOCK,2.0);
    }
    public static LinkedHashMap<Material, Double> nethergen3 = new LinkedHashMap<>();
    static {
        nethergen3.put(Material.NETHERRACK,8.0);
        nethergen3.put(Material.QUARTZ, 4.0);
        nethergen3.put(Material.NETHER_GOLD_ORE,5.0);
        nethergen3.put(Material.MAGMA_BLOCK,5.0);
        nethergen3.put(Material.BLACKSTONE,5.0);
        nethergen3.put(Material.GILDED_BLACKSTONE,3.0);
        nethergen3.put(Material.GOLD_BLOCK,2.0);
        nethergen3.put(Material.SOUL_SAND,3.0);
        nethergen3.put(Material.SOUL_SOIL,2.0);
    }

    public static LinkedHashMap<Material, Double> nethergen4 = new LinkedHashMap<>();
    static {
        nethergen4.put(Material.NETHERRACK,8.0);
        nethergen4.put(Material.QUARTZ, 5.0);
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
