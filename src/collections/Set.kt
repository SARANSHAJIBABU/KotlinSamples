package collections

fun main(){

    val array = arrayOf(1,2,3,4,3,2,1)

    val toMutableSet = array.toMutableSet()
    toMutableSet.add(14)

    println(toMutableSet) //Removes duplicates

    array.forEachIndexed{
        index, value -> println("$index $value")
    }
}
