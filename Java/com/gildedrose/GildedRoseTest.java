package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    @Test
    public void dexterity() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        Item[] itemsGolden = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(9));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(19));
    }

    @Test
    public void conjured() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(items[0].sellIn, is(9));
        assertThat(items[0].quality, is(18));
    }

    @Test
    public void conjuredAfterSellin() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(items[0].sellIn, is(-2));
        assertThat(items[0].quality, is(16));
    }

    @Test
    public void dexterityAfterSelli() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 20) };
        Item[] itemsGolden = new Item[] { new Item("+5 Dexterity Vest", -1, 20) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(-2));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(18));
    }

    @Test
    public void agedBrieAges1Day() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        Item[] itemsGolden = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(1));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(1));
    }

    @Test
    public void agedBrieAgesPastSellin() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 0) };
        Item[] itemsGolden = new Item[] { new Item("Aged Brie", 1, 0) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        app.updateQuality();
        appGolden.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(-1));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(3));
    }

    @Test
    public void agedBrieAgesPastSellinQualityShouldNeverBeMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 50) };
        Item[] itemsGolden = new Item[] { new Item("Aged Brie", -1, 50) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(-2));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(50));
    }

    @Test
    public void sulfurasBeforeSellin() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        Item[] itemsGolden = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(0));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(80));
    }

    @Test
    public void sulfurasAfterSellin() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        Item[] itemsGolden = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(-1));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(80));
    }

    @Test
    public void backStagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        Item[] itemsGolden = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(14));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(21));
    }


    @Test
    public void backStagePasses11() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 24) };
        Item[] itemsGolden = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 24) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(10));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(25));
    }

    @Test
    public void backStagePassesBellow11() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        Item[] itemsGolden = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(9));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(50));
    }

    @Test
    public void backStagePassesBellow11IncBy2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 47) };
        Item[] itemsGolden = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 47) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(9));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(49));
    }

    @Test
    public void backStagePassesBellow6() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45) };
        Item[] itemsGolden = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(4));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(48));
    }

    @Test
    public void backStagePassesAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 45) };
        Item[] itemsGolden = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 45) };
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        app.updateQuality();
        appGolden.updateQuality();

        assertThat(items[0].sellIn, is(itemsGolden[0].sellIn));
        assertThat(items[0].sellIn, is(-2));
        assertThat(items[0].quality, is(itemsGolden[0].quality));
        assertThat(items[0].quality, is(0));
    }

}
