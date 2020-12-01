import Color.*
import java.lang.IllegalArgumentException

fun getDescription(type: AccType) =
    when(type){
        AccType.GOLD -> "Gold"
        AccType.PLATINUM -> "PLATINUM"
        AccType.SILVER -> "SILVER"
        AccType.DIAMOND -> "DIAMOND"
    }

fun getDescription3(type: AccType) =
    when(type){
        AccType.PLATINUM,AccType.DIAMOND -> "Premium"
        AccType.GOLD  -> "Classic"
        else -> "Ordinary"
    }

//'when' with arbitrary objects
fun mix(color1: Color, color2: Color) =
        when(setOf(color1,color1)){
            setOf(R, Y) -> O
            setOf(Y, B) -> G
            setOf(B, V) -> I
            else -> throw IllegalArgumentException()
        }

//when' without an argument
fun mix2(color1: Color, color2: Color) =
        when{
            color1==R && color2==Y -> O
            color1==Y && color2==B -> G
            color1==B && color2==V -> I
            else -> throw IllegalArgumentException()
        }

fun main(){
    println(getDescription(AccType.GOLD))

    println(getDescription(AccType.PLATINUM))
}
