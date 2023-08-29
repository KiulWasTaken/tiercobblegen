package org.patriciachips.tiercobblegen.zEnums;

import org.bukkit.Material;
import org.patriciachips.tiercobblegen.CobbleGens;
import org.patriciachips.tiercobblegen.InnerConfig;

import java.security.Key;
import java.util.*;

public enum CobbleGUIItems {
    /** Normal */
    gen0("&#584e2c&lD&#625731&li&#6c6036&lr&#77693c&lt &#817241&lG&#8b7b46&le&#95844b&ln&#8b7b46&le&#817241&lr&#77693c&la&#6c6036&lt&#625731&lo&#584e2c&lr", Material.DIRT, new String[]{""}, 0, false, CobbleGens.gen0),
    waterbucket(" ", Material.WATER_BUCKET, new String[]{""}, null, null, null),
    gen1(InnerConfig.generatorTier + "1", Material.COBBLESTONE, new String[]{""}, 1, false, CobbleGens.gen1),
    gen2(InnerConfig.generatorTier + "2", Material.COAL_ORE, new String[]{""}, 2, false, CobbleGens.gen2),
    gen3(InnerConfig.generatorTier + "3", Material.IRON_ORE, new String[]{""}, 3, false, CobbleGens.gen3),
    gen4(InnerConfig.generatorTier + "4", Material.GOLD_ORE, new String[]{""}, 4, false, CobbleGens.gen4),
    gen5(InnerConfig.generatorTier + "5", Material.LAPIS_ORE, new String[]{""}, 5, false, CobbleGens.gen5),
    lavabucket( " ", Material.LAVA_BUCKET, new String[]{""}, null, null, null),
    gen6(InnerConfig.generatorTier + "6", Material.DIAMOND_ORE, new String[]{""}, 6, false, CobbleGens.gen6),
    gen7(InnerConfig.generatorTier + "7", Material.EMERALD_ORE, new String[]{""}, 7, false, CobbleGens.gen7),
    gen8(InnerConfig.generatorTier + "8", Material.OBSIDIAN, new String[]{""}, 8, false, CobbleGens.gen8),
    /** Nether */
    lavabucket1(" ", Material.LAVA_BUCKET, new String[]{""}, null, null, null),
    nethergen1(InnerConfig.netherGeneratorTier + "1", Material.BASALT, new String[]{""}, 1, true, CobbleGens.nethergen1),
    nethergen2(InnerConfig.netherGeneratorTier + "2", Material.NETHER_GOLD_ORE, new String[]{""}, 2, true, CobbleGens.nethergen2),
    nethergen3(InnerConfig.netherGeneratorTier + "3", Material.GOLD_BLOCK, new String[]{""}, 3, true, CobbleGens.nethergen3),
    nethergen4(InnerConfig.netherGeneratorTier + "4", Material.ANCIENT_DEBRIS, new String[]{""}, 4, true, CobbleGens.nethergen4),
    blueice(" ", Material.BLUE_ICE, new String[]{""}, null, null, null);

    private String displayName;
    private Material material;
    private String[] lore;
    private Integer genLevel;
    private Boolean isNether;
    private LinkedHashMap<Material, Double> gen;

    CobbleGUIItems(String displayName, Material material, String[] lore, Integer genLevel, Boolean isNether, LinkedHashMap<Material, Double> gen) {
        this.displayName = displayName;
        this.material = material;
        this.lore = lore;
        this.genLevel = genLevel;
        this.isNether = isNether;
        this.gen = gen;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Material getMaterial() {
        return material;
    }

    public String[] getlore() {
        return lore;
    }

    public Integer getGenLevel() {
        return genLevel;
    }

    public Boolean isNether() {
        return isNether;
    }

    public LinkedHashMap<Material, Double> getGenerator() {
        return gen;
    }

    public static List<String> convertHashmapToStringList(HashMap<Material, Double> generatorMap) {

        List<String> lore = new ArrayList<>();

        Set<Material> set = generatorMap.keySet();
        int i = 0;
        for (Material material : set) {
            String colorHex = "";
            colorHex = "&#698091"; //light

            lore.add(colorHex + material + "&8 » &6" + generatorMap.get(material) + "%");
            i++;
        }

        return lore;
    }

}
