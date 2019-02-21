import junit.framework.TestCase.assertEquals
import org.junit.Test

class GildedRoseTest {

    @Test
    fun `when updateQuality, should degrade sellin and quality by one when both above zero`() {
        val item = Item(
                name = "testItem",
                sellIn = 10,
                quality = 10
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality - 1, gildedRose.items[0].quality)
    }


    @Test
    fun `when updateQuality, should degrade quality twice as fast when sellin is below zero`() {
        val item = Item(
                name = "testItem",
                sellIn = 0,
                quality = 10
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality - 2, gildedRose.items[0].quality)
    }


    @Test
    fun `when updateQuality with quality of one and sellin less than zero, should lower sellin date and degrade quality to zero`() {
        val item = Item(
                name = "testItem",
                sellIn = -1,
                quality = 1
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(0, gildedRose.items[0].quality)
    }


    @Test
    fun `when updateQuality with quality of zero and sellin greater than zero, should lower sell in date and not degrade quality to below zero`() {
        val item = Item(
                name = "testItem",
                sellIn = 1,
                quality = 0
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
    }


    @Test
    fun `when updateQuality with a 'Sulfuras, Hand of Ragnaros' item quality of 80 and sellin greater than zero, should not update quality or sellin`() {
        val itemName = "Sulfuras, Hand of Ragnaros"
        val item = Item(
                name = itemName,
                sellIn = 10,
                quality = 80
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)
    }


    @Test
    fun `when updateQuality with a 'Aged Brie' item that has quality of 20 and sellin greater than zero, should increase quality and decrease the sellin`() {
        val itemName = "Aged Brie"
        val item = Item(
                name = itemName,
                sellIn = 10,
                quality = 20
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality + 1, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)
    }


    @Test
    fun `when updateQuality with a 'Aged Brie' item that has quality of 20 and sellin less than zero, should increase quality twice and decrease the sellin`() {
        val itemName = "Aged Brie"
        val item = Item(
                name = itemName,
                sellIn = -1,
                quality = 20
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality + 2, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)
    }


    @Test
    fun `when updateQuality with a 'Aged Brie' item that has quality of 50 and any sellin , should not increase quality and decrease the sellin`() {
        val itemName = "Aged Brie"
        val sellIn = Math.ceil(Math.random() * 10).toInt()
        val item = Item(
                name = itemName,
                sellIn = sellIn,
                quality = 50
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)
    }


    @Test
    fun `when updateQuality with a 'Backstage passes to a TAFKAL80ETC concert' item quality of 5 and sellin greater than 11, should update quality one and decrease sellin 1`() {
        val itemName = "Backstage passes to a TAFKAL80ETC concert"
        val sellin = Math.ceil(Math.random() * 20).toInt() + 11
        val item = Item(
                name = itemName,
                sellIn = sellin,
                quality = 5
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality + 1, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)
    }


    @Test
    fun `when updateQuality with a 'Backstage passes to a TAFKAL80ETC concert' item quality of 5 and sellin greater than 6 and less than or equal to 10, should update quality two and decrease sellin 1`() {
        val itemName = "Backstage passes to a TAFKAL80ETC concert"
        val sellin = Math.ceil(Math.random() * 5).toInt() + 5
        val item = Item(
                name = itemName,
                sellIn = sellin,
                quality = 5
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality + 2, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)
    }


    @Test
    fun `when updateQuality with a 'Backstage passes to a TAFKAL80ETC concert' item quality of 5 and sellin greater than 0 and less than or equal to 5, should update quality three and decrease sellin 1`() {
        val itemName = "Backstage passes to a TAFKAL80ETC concert"
        val sellin = Math.ceil(Math.random() * 5).toInt()
        val item = Item(
                name = itemName,
                sellIn = sellin,
                quality = 5
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(item.quality + 3, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)
    }


    @Test
    fun `when updateQuality with a Backstage passes to a TAFKAL80ETC concert item quality of 5 and sellin equal to 0, should update quality to zero and decrease sellin ®1`() {
        val itemName = "Backstage passes to a TAFKAL80ETC concert"
        val item = Item(
                name = itemName,
                sellIn = 0,
                quality = 5
        )
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)

        gildedRose.updateQuality()

        assertEquals(1, gildedRose.items.size)
        assertEquals(item.sellIn - 1, gildedRose.items[0].sellIn)
        assertEquals(0, gildedRose.items[0].quality)
        assertEquals(itemName, gildedRose.items[0].name)
    }
}