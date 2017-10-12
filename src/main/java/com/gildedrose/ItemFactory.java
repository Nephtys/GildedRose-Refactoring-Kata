package com.gildedrose;

public final class ItemFactory {
    private ItemFactory() {}

    public static Item build(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }
}
