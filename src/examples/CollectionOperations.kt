package examples

data class Product(val id: Int, val name: String, val price: Double)

data class Worker(val id: Int, val name: String)

data class Receipt(val id: Int, val seller: Worker, val products: List<Product>, val isPaid: Boolean = false)

class Store(val receipts: List<Receipt>, val workers: List<Worker>)

fun beer() = Product(id = 2, name = "Beer, light, 0.5l", price = 7.5)
fun coffee() = Product(id = 3, name = "Ground coffee 1kg", price = 5.0)
fun bread() = Product(id = 1, name = "Gluten-free bread, 1kg", price = 5.0)

fun main(){
    val worker1 = Worker(1, "Filip")
    val worker2 = Worker(2, "Chris")

    val receipt1 = Receipt(
        1,
        worker1,
        listOf(bread(), bread(), bread(), coffee(), beer()),
        true
    )

    val receipt2 = Receipt(
        2,
        worker2,
        listOf(coffee(), coffee(), beer(), beer(), beer())
    )

    val receipt3 = Receipt(
        3,
        worker2,
        listOf( beer(), beer(), bread())
    )


    val store = Store(
        listOf(receipt1, receipt2, receipt3),
        listOf(worker1, worker2)
    )

    //transform(store)
    filter(store,worker1,worker2)
    //validate(store)
    //lookUp(store)

}

private fun transform(store: Store){
    val listOfProductLists = store.receipts.map {
        it.products
    }.toList()

    println(listOfProductLists)

    val listOfProducts = store.receipts.flatMap {
        it.products
    }.toList()

    println(listOfProducts)

    val uniqueProducts = listOfProducts.toSet()
    println(uniqueProducts)

    val pricesOfAllProducts = store.receipts.flatMap {
        it.products
    }.map {
        it.price
    }.sumByDouble { it }

    println(pricesOfAllProducts)
}

private fun filter(store: Store,worker1: Worker, worker2: Worker){
    //Filters out and give receipts which are paid
    val paidReceipts = store.receipts.filter {
        it.isPaid
    }

    println(paidReceipts)

    //Partition will create a Pair<List<Receipt>,List<Receipt>>
    val paidUnpaid = store.receipts.partition {
        it.isPaid
    }
    println(paidUnpaid)

    val (paid,unpaid) = paidUnpaid
    println(paid)
    println(unpaid)

    //groupBy returns a map of (seller,List<Receipt>)
    val soldBy = store.receipts.groupBy {
        it.seller
    }
    println(soldBy[worker1])
    println(soldBy[worker2])

    val firstReceipt = store.receipts.take(1)

    val allExceptFirst = store.receipts.drop(1)

    val distinct = store.receipts.distinct()

    //Collect until first nonpaid item
    val takeWhile = store.receipts.takeWhile {
        it.isPaid
    }
    println(takeWhile)

    val dropWhile = store.receipts.dropWhile {
        it.isPaid
    }
    println(dropWhile)
}

private fun validate(store: Store){
    val areThereNoReceipts = store.receipts.isEmpty()
    println(areThereNoReceipts)

    val allPaid = store.receipts.all {
        it.isPaid
    }
    println(allPaid)

    val nonePaid = store.receipts.none{
        it.isPaid
    }
    println(nonePaid)

    val anyPaid = store.receipts.any {
        it.isPaid
    }
    println(anyPaid)
}

private fun lookUp(store: Store){

    val firstPaidRecipt = store.receipts.first { it.isPaid }
    println(firstPaidRecipt)

    val firstPaidOrNull = store.receipts.firstOrNull { it.isPaid }
    println(firstPaidOrNull)

    val lastUnpaid = store.receipts.last {
        !it.isPaid
    }
    println(lastUnpaid)
}

