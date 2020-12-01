class DIClass{

    //Tells compiler this value will be initialized later.
    // If not UninitializedPropertyAccessException will be thrown
    lateinit var country: String

    //this::property.isInitialized will check whether property is initialized or not
    fun isSingaporean() =
        this::country.isInitialized && country == "SG"

    //A wrapper function to check property is initialized or not
    fun isCountryAvailable() = this::country.isInitialized


}

fun main(){
    val p = DIClass()

    println(p.isCountryAvailable())

    println(p.isSingaporean())
}
