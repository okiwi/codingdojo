import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class ItemUpdaterGoldenMaster {

    @Test
    public void runGolderMaster() throws Exception {
        ArrayList<Item> items = itemsSet();
        ArrayList<Item> legacyitemsSet = itemsSet();
        ItemUpdater itemUpdater = new ItemUpdater();
        ItemUpdaterLegacy itemUpdaterLegacy = new ItemUpdaterLegacy();

        for (int i = 0; i < 100; i++) {
            itemUpdater.updateQuality(items);
            itemUpdaterLegacy.updateQuality(legacyitemsSet);
            for (int j = 0; j < items.size(); j++) {
                Item item = items.get(j);
                Item legacyItem = legacyitemsSet.get(j);
                assertEquals(item.getName(), legacyItem.getName());
                assertEquals(item.getQuality(), legacyItem.getQuality());
                assertEquals(item.getSellIn(), legacyItem.getSellIn());
            }
        }
    }

    private ArrayList<Item> itemsSet() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        return items;
    }
}
