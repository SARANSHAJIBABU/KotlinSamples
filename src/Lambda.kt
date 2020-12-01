fun main(){
    print {
        println("Hello World")
    }

    printWithArg { a, b -> println("Hello $a $b") }

    listFilter()
}


fun print(noArg: ()->Unit){
    noArg()
}

fun printWithArg (withArg:(a:String, b:String)->Unit){
    withArg("Saran", "Babu")
}

fun withArgAndReturn(withArgAndReturn: (name: String)-> String){
    val result = withArgAndReturn("Saran Babu")
    println(result)
}

fun withArgAndReturn2(withArgAndReturn: (name: String, address: String) -> String){
    val result = withArgAndReturn("Saran Babu","")
    println(result)
}

fun listFilter(){
    val listOfInts = (1..10).toList()
    val sum = listOfInts.customSum {
        it < 6
    }
    println(sum)
}

private fun List<Int>.customFilter(filterFunc: (Int) -> Boolean): List<Int>{
    val filteredList = mutableListOf<Int>()

    for(item in this){
        if(filterFunc(item)){
            filteredList.add(item)
        }
    }
    return filteredList
}

private fun List<Int>.customSum(predicate: (Int)-> Boolean): Int{
    val filterdList = mutableListOf<Int>()

    for(item in this){
        if(predicate(item)){
            filterdList.add(item)
        }
    }
    return filterdList.sum()
}
