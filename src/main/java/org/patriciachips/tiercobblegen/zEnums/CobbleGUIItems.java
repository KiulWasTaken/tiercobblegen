package org.patriciachips.tiercobblegen.zEnums;

import org.bukkit.Material;

import java.util.HashMap;

public enum CobbleGUIItems {
    /** Normal */
    gen0("&#584e2c&lD&#625731&li&#6c6036&lr&#77693c&lt &#817241&lG&#8b7b46&le&#95844b&ln&#8b7b46&le&#817241&lr&#77693c&la&#6c6036&lt&#625731&lo&#584e2c&lr", Material.DIRT, new String[]{""}, 0, false),
    waterbucket(" ", Material.WATER_BUCKET, new String[]{""}, null, null),
    gen1("", Material.COBBLESTONE, new String[]{""}, 1, false),
    gen2("", Material.COAL_ORE, new String[]{""}, 2, false),
    gen3("", Material.IRON_ORE, new String[]{""}, 3, false),
    gen4("", Material.GOLD_ORE, new String[]{""}, 4, false),
    gen5("", Material.DIAMOND_ORE, new String[]{""}, 5, false),
    lavabucket( " ", Material.LAVA_BUCKET, new String[]{""}, null, null),
    /** Nether */
    lavabucket1(" ", Material.LAVA_BUCKET, new String[]{""}, null, null),
    nethergen1("", Material.NETHERRACK, new String[]{""}, 1, true),
    nethergen2("", Material.BASALT, new String[]{""}, 2, true),
    nethergen3("", Material.ANCIENT_DEBRIS, new String[]{""}, 3, true),
    blueice(" ", Material.BLUE_ICE, new String[]{""}, null, null);

    private String displayName;
    private Material material;
    private String[] lore;
    private Integer genLevel;
    private Boolean isNether;

    CobbleGUIItems(String displayName, Material material, String[] lore, Integer genLevel, Boolean isNether) {
        this.displayName = displayName;
        this.material = material;
        this.lore = lore;
        this.genLevel = genLevel;
        this.isNether = isNether;
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

    public static String convertHashmapToStringList(HashMap<Material, Double> generatorMap) {

        https://www.digitalocean.com/community/tutorials/sort-hashmap-by-value-java

    }

}
