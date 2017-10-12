package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    private static final String ORANGE = "Orange";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String QUALITY_FIELD = "quality";
    public static final String SELL_IN_FIELD = "sellIn";


    // BASIC ITEM

    @Test
    public void the_quality_of_an_item_should_decrease_by_1_before_sell_date() {
        Item[] items = new Item[] {
                new Item(ORANGE, 5, 10),
                new Item(ORANGE, 1, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsOnly(9);
    }

    @Test
    public void the_quality_of_an_item_should_decrease_by_2_after_sell_date() {
        Item[] items = new Item[] {
                new Item(ORANGE, -5, 10),
                new Item(ORANGE, -1, 10),
                new Item(ORANGE, 0, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsOnly(8);
    }

    @Test
    public void the_quality_of_an_item_should_not_be_less_than_0() {
        Item[] items = new Item[] {
                new Item(ORANGE, 5, 1),
                new Item(ORANGE, 5, 0),
                new Item(ORANGE, -1, 2),
                new Item(ORANGE, -1, 1),
                new Item(ORANGE, -1, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsOnly(0);
    }

    @Test
    public void the_sellIn_value_of_an_item_should_decrease() {
        Item[] items = new Item[] {
                new Item(ORANGE, 5, 0),
                new Item(ORANGE, 0, 0),
                new Item(ORANGE, -1, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(SELL_IN_FIELD).containsExactly(4, -1, -2);
    }

    // AGED BRIE

    @Test
    public void the_quality_of_aged_brie_should_increase_by_1_before_sell_date() {
        Item[] items = new Item[] {
                new Item(AGED_BRIE, 5, 10),
                new Item(AGED_BRIE, 1, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsOnly(11);
    }

    @Test
    public void the_quality_of_aged_brie_should_increase_by_2_after_sell_date() {
        Item[] items = new Item[] {
                new Item(AGED_BRIE, -5, 10),
                new Item(AGED_BRIE, -1, 10),
                new Item(AGED_BRIE, 0, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsOnly(12);
    }

    @Test
    public void the_quality_of_aged_brie_should_not_be_more_than_50() {
        Item[] items = new Item[] {
                new Item(AGED_BRIE, 5, 49),
                new Item(AGED_BRIE, 5, 50),
                new Item(AGED_BRIE, -1, 50),
                new Item(AGED_BRIE, -1, 49),
                new Item(AGED_BRIE, -1, 48),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsOnly(50);
    }

    @Test
    public void the_sellIn_value_of_aged_brie_should_decrease() {
        Item[] items = new Item[] {
                new Item(AGED_BRIE, 5, 0),
                new Item(AGED_BRIE, 0, 0),
                new Item(AGED_BRIE, -1, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(SELL_IN_FIELD).containsExactly(4, -1, -2);
    }

    // SULFURAS

    @Test
    public void the_quality_of_sulfuras_should_not_change() {
        Item[] items = new Item[] {
                new Item(SULFURAS, 5, 80),
                new Item(SULFURAS, 5, 50),
                new Item(SULFURAS, -1, 80),
                new Item(SULFURAS, -1, 49),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsExactly(80, 50, 80, 49);
    }

    @Test
    public void the_sellIn_value_of_sulfuras_should_not_change() {
        Item[] items = new Item[] {
                new Item(SULFURAS, 5, 80),
                new Item(SULFURAS, 0, 80),
                new Item(SULFURAS, -1, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(SELL_IN_FIELD).containsExactly(5, 0, -1);
    }

    // BACKSTAGE PASS

    @Test
    public void the_quality_of_backstage_pass_should_increase_by_1_more_than_10_days_before_sell_date() {
        Item[] items = new Item[] {
                new Item(BACKSTAGE_PASS, 15, 10),
                new Item(BACKSTAGE_PASS, 11, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsOnly(11);
    }

    @Test
    public void the_quality_of_backstage_pass_should_increase_by_2_less_than_10_days_before_sell_date() {
        Item[] items = new Item[] {
                new Item(BACKSTAGE_PASS, 10, 10),
                new Item(BACKSTAGE_PASS, 9, 10),
                new Item(BACKSTAGE_PASS, 6, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsOnly(12);
    }

    @Test
    public void the_quality_of_backstage_pass_should_increase_by_1_less_than_5_days_before_sell_date() {
        Item[] items = new Item[] {
                new Item(BACKSTAGE_PASS, 5, 10),
                new Item(BACKSTAGE_PASS, 1, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsOnly(13);
    }

    @Test
    public void the_quality_of_backstage_pass_should_be_0_after_sell_date() {
        Item[] items = new Item[] {
                new Item(BACKSTAGE_PASS, 0, 10),
                new Item(BACKSTAGE_PASS, -1, 10),
                new Item(BACKSTAGE_PASS, -5, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsOnly(0);
    }

    @Test
    public void the_quality_of_backstage_pass_should_not_be_more_than_50() {
        Item[] items = new Item[] {
                new Item(BACKSTAGE_PASS, 15, 49),
                new Item(BACKSTAGE_PASS, 15, 50),
                new Item(BACKSTAGE_PASS, 9, 50),
                new Item(BACKSTAGE_PASS, 9, 49),
                new Item(BACKSTAGE_PASS, 9, 48),
                new Item(BACKSTAGE_PASS, 3, 50),
                new Item(BACKSTAGE_PASS, 3, 49),
                new Item(BACKSTAGE_PASS, 3, 48),
                new Item(BACKSTAGE_PASS, 3, 47),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(QUALITY_FIELD).containsOnly(50);
    }

    @Test
    public void the_sellIn_value_of_backstage_pass_should_decrease() {
        Item[] items = new Item[] {
                new Item(BACKSTAGE_PASS, 5, 0),
                new Item(BACKSTAGE_PASS, 0, 0),
                new Item(BACKSTAGE_PASS, -1, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(SELL_IN_FIELD).containsExactly(4, -1, -2);
    }

}
