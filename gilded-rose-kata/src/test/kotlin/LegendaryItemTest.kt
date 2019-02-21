import junit.framework.Assert.assertEquals
import org.junit.Test

class LegendaryItemTest {


    @Test
    fun `when updateItem is called on a legendary item, it will do nothing`() {
        val item = LegendaryItem(Item("Some Item", 30,80))
        item.updateItem()
        assertEquals(item.item.sellIn, 30)
        assertEquals(item.item.quality, 80)
    }

}