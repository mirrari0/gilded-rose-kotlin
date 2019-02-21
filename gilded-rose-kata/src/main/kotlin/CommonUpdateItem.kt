interface CommonUpdateItem : AbstractUpdateItem{

    var item: Item


    override fun AbstractUpdateItem.updateItem() {
        item.sellIn -= 1
        item.updateQuality()
    }

    abstract fun Item.updateQuality()
}