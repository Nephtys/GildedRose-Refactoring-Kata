package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQuality(item);
        }
    }

    private void updateQuality(Item item) {

        if (SULFURAS.equals(item.name)) {
            return;
        }

        if (AGED_BRIE.equals(item.name)) {
            if (item.quality < 50) {
                item.quality++;
            }

            item.sellIn--;

            if (item.sellIn < 0 && item.quality < 50) {
                item.quality++;
            }
            return;
        }


        if (!BACKSTAGE_PASS.equals(item.name)) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (BACKSTAGE_PASS.equals(item.name)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (!BACKSTAGE_PASS.equals(item.name)) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            } else {
                item.quality = 0;
            }
        }
    }
}