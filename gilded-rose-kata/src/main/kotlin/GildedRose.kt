class GildedRose(
        val items: List<Item>) {

    val SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros"
    val CONCERT = "Backstage passes to a TAFKAL80ETC concert"
    val AGED_BRIE = "Aged Brie"


    fun updateQuality() {
        items.forEach {
            if (AGED_BRIE == it.name) {
                handleAgedBrie(it)
            } else if (CONCERT == it.name) {
                handleConcert(it)
            } else if (SULFURAS_HAND_OF_RAGNAROS != it.name) {
                handleCommon(it)
            }
        }
    }

    private fun handleCommon(it: Item) {
        decrementQuality(it)
        it.sellIn = it.sellIn - 1
        if (it.sellIn < 0) {
            decrementQuality(it)
        }
    }

    private fun decrementQuality(item: Item) {
        if (item.quality > 0)
            item.quality -= 1
    }


    private fun handleConcert(it: Item) {
        incrementQuality(it)
        if (it.sellIn < 11) {
            incrementQuality(it)
        }
        if (it.sellIn < 6) {
            incrementQuality(it)
        }
        it.sellIn -= 1
        if (it.sellIn < 0) {
            it.quality = 0
        }

    }

    private fun incrementQuality(item: Item) {
        if (item.quality < 50)
            item.quality += 1
    }

    private fun handleAgedBrie(item: Item) {
        incrementQuality(item)
        item.sellIn -= 1
        if (item.sellIn < 0) {
            incrementQuality(item)
        }
    }

}