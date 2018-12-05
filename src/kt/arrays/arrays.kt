package kt.arrays

import jva.DummyClass

fun main(args:Array<String>){

    val a = arrayOf(1,2,3)

    println("${a is Array<Int>}")

    val b = arrayOf(1L,2L,3L)

    println("${b is Array<Long>}")

    val zeros = Array(10){0}

    for(i in zeros){
        print(i)
    }
    println()
    val even = Array(10){i->i*2}

    for(i in even){
        print(i)
    }

    val mixed = arrayOf("a",1,2L,2.0f,5.4,'z')

    println()
    for(i in mixed){
        print(i)
    }

    val tempArr = arrayOf(1,3,5,7)
    //Cant pass generic array of int to int[] in java
    //Must pass intArray
    DummyClass.printArray(tempArr.toIntArray())


    val intarr = intArrayOf(2,4,6,8)
    DummyClass.printArray(intarr)

    val typed =  intarr.toTypedArray()
    println()
    for(i in typed){
        print(i)
    }


    //Arrays created and initialized with nulls
    val arr1 = arrayOfNulls<Int>(5)
    val arr2 = arrayOfNulls<Int?>(5)

}