abstract class Car(val color: String, val numWheels: Int) {

    fun start() = println("Starting...")

    fun stop() = println("Stopping...")

    abstract fun drive()
}

abstract class SportsCar(color: String, numWheels: Int): Car(color,numWheels){

    override fun drive() = driveFast()

    abstract fun driveFast()
}

class Lambo: SportsCar("Black", 4){
    override fun driveFast() {
       println("Driving Fasterrrrrrrr")
    }
}

class Ferrari: SportsCar("Red",4){
    override fun driveFast() {
        println("Driving Fast...........")
    }
}

fun main(){
    testDrive(Lambo())
    testDrive(Ferrari())
}

fun testDrive(cars: ArrayList<Car>){
    cars.forEach{
        it.drive()
    }
}


fun testDrive(car: Car){
    car.drive()
}
