package kt.classes

fun main(args:Array<String>){
    val a = A()
    val b = B()
    val d = D5("Saran")
    var e = D6("Saran")
    var f = D8("Saran",31)

    println(f.firstName+f.age+f.isAdult)
    f.age =32
}
/*By default Kotlin classes are public & final*/

/*Allowed in kt. Can be accessed within the file*/
private class A

/*Visibility is within the same module(Compilation unit) - internal*/
internal class B

/*Default visibility is public*/
class C

/*Java way of defining a class, where we create property name and assign n to it
* init{} runs concurrent to primary constructor, since primary constructor doesnt allow to
* do any initialization*/
class D1 constructor(n:String){
    val name:String
    init{
        this.name = n
    }
}

/*Kotlin way of defining a class where property name is generated from constructor*/
class D2(val name:String)

/*By default constructor keyword can be omitted. If using annotation/access specifier, need to specify constructor keyword*/
class D3 protected constructor(val name:String)

/*Secondary constructor
* Secondary constructor must invoke primary constructor if any available
* It follows normal java way*/
class D4(val firstName:String){
    var fullTime:Boolean = true
    constructor(fname:String,fTime:Boolean):this(fname){
        fullTime = fTime
    }

    /*
    Cant declare val/var directly in secondary constructor, since kt wont generate properties for it
    constructor(fname:String,val fTime:Boolean):this(fname){ ==> val/var fTime not allowed
    }
* */
}

//Default param value in primary constructor to replace secondary constructor
class D6(val firstName:String,var fullTime:Boolean = true)

/*Class with only secondary constructor*/
/*Default value in secondary constructors are allowed*/
class D5{
    val name:String
    var fullTime:Boolean

    /*Default value in secondary constructors are allowed*/
    constructor(n:String,fTime:Boolean=false){
        this.name = n
        this.fullTime = fTime
    }

}

//Non public member variable => internal
class D7(val firstName:String,internal var fullTime:Boolean = true)

//For all non private params mentioned in primary constuctor, kt will treat it as properties & auto generate getters and setters
//If you need custom getters/setters, you cant declare it as properties (val/var) in primary constructor, it should be
//inside class

class D8(val firstName:String,age:Int){ //age:Int => not property
    var age = age //declared in class. Custom get/set should happen immediately after this line
    get(){
        println("Returning age"+field)
        return field
    }
    set(value){
        field = value
        println("setting age"+field)
    }

    var isAdult = false //declared in class
    get(){//declared in class. Custom get/set should happen immediately after this line
        println("Returning isAdult")
        return age>18
    }
}
