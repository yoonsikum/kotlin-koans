package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

//TODO extension이 아니고 필드를 추가한건가?
val Customer.orderedProducts: Set<Product>
    get() {
        return this.orders.flatMap { it.products }.toSet()
    }

val Shop.allOrderedProducts: Set<Product>
    get() {
        return this.customers.flatMap { it.orderedProducts }.toSet()
    }