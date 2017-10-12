package com.gildedrose;

public final class ItemFactory {
    private ItemFactory() {}

    public static Item build(String name, int sellIn, int quality) {
        switch(name) {
            case Item.AGED_BRIE:
                return new AgedBrieItem(name, sellIn, quality);
            case Item.BACKSTAGE_PASS:
                return new BackstagePassItem(name, sellIn, quality);
            case Item.SULFURAS:
                return new SulfurasItem(name, sellIn, quality);
            default:
                return new Item(name, sellIn, quality);
        }
    }
}
