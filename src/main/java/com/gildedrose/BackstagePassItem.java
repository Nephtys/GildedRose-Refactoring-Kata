package com.gildedrose;

public class BackstagePassItem extends Item {
    BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality < 50) {
            this.quality++;

            if (this.sellIn < 11 && this.quality < 50) {
                this.quality++;
            }

            if (this.sellIn < 6 && this.quality < 50) {
                this.quality++;
            }
        }

        this.sellIn--;

        if (this.sellIn < 0) {
            this.quality = 0;
        }
    }
}
