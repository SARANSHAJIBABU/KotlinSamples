class Person2(
    val name: String, //Read-only property: generates a field and a getter
    val age: Int,
    var employed: Boolean //Writable property: a field, a getter, and a setter
){
    val isAdult: Boolean
        get(){
            return age>18
        }
}
