package org.patriciachips.tiercobblegen;

import org.bukkit.Material;

public enum ShopItems {
    catagory_farming("&#5eabbc&lF&#69bfd2&la&#75d4e9&lr&#80e8ff&lm&#75d4e9&li&#69bfd2&ln&#5eabbc&lg", Material.HAY_BLOCK, new String[]{""}, 0.0, 0.0, "main"),
    catagory_foraging("&#5eabbc&lF&#68bccf&lo&#71cee2&lr&#7bdff5&la&#7bdff5&lg&#71cee2&li&#68bccf&ln&#5eabbc&lg", Material.OAK_LOG, new String[]{""}, 0.0, 0.0, "main"),
    catagory_mining("&#5eabbc&lM&#6cc3d7&li&#79dcf2&ln&#79dcf2&li&#6cc3d7&ln&#5eabbc&lg", Material.DIAMOND, new String[]{""}, 0.0, 0.0, "main"),
    catagory_mobdrops("&#5eabbc&lM&#68bccf&lo&#71cee2&lb &#7bdff5&lD&#7bdff5&lr&#71cee2&lo&#68bccf&lp&#5eabbc&ls", Material.ROTTEN_FLESH, new String[]{""}, 0.0, 0.0, "main"),
    catagory_fishing("&#5eabbc&lF&#69bfd2&li&#75d4e9&ls&#80e8ff&lh&#75d4e9&li&#69bfd2&ln&#5eabbc&lg", Material.COD, new String[]{""}, 0.0, 0.0, "main"),
    catagory_redstone("&#5eabbc&lR&#68bccf&le&#71cee2&ld&#7bdff5&ls&#7bdff5&lt&#71cee2&lo&#68bccf&ln&#5eabbc&le", Material.REDSTONE, new String[]{""}, 0.0, 0.0, "main"),
    /** Farming */
    farming_wheat("", Material.WHEAT, new String[]{""}, 0.0, 0.0, "farming"),
    farming_beetroot("", Material.BEETROOT, new String[]{""}, 0.0, 0.0, "farming"),
    farming_carrot("", Material.CARROT, new String[]{""}, 0.0, 0.0, "farming"),
    farming_potato("", Material.POTATO, new String[]{""}, 0.0, 0.0, "farming"),
    farming_sugarcane("", Material.SUGAR_CANE, new String[]{""}, 0.0, 0.0, "farming"),
    farming_melon("", Material.MELON, new String[]{""}, 0.0, 0.0, "farming"),
    farming_pumpkin("", Material.PUMPKIN, new String[]{""}, 0.0, 0.0, "farming"),
    farming_netherwart("", Material.NETHER_WART, new String[]{""}, 0.0, 0.0, "farming"),
    farming_chorusfruit("", Material.CHORUS_FRUIT, new String[]{""}, 0.0, 0.0, "farming"),
    /** Foraging */
    foraging_oaklog("", Material.OAK_LOG, new String[]{""}, 0.0, 0.0, "foraging"),
    foraging_birchlog("", Material.BIRCH_LOG, new String[]{""}, 0.0, 0.0, "foraging"),
    foraging_acacialog("", Material.ACACIA_LOG, new String[]{""}, 0.0, 0.0, "foraging"),
    foraging_darkoaklog("", Material.DARK_OAK_LOG, new String[]{""}, 0.0, 0.0, "foraging"),
    foraging_sprucelog("", Material.SPRUCE_LOG, new String[]{""}, 0.0, 0.0, "foraging"),
    foraging_junglelog("", Material.JUNGLE_LOG, new String[]{""}, 0.0, 0.0, "foraging"),
    foraging_crimsonlog("", Material.CRIMSON_HYPHAE, new String[]{""}, 0.0, 0.0, "foraging"),
    foraging_warpedlog("", Material.WARPED_HYPHAE, new String[]{""}, 0.0, 0.0, "foraging"),
    /** Mining */
    mining_coal("", Material.COAL, new String[]{""}, 0.0, 0.0, "mining"),
    mining_iron("", Material.IRON_INGOT, new String[]{""}, 0.0, 0.0, "mining"),
    mining_gold("", Material.GOLD_INGOT, new String[]{""}, 0.0, 0.0, "mining"),
    mining_lapis("", Material.LAPIS_LAZULI, new String[]{""}, 0.0, 0.0, "mining"),
    mining_diamonds("", Material.DIAMOND, new String[]{""}, 0.0, 0.0, "mining"),
    mining_emerald("", Material.EMERALD, new String[]{""}, 0.0, 0.0, "mining"),
    mining_obsidian("", Material.OBSIDIAN, new String[]{""}, 0.0, 0.0, "mining"),
    mining_ancientdebris("", Material.ANCIENT_DEBRIS, new String[]{""}, 0.0, 0.0, "mining"),
    /** Mob Drops */
    mobdrops_rottenflesh("", Material.ROTTEN_FLESH, new String[]{""}, 0.0, 0.0, "mobdrops"),
    mobdrops_gunpowder("", Material.GUNPOWDER, new String[]{""}, 0.0, 0.0, "mobdrops"),
    mobdrops_string("", Material.STRING, new String[]{""}, 0.0, 0.0, "mobdrops"),
    mobdrops_spidereye("", Material.SPIDER_EYE, new String[]{""}, 0.0, 0.0, "mobdrops"),
    mobdrops_bone("", Material.BONE, new String[]{""}, 0.0, 0.0, "mobdrops"),
    mobdrops_enderpearl("", Material.ENDER_PEARL, new String[]{""}, 0.0, 0.0, "mobdrops"),
    mobdrops_blazerod("", Material.BLAZE_ROD, new String[]{""}, 0.0, 0.0, "mobdrops"),
    mobdrops_shulkershell("", Material.SHULKER_SHELL, new String[]{""}, 0.0, 0.0, "mobdrops"),
    /** Fishing */
    fishing_cod("", Material.COD, new String[]{""}, 0.0, 0.0, "fishing"),
    fishing_salmon("", Material.SALMON, new String[]{""}, 0.0, 0.0, "fishing"),
    fishing_tropicalfish("", Material.TROPICAL_FISH, new String[]{""}, 0.0, 0.0, "fishing"),
    fishing_pufferfish("", Material.PUFFERFISH, new String[]{""}, 0.0, 0.0, "fishing"),
    fishing_lilypad("", Material.LILY_PAD, new String[]{""}, 0.0, 0.0, "fishing");

    private String displayName;
    private Material material;
    private String[] lore;
    private Double buyPrice;
    private Double sellPrice;
    private String inventory;

    ShopItems(String displayName, Material material, String[] lore, Double buyPrice, Double sellPrice, String inventory) {
        this.displayName = displayName;
        this.material = material;
        this.lore = lore;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.inventory = inventory;
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

    public Double getBuyPrice() {
        return buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public String getItemInventory() {
        return inventory;
    }

}
