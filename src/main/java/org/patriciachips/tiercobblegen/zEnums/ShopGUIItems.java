package org.patriciachips.tiercobblegen.zEnums;

import org.bukkit.Material;

public enum ShopGUIItems {
    catagory_farming("&#5eabbc&lF&#69bfd2&la&#75d4e9&lr&#80e8ff&lm&#75d4e9&li&#69bfd2&ln&#5eabbc&lg", Material.HAY_BLOCK, new String[]{""}, 0.0, 0.0, "main"),
    catagory_foraging("&#5eabbc&lF&#68bccf&lo&#71cee2&lr&#7bdff5&la&#7bdff5&lg&#71cee2&li&#68bccf&ln&#5eabbc&lg", Material.OAK_LOG, new String[]{""}, 0.0, 0.0, "main"),
    catagory_mining("&#5eabbc&lM&#6cc3d7&li&#79dcf2&ln&#79dcf2&li&#6cc3d7&ln&#5eabbc&lg", Material.DIAMOND, new String[]{""}, 0.0, 0.0, "main"),
    catagory_mobdrops("&#5eabbc&lM&#68bccf&lo&#71cee2&lb &#7bdff5&lD&#7bdff5&lr&#71cee2&lo&#68bccf&lp&#5eabbc&ls", Material.ROTTEN_FLESH, new String[]{""}, 0.0, 0.0, "main"),
    catagory_fishing("&#5eabbc&lF&#69bfd2&li&#75d4e9&ls&#80e8ff&lh&#75d4e9&li&#69bfd2&ln&#5eabbc&lg", Material.COD, new String[]{""}, 0.0, 0.0, "main"),
    catagory_redstone("&#5eabbc&lR&#68bccf&le&#71cee2&ld&#7bdff5&ls&#7bdff5&lt&#71cee2&lo&#68bccf&ln&#5eabbc&le", Material.REDSTONE, new String[]{""}, 0.0, 0.0, "main"),
    catagory_misc("&#5eabbc&lm&#63b4c6&li&#68bccf&ls&#6dc5d9&lc&#71cee2&le&#76d6ec&ll&#7bdff5&ll&#76d6ec&la&#71cee2&ln&#6dc5d9&le&#68bccf&lo&#63b4c6&lu&#5eabbc&ls", Material.NAME_TAG, new String[]{""}, 0.0, 0.0, "main"),
    /** Farming */
    farming_wheat(        "", Material.WHEAT,         new String[]{""}, 0.0,    0.055,  "farming"),
    farming_wheatseed(    "", Material.WHEAT_SEEDS,   new String[]{""}, 5.0,   0.0,   "farming"),
    farming_beetroot(     "", Material.BEETROOT,      new String[]{""}, 10.0,  0.06,  "farming"),
    farming_carrot(       "", Material.CARROT,        new String[]{""}, 10.0,  0.065,  "farming"),
    farming_potato(       "", Material.POTATO,        new String[]{""}, 15.0,  0.065,  "farming"),
    farming_sugarcane(    "", Material.SUGAR_CANE,    new String[]{""}, 50.0,  0.075,  "farming"),
    farming_melon(        "", Material.MELON,         new String[]{""}, 30.0,  0.1,  "farming"),
    farming_pumpkin(      "", Material.PUMPKIN,       new String[]{""}, 30.0,  0.1,  "farming"),
    farming_netherwart(   "", Material.NETHER_WART,   new String[]{""}, 200.0,  0.13,   "farming"),
    farming_chorusfruit(  "", Material.CHORUS_FRUIT,  new String[]{""}, 0.0,    0.135,   "farming"),
    farming_chorusflower( "", Material.CHORUS_FLOWER, new String[]{""}, 300.0, 0.0,   "farming"),
    farming_cactus(       "", Material.CACTUS,        new String[]{""}, 50.0,  0.03, "farming"),
    farming_sweetberry(   "", Material.SWEET_BERRIES, new String[]{""}, 50.0,   0.03,  "farming"),
    farming_glowberry(    "", Material.GLOW_BERRIES,  new String[]{""}, 30.0,   0.1,   "farming"),
    farming_kelp(         "", Material.KELP,          new String[]{""}, 50.0,  0.04,  "farming"),
    /** Foraging */
    foraging_oaklog(         "", Material.OAK_LOG,          new String[]{""}, 0.0, 0.09,  "foraging"),
    foraging_birchlog(       "", Material.BIRCH_LOG,        new String[]{""}, 0.0, 0.095,  "foraging"),
    foraging_acacialog(      "", Material.ACACIA_LOG,       new String[]{""}, 0.0, 0.1,  "foraging"),
    foraging_darkoaklog(     "", Material.DARK_OAK_LOG,     new String[]{""}, 0.0, 0.105, "foraging"),
    foraging_sprucelog(      "", Material.SPRUCE_LOG,       new String[]{""}, 0.0, 0.105, "foraging"),
    foraging_junglelog(      "", Material.JUNGLE_LOG,       new String[]{""}, 0.0, 0.11, "foraging"),
    foraging_crimsonlog(     "", Material.CRIMSON_STEM,     new String[]{""}, 0.0, 0.13,  "foraging"),
    foraging_warpedlog(      "", Material.WARPED_STEM,      new String[]{""}, 0.0, 0.13,  "foraging"),
    foraging_cherrylog(      "", Material.CHERRY_LOG,       new String[]{""}, 0.0, 0.095,  "foraging"),
    foraging_oaksapling(     "", Material.OAK_SAPLING,      new String[]{""}, 50.0, 0.0,  "foraging"),
    foraging_birchsapling(   "", Material.BIRCH_SAPLING,    new String[]{""}, 100.0, 0.0,  "foraging"),
    foraging_acaciasapling(  "", Material.ACACIA_SAPLING,   new String[]{""}, 200.0, 0.0,  "foraging"),
    foraging_darkoaksapling( "", Material.DARK_OAK_SAPLING, new String[]{""}, 100.0, 0.0,  "foraging"),
    foraging_sprucesapling(  "", Material.SPRUCE_SAPLING,   new String[]{""}, 500.0, 0.0,  "foraging"),
    foraging_junglesapling(  "", Material.JUNGLE_SAPLING,   new String[]{""}, 300.0, 0.0,  "foraging"),
    foraging_crimsonfungus(  "", Material.CRIMSON_FUNGUS,   new String[]{""}, 800.0, 0.0,  "foraging"),
    foraging_warpedfungus(   "", Material.WARPED_FUNGUS,    new String[]{""}, 1000.0, 0.0,  "foraging"),
    foraging_cherrysapling(  "", Material.CHERRY_SAPLING,   new String[]{""}, 100.0, 0.0,  "foraging"),
    foraging_brownmushroom(  "", Material.BROWN_MUSHROOM,   new String[]{""}, 200.0, 0.0,  "foraging"),
    foraging_redmushroom(    "", Material.RED_MUSHROOM,     new String[]{""}, 100.0, 0.0,  "foraging"),
    foraging_sporeblossom(   "", Material.SPORE_BLOSSOM,    new String[]{""}, 111.0, 0.0,  "foraging"),
    foraging_snifferegg(     "", Material.SNIFFER_EGG,      new String[]{""}, 50.0, 0.0,  "foraging"),
    foraging_frogspawn(      "", Material.FROGSPAWN,        new String[]{""}, 50.0, 0.0,  "foraging"),
    foraging_turtleegg(      "", Material.TURTLE_EGG,       new String[]{""}, 50.0, 0.0,  "foraging"),
    /** Mining */
    mining_coal(          "", Material.COAL,           new String[]{""}, 0.0, 0.03, "mining"),
    mining_iron(          "", Material.IRON_INGOT,     new String[]{""}, 0.0, 0.04,  "mining"),
    mining_gold(          "", Material.GOLD_INGOT,     new String[]{""}, 0.0, 0.05,  "mining"),
    mining_copper(          "", Material.COPPER_INGOT,     new String[]{""}, 0.0, 0.02,  "mining"),
    mining_lapis(         "", Material.LAPIS_LAZULI,   new String[]{""}, 0.0, 0.001,  "mining"),
    mining_diamonds(      "", Material.DIAMOND,        new String[]{""}, 0.0, 0.3,  "mining"),
    mining_obsidian(      "", Material.OBSIDIAN,       new String[]{""}, 0.0, 0.4,  "mining"),
    mining_ancientdebris( "", Material.ANCIENT_DEBRIS, new String[]{""}, 0.0, 1.0,  "mining"),
    mining_waterbucket(   "", Material.WATER_BUCKET,   new String[]{""}, 10.0, 0.0,  "mining"),
    mining_lavabucket(    "", Material.LAVA_BUCKET,    new String[]{""}, 100.0, 0.0,  "mining"),
    /** Mob Drops */
    mobdrops_rottenflesh(  "", Material.ROTTEN_FLESH,  new String[]{""}, 0.0, 0.05, "mobdrops"),
    mobdrops_gunpowder(    "", Material.GUNPOWDER,     new String[]{""}, 0.0, 0.06, "mobdrops"),
    mobdrops_string(       "", Material.STRING,        new String[]{""}, 0.0, 0.06, "mobdrops"),
    mobdrops_spidereye(    "", Material.SPIDER_EYE,    new String[]{""}, 0.0, 0.2, "mobdrops"),
    mobdrops_bone(         "", Material.BONE,          new String[]{""}, 0.0, 0.06, "mobdrops"),
    mobdrops_enderpearl(   "", Material.ENDER_PEARL,   new String[]{""}, 0.0, 0.02, "mobdrops"),
    mobdrops_blazerod(     "", Material.BLAZE_ROD,     new String[]{""}, 0.0, 0.5, "mobdrops"),
    mobdrops_shulkershell( "", Material.SHULKER_SHELL, new String[]{""}, 0.0, 1.0, "mobdrops"),
    mobdrops_beef( "", Material.BEEF, new String[]{""}, 0.0, 0.04, "mobdrops"),
    mobdrops_mutton( "", Material.MUTTON, new String[]{""}, 0.0, 0.04, "mobdrops"),
    mobdrops_chicken( "", Material.CHICKEN, new String[]{""}, 0.0, 0.03, "mobdrops"),
    mobdrops_porkchop( "", Material.PORKCHOP, new String[]{""}, 0.0, 0.04, "mobdrops"),

    /** Fishing */
    fishing_cod(           "", Material.COD,            new String[]{""}, 0.0, 0.5,  "fishing"),
    fishing_salmon(        "", Material.SALMON,         new String[]{""}, 0.0, 0.6,  "fishing"),
    fishing_tropicalfish(  "", Material.TROPICAL_FISH,  new String[]{""}, 0.0, 1.0,  "fishing"),
    fishing_pufferfish(    "", Material.PUFFERFISH,     new String[]{""}, 0.0, 1.0,  "fishing"),
    fishing_lilypad(       "", Material.LILY_PAD,       new String[]{""}, 0.0, 1.2,  "fishing"),
    fishing_nautilusshell( "", Material.NAUTILUS_SHELL, new String[]{""}, 0.0, 5.0, "fishing"),
    /** Redstone */
    redstone_redstone(         "", Material.REDSTONE,          new String[]{""}, 2.0, 0.0, "redstone"),
    redstone_redstoneore(      "", Material.REDSTONE_ORE,      new String[]{""}, 24.0, 0.0, "redstone"),
    redstone_slime(            "", Material.SLIME_BALL,        new String[]{""}, 6.0, 0.0, "redstone"),
    redstone_bell(             "", Material.BELL,              new String[]{""}, 10.0, 0.0, "redstone"),
    redstone_sculksensor(      "", Material.SCULK_SENSOR,      new String[]{""}, 50.0, 0.0, "redstone"),
    redstone_daylightdetector( "", Material.DAYLIGHT_DETECTOR, new String[]{""}, 7.0, 0.0, "redstone"),
    redstone_observer(         "", Material.OBSERVER,          new String[]{""}, 10.0, 0.0, "redstone"),
    /** Misc */
    misc_snowball(           "", Material.SNOWBALL,             new String[]{""}, 5.0, 0.0, "misc"),
    misc_totem(              "", Material.TOTEM_OF_UNDYING,     new String[]{""}, 50.0, 1.0, "misc"),
    misc_trident(            "", Material.TRIDENT,              new String[]{""}, 300.0, 0.0, "misc"),
    misc_spyglass(           "", Material.SPYGLASS,             new String[]{""}, 20.0, 0.0, "misc"),
    misc_bucketofcod(        "", Material.COD_BUCKET,           new String[]{""}, 105.0, 0.0, "misc"),
    misc_bucketofpufferfish( "", Material.PUFFERFISH_BUCKET,    new String[]{""}, 110.0, 0.0, "misc"),
    misc_bucketofaxolotl(    "", Material.AXOLOTL_BUCKET,       new String[]{""}, 110.0, 0.0, "misc"),
    misc_nametag(            "", Material.NAME_TAG,             new String[]{""}, 200.0, 0.0, "misc"),
    misc_saddle(             "", Material.SADDLE,               new String[]{""}, 10.0, 0.0, "misc"),
    misc_otherside(          "", Material.MUSIC_DISC_OTHERSIDE, new String[]{""}, 50.0, 0.0, "misc"),
    misc_5(                  "", Material.MUSIC_DISC_5,         new String[]{""}, 50.0, 0.0, "misc"),
    misc_pigstep(            "", Material.MUSIC_DISC_PIGSTEP,   new String[]{""}, 50.0, 0.0, "misc"),
    misc_relic(              "", Material.MUSIC_DISC_RELIC,     new String[]{""}, 50.0, 0.0, "misc"),
    misc_ice(              "", Material.ICE,     new String[]{""}, 1.0, 0.0, "misc"),
    misc_soulsoil(              "", Material.SOUL_SOIL,     new String[]{""}, 300.0, 0.0, "misc"),
    misc_netheriteupgrade(              "", Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE,     new String[]{""}, 500.0, 0.0, "misc"),
    misc_pointeddripstone(              "", Material.POINTED_DRIPSTONE,     new String[]{""}, 300.0, 0.0, "misc");

    private String displayName;
    private Material material;
    private String[] lore;
    private Double buyPrice;
    private Double sellPrice;
    private String inventory;

    ShopGUIItems(String displayName, Material material, String[] lore, Double buyPrice, Double sellPrice, String inventory) {
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
