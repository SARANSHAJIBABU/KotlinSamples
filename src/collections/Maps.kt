package collections

fun main(){
    val intMap = mutableMapOf(
        0 to 0
    )
    intMap.put(1,11)
    intMap[2] = 22
    intMap[3] = 333

    println(intMap)


    intMap.forEach { key, value -> println("$key : $value") }
}
