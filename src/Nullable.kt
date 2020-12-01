import Bank.*

class Message(val content: String?){

    //Agreed format => airportcode:countrycode xx:yy


    //Safe call. If content is not null, do substring
    // result is also nullable
    //Equivalent to if (content == null) return null else return content.substring(0,1)
    val airportCode: String? = content?.substring(0,2)


    //Elvis. If content is not null, do substring, else use default value
    // result is non nullable
    //Equivalent to if (content == null) return default else return content.substring(0,1)
    val countryCode: String = content?.substring(3,5)?:"IN"
}

 class Bank(val code: String, val branch: Branch?){

     class Branch(val code: String, val city: City?)

     class City(val name: String?)

 }

fun main(){
    val n = Message(null)
    println(n.airportCode)
    println(n.countryCode)

    val m = Message("CH:SG")
    println(m.airportCode)
    println(m.countryCode)


    val b2 =Bank("IOB", Branch("QLN", City("Quilon")))
    println(b2.branch?.city?.name)

    val b1 =Bank("SBI", null)
    println(b1.branch?.city?.name)
    println(b1.branch?.city?.name?:"NOT_DEFINED")  //Elvis to set default value if any of the value in chain is null

    doubleBangTest()
    requireNotNullTest()

}

fun doubleBangTest(){
    var fieldFromApi: String? = null
    var temp = fieldFromApi!! //KotlinNullPointerException will be thrown in this line, if fieldFromApi is null
    println(temp.length)
}

fun requireNotNullTest(){
    var fieldFromApi: String? = null
    var temp = requireNotNull(fieldFromApi) //IllegalArgumentException will be thrown in this line, if fieldFromApi is null
    println(temp.length)
}


