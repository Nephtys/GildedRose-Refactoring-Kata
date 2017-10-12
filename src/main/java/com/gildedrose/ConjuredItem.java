package com.gildedrose;

public class ConjuredItem extends Item {
    ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.sellIn--;

        this.quality = this.sellIn < 0 ? this.quality - 4 : this.quality - 2;

        if (this.quality < 0) {
            this.quality = 0;
        }
    }
}
