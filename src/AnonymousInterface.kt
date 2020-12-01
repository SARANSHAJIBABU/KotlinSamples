interface OnClickListener{
    fun onClick()
}

abstract class View{

    private lateinit var clickListener: OnClickListener

    fun setOnClickListener(listener: OnClickListener){
        clickListener = listener
    }

    fun click(){
        clickListener.onClick()
    }
}

class Button: View()

fun main(){
    val btn = Button()

    btn.setOnClickListener(object: OnClickListener{
        override fun onClick() {
            println("Clicked")
        }

    })

    btn.click()
}
