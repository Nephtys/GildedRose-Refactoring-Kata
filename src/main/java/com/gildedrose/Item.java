package com.gildedrose;

public class Item {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured ";

    public String name;

    public int sellIn;

    public int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void updateQuality() {
        this.sellIn--;

        this.quality = this.sellIn < 0 ? this.quality - 2 : this.quality - 1;

        if (this.quality < 0) {
            this.quality = 0;
        }
    }
}
