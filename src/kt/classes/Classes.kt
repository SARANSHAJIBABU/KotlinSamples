package kt.classes

fun main(args:Array<String>){
    val a = A()
    val b = B()
    val d = D5("Saran")
    var e = D6("Saran")
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