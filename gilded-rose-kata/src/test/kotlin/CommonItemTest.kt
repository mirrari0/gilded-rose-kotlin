import junit.framework.Assert.assertEquals
import org.junit.Test

class CommonItemTest: CommonUpdateItem {
    override var item: Item
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override fun Item.updateQuality() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    @Test
    fun `when updateItem is called on a common item, it will decriment the quality and sellIn by one each`() {
        val commonItem = CommonItem(Item("Some Item", 12,12))
        commonItem.updateItem()
        assertEquals(commonItem.item.sellIn, 11)
        assertEquals(commonItem.item.quality, 11)
    }

    @Test
    fun `when updateItem is called on a common item with a sellin greater than zero and quality of zero, it will decriment the sellIn by one but not decrement the quality`() {
        val commonItem = CommonItem(Item("Some Item", 12,0))
        commonItem.updateItem()
        assertEquals(commonItem.item.sellIn, 11)
        assertEquals(commonItem.item.quality, 0)
    }

    @Test
    fun `when updateItem is called on a common item with a sellin less than zero and quality greater than one, it will decriment the sellIn by one and decrement the quality by two`() {
        val commonItem = CommonItem(Item("Some Item", -1,12))
        commonItem.updateItem()
        assertEquals(commonItem.item.sellIn, -2)
        assertEquals(commonItem.item.quality, 10)
    }

    @Test
    fun `when updateItem is called on a common item with a sellin less than zero and quality of one, it will decriment the quality and sellIn by one each`() {
        val commonItem = CommonItem(Item("Some Item", -1,1))
        commonItem.updateItem()
        assertEquals(commonItem.item.sellIn, -2)
        assertEquals(commonItem.item.quality, 0)
    }
}