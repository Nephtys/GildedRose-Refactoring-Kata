package com.gildedrose;

public class Item {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality() {

        if (SULFURAS.equals(this.name)) {
            return;
        }

        if (AGED_BRIE.equals(this.name)) {
            if (this.quality < 50) {
                this.quality++;
            }

            this.sellIn--;

            if (this.sellIn < 0 && this.quality < 50) {
                this.quality++;
            }
            return;
        }

        if (BACKSTAGE_PASS.equals(this.name)) {
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
            return;
        }


        if (this.quality > 0) {
            this.quality = this.quality - 1;
        }


        this.sellIn = this.sellIn - 1;

        if (this.sellIn < 0) {
            if (this.quality > 0) {
                this.quality = this.quality - 1;
            }

        }
    }
}
