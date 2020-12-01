internal data class Person1(val name: String) //internal can be accessed only within the module

class Society{

    private lateinit var person1: Person1 //public/protected would show error. Only private/internal is allowed

    fun createPerson(name: String){
        person1 = Person1(name)
        print(person1)
    }
}

fun main(){
    Society().createPerson("Person")
}
