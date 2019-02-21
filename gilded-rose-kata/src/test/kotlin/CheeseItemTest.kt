import junit.framework.Assert
import org.junit.Test

class CheeseItemTest : AbstractUpdateItem {
    override fun AbstractUpdateItem.updateItem() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    @Test
    fun `when updateItem is called on a common item, it will decriment the sellIn by one and increment the quality by 1`() {
        val item = CheeseItem(Item("Some Item", 12,12))
        item.updateItem()
        Assert.assertEquals(item.item.sellIn, 11)
        Assert.assertEquals(item.item.quality, 13)
    }

}