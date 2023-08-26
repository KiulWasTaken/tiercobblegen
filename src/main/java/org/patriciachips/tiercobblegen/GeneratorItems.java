package org.patriciachips.tiercobblegen;

import org.bukkit.Material;

public enum GeneratorItems {
        //redstone_("", Material., new String[]{""}, 0, true, false, "redstone"),
        cobblestone(Material.COBBLESTONE,80.0);

        private String displayName;
        private Material material;
        private String[] lore;
        private Double sellPrice;
        private Double buyPrice;
        private String inventory;

        GeneratorItems(Material material, double chance) {
                this.displayName = displayName;
                this.material = material;
                this.lore = lore;
                this.sellPrice = sellPrice;
                this.buyPrice = buyPrice;
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

        public Double getSellPrice() {
                return sellPrice;
        }

        public Double getBuyPrice() {
                return buyPrice;
        }

        public String getItemInventory() {
                return inventory;
        }

    }
