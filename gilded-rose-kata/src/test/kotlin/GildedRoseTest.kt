import junit.framework.TestCase.assertEquals
import org.junit.Test

class GildedRoseTest {


    @Test
    fun `when call update quantity for common item with sellIn and quality above zero, will decrement sellIn and quality by one`(){
        val item = Item("CommonItem", 12,12);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(item.quality-1, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for common item with sellIn above zero and quality equal to zero, will only decrement sellIn by one`(){
        val item = Item("CommonItem", 12,0);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for common item with sellIn below zero and quality greater than one, will decrement quality by two and sellin by one`(){
        val item = Item("CommonItem", -12,12);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(item.quality-2, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for common item with sellIn below zero and quality equal to one, will decrement quality to zero and sellin by one`(){
        val item = Item("CommonItem", -12,1);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(item.quality-1, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for Sulfuras, Hand of Ragnaros item, will do nothing to the quality or sell in`(){
        val item = Item("Sulfuras, Hand of Ragnaros", 30,50);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for Aged Brie item with a sellin greater than 0, will decrease sell in by one and increase quality by one`(){
        val item = Item("Aged Brie", 30,12);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(item.quality+1, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for Aged Brie item with a sellin less than 0, will decrease sell in by one and increase quality by two`(){
        val item = Item("Aged Brie", -30,12);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(item.quality+2, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for Aged Brie item with a quality equal to fifty, will only decrease sell in by one`(){
        val item = Item("Aged Brie", -30,50);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(item.quality, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for Aged Brie item with a quality equal to forty-nine and sellin less than zero, will decrease sell in by one and increment quality by one`(){
        val item = Item("Aged Brie", -30,49);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(item.quality+1, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for Backstage passes to a TAFKAL80ETC concert item with a sellin greater than 10, will decrease sell in by one and increment quality by one`(){
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 20,10);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(item.quality+1, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for Backstage passes to a TAFKAL80ETC concert item with a sellin greater than 5 and less than 11, will decrease sell in by one and increment quality by two`(){
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 10,10);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(item.quality+2, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for Backstage passes to a TAFKAL80ETC concert item with a sellin greater than 0 and less than 6, will decrease sell in by one and increment quality by three`(){
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 5,10);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(item.quality+3, gildedRose.items[0].quality)
    }
    @Test
    fun `when call update quantity for Backstage passes to a TAFKAL80ETC concert item with a sellin equal to zero, will decrease sell in by one and set quality to 0`(){
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 0,10);
        val gildedRose = GildedRose(mutableListOf(item.copy()))
        gildedRose.updateQuality()
        assertEquals(item.sellIn-1, gildedRose.items[0].sellIn)
        assertEquals(0, gildedRose.items[0].quality)
    }
}