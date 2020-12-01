//const keyword is used to mark those constants, for those values are known during compile time
//Must be top level or member of companion object
//Initialized with String/ Primitive
//No custom getter

class ClassLevel{
    companion object {
        const val TIME_OUT = 5000
    }

}

object AppLevel{
    object API_CONFIG{
        const val BASE_URL = "https://abc.com"
    }
}

fun main(){
    println(ClassLevel.TIME_OUT)
    println(AppLevel.API_CONFIG.BASE_URL)
}
