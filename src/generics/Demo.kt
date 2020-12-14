package generics

class CageV2<T: Animal>(val animal: T)

interface Repository<S:CageV2<Animal>>{
    fun registerCage(cage:S): Unit
}

class AnimalRepository:Repository<CageV2<Animal>>{
    override fun registerCage(cage: CageV2<Animal>) {
    }
}

/*class DogRepository: Repository<CageV2<Dog>>{
    override fun registerCage(cage: CageV2<Dog>) {
    }

}*/
//Results in compilation error since CageV2<Dog> is not a subtype of CageV2<Animal>


//This can be fixed by adding out T, which ensures animal or its subtypes wont be modified
class CageV3<out T: Animal>(val animal: T)

interface RepositoryV3<S:CageV3<Animal>>{
    fun registerCage(cage:S): Unit
}

class DogRepository: RepositoryV3<CageV3<Dog>>{
    override fun registerCage(cage: CageV3<Dog>) {
    }
}
