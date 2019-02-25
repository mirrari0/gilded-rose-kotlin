import junit.framework.TestCase.assertEquals
import org.junit.Test

class GildedRoseTest {


    @Test
    fun `when multiple items in the item list, will update all of them`() {
        val itemOne = createItem()
        val itemTwo = createItem(itemName="item two")
        val gildedRose = GildedRose(mutableListOf(itemOne.copy(), itemTwo.copy()))
        gildedRose.updateQuality()

        assertEquals(itemOne.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(itemOne.quality - 1, gildedRose.items[0].quality)
        assertEquals(itemTwo.sellIn - 1, gildedRose.items[1].sellIn)
        assertEquals(itemTwo.quality - 1, gildedRose.items[1].quality)

    }

    @Test
    fun `when call update quantity for common item with sellIn and quality above zero, will decrement sellIn and quality by one`() {
        val item = createItem()
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality - 1, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for common item with sellIn above zero and quality equal to zero, will only decrement sellIn by one`() {
        val item = createItem(quality = 0)
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for common item with sellIn below zero and quality greater than one, will decrement quality by two and sellin by one`() {
        val item = createItem(sellIn = -12)
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality - 2, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for common item with sellIn below zero and quality equal to one, will decrement quality to zero and sellin by one`() {
        val item = createItem(sellIn = -12, quality = 1)
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality - 1, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for Sulfuras, Hand of Ragnaros item, will do nothing to the quality or sell in`() {
        val item = createItem("Sulfuras, Hand of Ragnaros", 30, 50)
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for Aged Brie item with a sellin greater than 0, will decrease sell in by one and increase quality by one`() {
        val item = createItem(itemName = "Aged Brie")
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality + 1, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for Aged Brie item with a sellin less than 0, will decrease sell in by one and increase quality by two`() {
        val item = createItem(itemName = "Aged Brie", sellIn = -30)
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality + 2, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for Aged Brie item with a quality equal to fifty, will only decrease sell in by one`() {
        val item = createItem(itemName = "Aged Brie", sellIn = -30, quality = 50)
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for Aged Brie item with a quality equal to forty-nine and sellin less than zero, will decrease sell in by one and increment quality by one`() {
        val item = createItem(itemName = "Aged Brie", sellIn = -30, quality = 49)
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality + 1, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for Backstage passes to a TAFKAL80ETC concert item with a sellin greater than 10, will decrease sell in by one and increment quality by one`() {
        val item = createItem(itemName="Backstage passes to a TAFKAL80ETC concert")
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality + 1, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for Backstage passes to a TAFKAL80ETC concert item with a sellin greater than 5 and less than 11, will decrease sell in by one and increment quality by two`() {
        val item = createItem(itemName="Backstage passes to a TAFKAL80ETC concert", sellIn=10)
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality + 2, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for Backstage passes to a TAFKAL80ETC concert item with a sellin greater than 0 and less than 6, will decrease sell in by one and increment quality by three`() {
        val item = createItem(itemName="Backstage passes to a TAFKAL80ETC concert", sellIn=5)
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality + 3, gildedRose.items[0].quality)
    }

    @Test
    fun `when call update quantity for Backstage passes to a TAFKAL80ETC concert item with a sellin equal to zero, will decrease sell in by one and set quality to 0`() {
        val item = createItem(itemName="Backstage passes to a TAFKAL80ETC concert", sellIn=0)
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(0, gildedRose.items[0].quality)
    }

    fun createItem(itemName: String = "Common Item Name", sellIn: Int = 12, quality: Int = 12): Item {
        return Item(itemName, sellIn, quality)
    }
}