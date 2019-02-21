import junit.framework.Assert.assertEquals
import org.junit.Test

class CommonItemTest {


    @Test
    fun `when updateItem is called on a common item, it will decriment the quality and sellIn by one each`() {
        val item = CommonItem(Item("Some Item", 12,12))
        item.updateItem()
        assertEquals(item.item.sellIn, 11)
        assertEquals(item.item.quality, 11)
    }

    @Test
    fun `when updateItem is called on a common item with a sellin and quality of zero, it will decriment the sellIn by one but not decrement the quality`() {
        val item = CommonItem(Item("Some Item", 0,0))
        item.updateItem()
        assertEquals(item.item.sellIn, -1)
        assertEquals(item.item.quality, 0)
    }
}