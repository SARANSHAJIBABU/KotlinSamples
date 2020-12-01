interface Mammal{
    var hasHands: Boolean

    fun walk()

    fun feed(){
        println("Mammals feed")
    }
}

interface Human: Mammal{

    fun think(){
        println("Thinking.......")
    }
}

class Me(override var hasHands: Boolean = true) : Human{
    override fun walk() {
        println("Walking with 2 legs")
    }

}

fun main(){
    val me = Me()
    println(me.hasHands)
    me.think()
    me.walk()
    me.feed()
}
