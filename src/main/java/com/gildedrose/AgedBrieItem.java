package com.gildedrose;

public class AgedBrieItem extends Item {
    AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.sellIn--;

        this.quality = this.sellIn < 0 ? this.quality + 2 : this.quality + 1;

        if (this.quality > 50) {
            this.quality = 50;
        }
    }
}
