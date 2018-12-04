package kt.nullability

fun main(args: Array<String>){
    println("Hello World")

    /*********************************Safe call operator***********************************/
    val abc:String? = null

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

}