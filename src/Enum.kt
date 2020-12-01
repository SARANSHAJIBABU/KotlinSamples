enum class AccType{
    GOLD,PLATINUM,SILVER,DIAMOND
}

enum class AccType2(val discountPercent: Int){
    GOLD(5),
    PLATINUM(10)
}

enum class AccType3{
    GOLD {
        override fun calculateDiscount() = 5
    },
    PLATINUM {
        override fun calculateDiscount() = 2
    };

    abstract fun calculateDiscount(): Int
}

enum class AccType4{
    GOLD,PLATINUM;

    companion object {
        fun getAccTypeByName(name: String) = valueOf(name)
    }
}

enum class Color{
    V,I,B,G,Y,O,R
}



fun main(){
    val fromApi = "gold"
    val acc = AccType.valueOf(fromApi.toUpperCase()) //Throws IllegalArgumentException if dont match
    println(acc == AccType.GOLD)

    println(AccType2.GOLD.discountPercent)
    AccType2.values().forEach {
        println(it.discountPercent)
    }

    println(AccType3.GOLD.calculateDiscount())

    val type = AccType4.getAccTypeByName(fromApi.toUpperCase())

}
