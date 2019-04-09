package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

//TODO customers가 null일때는?
fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    // Return a customer whose order count is the highest among all customers
    return this.customers.maxBy { it.orders.size }
}


fun Customer.getMostExpensiveOrderedProduct(): Product? {
    return this.orders.flatMap { it.products }.toSet().maxBy { it.price }
}
