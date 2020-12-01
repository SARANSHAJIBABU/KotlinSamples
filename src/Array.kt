fun main(){

    val intArray = arrayOf(1,2,3,4) //int array

    val longArray = arrayOf(1L,2L, 3L) //long array

    val longArray2: Array<Long> = arrayOf(1,2,3) //long array

    //Array with constructor
    val genericArray = Array(10) {
        it*5
    }

    println()
    genericArray.forEach {
        print(it)
    }

    println()
    val arrayOfZeros = Array(10){0}

    arrayOfZeros.forEach {
        print(it)
    }
    println()

    //Kotlin Array<Int> is not compatible with java int[], since java expect primitive arrays
    JavaTest.takeIntArray(intArray.toIntArray())


    println()
    val primitiveArray = IntArray(5) //Primitive int arrays initialized with 0
    primitiveArray.forEach {
        print(it)
    }
    println()

    //To convert java primitive array to kotlin array, use toTypedArray()
    val javaArray = JavaTest.getIntArray()
    javaArrayTest(javaArray.toTypedArray())

    val longArrayExtd = longArray.plus(longArrayOf(9L,10L,11L).toTypedArray())
    println()
    longArrayExtd.forEach {
        print(it)
    }

}

fun javaArrayTest(arr: Array<Int>){

}
