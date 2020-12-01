// Since primary constructor dont allow to write code, init helps to do that
//Initializer blocks becomes part of the primary constructor and executes after primary constructor

class InitOrderDemo(n: String){ //Note no val

    val name = "Name is $n".also { println(it) }

    init {
        println("In init block1, $name ")
    }

    val length = "Length is ${n.length}".also { println(it) }

    init {
        println("In init block2 $name $length")
    }

}

class InitOrderDemo2(val name: String){
    init {
        println("In init block1, name is $name")
    }
}

fun main(){

    InitOrderDemo("Obama")
    InitOrderDemo2("Obama")
}
