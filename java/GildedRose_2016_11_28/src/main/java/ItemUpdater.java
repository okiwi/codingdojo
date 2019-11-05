import java.util.List;

public class ItemUpdater {

    public void updateQuality(List<Item> items) {
        for (Item item : items) {
            updateOne(item);
        }
    }

    private void updateOne(Item item) {
        if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            return;
        }
        if ("Aged Brie".equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
            increaseQuality(item);
            if (item.getSellIn() < 0) {
                increaseQuality(item);
            }
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
            increaseQuality(item);
            if (item.getSellIn() < 10) {
                increaseQuality(item);
            }
            if (item.getSellIn() < 5) {
                increaseQuality(item);
            }
            if (item.getSellIn() < 0) {
                item.setQuality(0);
            }
        } else {
            item.setSellIn(item.getSellIn() - 1);
            decreaseQuality(item);
            if (item.getSellIn() < 0) {
                decreaseQuality(item);
            }
        }
    }

    private void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }
}
