import java.lang.AssertionError

data class Person(val first: String, val last: String, val age: Int, var salary: Int) {

    //immutable property must have type & default getter and mutable must have setter also
    val BONUS_PERCENT = 0.1

    val fullName: String
        get() = "$first $last"

    var nationality: String = "SG"
        get() = "nationality is $field"                     //Custom Getter with backing field
        set(value) {                                         //Custom Setter with backing field
            if (value.isNotEmpty() && value != field) field = value
        }

    val isAdult: Boolean                            //Custom Getter
        get() = age > 17

    var grossSalary: Double = 0.0
        get() = salary + salary * BONUS_PERCENT
        private set                                 //Private setter prevent outside classes modify the field



    //Backing property
    private var _map: MutableMap<String, Int>? = null //Nullable
    val map: MutableMap<String, Int> //Non nullable
    get(){
        if(_map == null){
            _map = HashMap()
        }
        return _map?: throw AssertionError("Set to null by another thread")
    }


}

fun main() {

    val p = Person("Saran", "Babu", 32, 1000)
    println(p)
    println(p.fullName)
    p.nationality = "IN"
    println(p.nationality)
    println(p.isAdult)
    println(p.grossSalary)
    p.salary = 2000
    println(p.grossSalary)
    p.map.set("Pin", 521869)

}

