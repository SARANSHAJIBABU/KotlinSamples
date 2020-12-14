package generics

open class Animal(val id: Int, val name: String, val breed: String)
class Dog( id: Int, name: String, breed: String = "DogBreed"): Animal(id,name,breed)

class Cat( id: Int,  name: String,  breed: String = "CatBreed"): Animal(id,name,breed)

class Cage(var dog: Dog, val size: Double)


fun main(){

    val dog = Dog(1, "Dog1")
    val cage = Cage(dog, 6.0)

    val cat = Cat(2, "Cat1")

    //In this cage we cant place the cat. So we need a generic Cage class

    val genericDogCage = GenericCage<Dog>(dog, 6.0)
    val genericCatCage = GenericCage<Cat>(cat, 4.0)

    //With GenericCage, we can place both Dog and Cat
    //But GenericCage has a problem

    val genericStringCage = GenericCage<String>("", 0.0)
    //GenericCage wont check inmate, so we can place anything


    val genericBoundedDogCage = GenericBoundedCage<Dog>(dog, 6.0)
    val genericBoundedCatCage = GenericBoundedCage<Cat>(cat, 6.0)

    //With GenericBoundedCage, once cat create GenericBoundedCage<String>


    var animal: Animal = Dog(11,"Dog11")
    var dog22: Dog = Dog(22,"Dog22")
    animal = dog22   //Valid because of polymorphism, dog is a subtype of animal

    var cageAnimal: GenericBoundedCage<Animal>
    var cageDog = GenericBoundedCage<Dog>(dog22, 6.5)
    //cageAnimal = cageDog   This wont work GenericBoundedCage<Dog> is not subtype of GenericBoundedCage<Animal>
    //Eventhough dog is a subtype of animal, GenericBoundedCage<Dog> is not subtype of GenericBoundedCage<Animal>

    //Reason for this is
    //If kotlin had allowed GenericBoundedCage<Dog> is not subtype of GenericBoundedCage<Animal>
    /*
    var cageAnimal: GenericBoundedCage<Animal>
    var cageDog = GenericBoundedCage<Dog>(dog22, 6.5)
    cageAnimal = cageDog

    var cat11 = Cat(11, "Cat11")
    cageAnimal.inmate = cat11
    val dog: Dog = cageAnimal.inmate  ==> Class cast exception. Dog cant be casted to a cat

    * */
    // GenericBoundedCage<Animal> object would be holding a reference to a GenericBoundedCage<Dog>.
    // Then, a careless developer could try including a Cat into cageAnimal,
    // dismissing the fact that it actually refers to cageDog.
    //Hence only problem with generic subtyping occur, only when we tried to modify assignment of GenericBoundedCage<Animal>
    //cageAnimal.inmate = cat11

    //The only reason why compiler dont allow cageAnimal = cageDog is, some dev can modify cageAnimal, cageAnimal.inmate = cat11
    //One solution here is we allow cageDog to be a subtype of cageAnimal and dont allow to modify cageAnimal
    //


    var animalCage: CovariantCage<Animal>
    var dogCage: CovariantCage<Dog> = CovariantCage(dog)
    animalCage = dogCage
    //out from CovariantCage is a reserved kt keyword, assures compiler T is an output [other than constructor]
    //and nobody is able to change that. This solves changing inmate dog with cat in the above scenario


    //With Contravariance [in], CovariantCage<Animal> is a subtype of CovariantCage<Dog>
    //in from contravariance is a reserved kt keyword,  assures compiler T is an input for class methods
    //and wont output it at all
}




class GenericCage<T>(var inmate: T, val size: Double)

class GenericBoundedCage<T:Animal>(var inmate: T, val size: Double)

class CovariantCage<out T: Animal>(private val t: T){
    fun getId(): Int = t.id
    fun getName(): String = t.name
    fun getContentType():T = t
    fun printAnimalInfo() = "Animal ${getId()} is called ${getName()}"
}


//With Contravariance [in], CovariantCage<Animal> is a subtype of CovariantCage<Dog>
class ContravariantCage<in T : Dog>(private var t: T){
    fun getId(): Int? = t.id
    fun getName(): String = t.name
    fun setContentType(t:T){ this.t = t}
    fun printAnimalInfo(): String = "Animal ${t?.id} is called ${t?.name}"
}

