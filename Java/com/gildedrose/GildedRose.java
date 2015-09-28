package com.gildedrose;

class GildedRose {
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
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = item.quality + 1;
            if (item.sellIn < 11) {
                item.quality = item.quality + 1;
            }

            if (item.sellIn < 6) {
                item.quality = item.quality + 1;

            }
        } else {
            age(item);
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            age(item);
        }

        if (item.quality > 50) {
            item.quality = 50;
        }

    }

    private void age(Item item) {
        switch(item.name) {
            case "Aged Brie":
                item.quality = item.quality + 1;
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item.quality = 0;
                break;
            case "Conjured Mana Cake":
                item.quality = item.quality - 2;
                break;
            default:
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
        }
    }
}
