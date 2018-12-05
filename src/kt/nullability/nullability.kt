package kt.nullability

import jdk.nashorn.internal.objects.NativeString.substring

fun main(args: Array<String>){
    println("Hello World")

    /*********************************Safe call operator***********************************/
    var abc:String? = null

    //Usual java way
    if(abc!=null){
        println("${abc.toUpperCase()}")
    }else{
        println(null)
    }

    //Kotlin safe call
    println("${abc?.toUpperCase()}")



    //Java complex null check
    if(abc!=null){
        val a = abc.substring(0,10)
        if(a!=null){
            val b = a.substring(0,8)
            if(b!=null){
                val c = b.substring(0,6)
                if(c!=null){
                    c.substring(0,4)
                }else{
                    null
                }
            }else{
                null
            }
        }else{
            null
        }
    }else{
        null
    }

    //Equivalent expression using Kotlin safe call
    val t = abc?.substring(0,10)?.substring(0,8)?.substring(0,6)?.substring(0,4)

    //if abc is null or any of the substring results in null, entire expression is
    //shorted to null, without causing null pointer expression

    println(t)


    /*********************************Safe call with let***********************************/

    //If we want to pass a non null object to a method in a library, we can use ?.let{}

    abc = null

    //Java style
    /*
    if(abc!=null){
        printText(abc)
    }*/

    abc?.let{
        printText(it)
    }
    //Here we are executing code only if value of abc is not null

    /*********************************Safe cast operator***********************************/

    var xyz: String?

    xyz = null

    println("Java Style")
    if(xyz is String){
        println(xyz.substring(0,3))
    }else{
        println(null)
    }

    println("Kotlin Style")

    //Equivalent expression using Kotlin safe cast call
    println((xyz as? String)?.substring(0,3))
    //if xyz is null, entire expression is shorted to null, without causing null pointer expression


    /*********************************Elvis  operator***********************************/

    var qrs:String?

    qrs = "123"

/*    println("Java Style")
    if(qrs==null){
        qrs = "Hello World"
    }else{
        qrs = qrs
    }
    println(qrs) */

    qrs = qrs?:"Hello World"
    println(qrs)

    /*********************************Equals safe operator***********************************/

    var bb:String? = null
    val tt = "sdfsd"

    println("bb==tt: ${bb==tt}")
    //Equals operator can be used with nullable object, since it is a safe operator

    /*********************************Strong (non null asserted)  operator***********************************/

    var pq:String?

    pq = null

    //Java way
 /*   if(pq==null){
        throw Exception()
    }else{
        pq.substring(0,1)
    }*/

//    println(pq!!.substring(0,1))

    val temp = pq!!

    println(temp)

    //If we use !! operator and the object happens to be null, exception will be thrown where
    //we used !! (line:107) and not where we used the null object

}

fun printText(str:String){
    println("In printText: $str")
}