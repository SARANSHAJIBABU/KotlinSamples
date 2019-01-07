package kt.helloworld

fun main(args: Array<String>){
    println("Hello World")

  var a = 170
    println(a.toShort())
    println(a.toLong())
    println(a.toChar())

    val b = intArrayOf(1,2,3)
    println(b.toTypedArray() is Array<Int>)

}