class CheeseItem(override var item: Item): CommonUpdateItem {

    override fun Item.updateQuality() {
        if(quality < 50) quality +=1
        if(quality < 50 && sellIn <0) quality+=1
    }

}

