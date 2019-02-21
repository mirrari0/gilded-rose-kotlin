import junit.framework.Assert.assertEquals
import org.junit.Test

class LegendaryItemTest : LegendaryUpdateItem {

    @Test
    fun `when updateItem is called on a legendary item, it will do nothing`() {
        val item = LegendaryItem(Item("Some Item", 30,80))
        item.updateItem()
        assertEquals(80, item.item.quality)
        assertEquals(30, item.item.sellIn)
    }

}