data class CommonItem(val item: Item)

fun CommonItem.updateItem() {
    if(item.quality > 0) item.quality -= 1
    item.sellIn -= 1
}