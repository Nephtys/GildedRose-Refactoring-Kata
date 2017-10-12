package com.gildedrose;

public class AgedBrieItem extends Item {
    AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality < 50) {
            this.quality++;
        }

        this.sellIn--;

        if (this.sellIn < 0 && this.quality < 50) {
            this.quality++;
        }
    }
}
