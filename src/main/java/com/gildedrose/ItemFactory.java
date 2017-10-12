package com.gildedrose;

public final class ItemFactory {
    private ItemFactory() {}

    public static Item build(String name, int sellIn, int quality) {
        if (Item.AGED_BRIE.equals(name)) {
            return new AgedBrieItem(name, sellIn, quality);
        }

        if (Item.BACKSTAGE_PASS.equals(name)) {
            return new BackstagePassItem(name, sellIn, quality);
        }

        if (Item.SULFURAS.equals(name)) {
            return new SulfurasItem(name, sellIn, quality);
        }

        if (name.startsWith(Item.CONJURED)) {
            return new ConjuredItem(name, sellIn, quality);
        }

        return new Item(name, sellIn, quality);
    }
}
