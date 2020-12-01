class Book(val name: String, val author: String)

class EnhancedBook(val name: String, vararg val authors: String){
    init{
        authors.forEach {
            println(it)
        }
    }
}

fun main(){

    // Book with single author
    Book("Davinci Code", "Dan Brown")

    // Book that can support multiple authors
    EnhancedBook("Name", "Author1", "Author2","Author3")

}
