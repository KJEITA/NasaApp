package bonch.dev.nasaapp

interface MainContract {
    interface View {
        fun showAll()
    }

    interface Presenter {
        fun onItemWasClicked()
        fun onDestroy()
    }

    interface Model{

    }
}