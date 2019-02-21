class CommonItem(override var item: Item) : CommonUpdateItem{

    override fun Item.updateQuality() {
        if(quality > 0) quality -= 1
        if(quality > 0 && sellIn <0) quality -= 1
    }
}

