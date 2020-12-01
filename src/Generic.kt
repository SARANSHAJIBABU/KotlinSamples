fun main(){
    println((1..9).toList().concatItems())
    println(('a'..'z').toList().concatItems())
    println(arrayListOf("Saran","Babu").concatItems())



}

/*Generic extension function*/
fun <T> List<T>.concatItems(): String{
    var acc = ""
    this.forEach {
        acc = "$acc$it"
    }
    return acc
}

/*Generic interface*/
interface MyList<T>{
    fun get(index: Int):T
}

class StringList: MyList<String> {
    override fun get(index: Int): String = "hello"
}

/*Generic class - Nullable T*/
class CustomList<T>: MyList<T>{
    private val list = mutableListOf<T>()
    override fun get(index: Int):T {
        return list.get(index)
    }

}

/*Generic function with type constraint*/
fun <T:Number> oneHalf(t:T):Double{
    return t.toDouble()
}

/*Generic function with type constraint 2*/
fun <T: Comparable<T>> max(first:T, second: T): T{
    return if(first>second)
        first
    else
        second
}

fun <T> ensureTrailingPeriod(seq: T)
                where T: CharSequence, T: Appendable {
    if(!seq.endsWith('.')){
        seq.append(".")
    }
}

/*Non null generic param*/
interface MyListNonNull<T:Any>{
    fun get(index: Int):T
}
