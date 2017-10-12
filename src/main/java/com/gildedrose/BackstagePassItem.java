package com.gildedrose;

public class BackstagePassItem extends Item {
    BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.sellIn--;

        if (this.sellIn < 0) {
            this.quality = 0;
        } else if (this.sellIn < 5) {
            this.quality += 3;
        } else if (this.sellIn < 10) {
            this.quality += 2;
        } else {
            this.quality += 1;
        }

        if (this.quality > 50) {
            this.quality = 50;
        }
    }
}
