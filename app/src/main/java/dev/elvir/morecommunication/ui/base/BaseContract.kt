package dev.elvir.morecommunication.ui.base


interface Presenter<in T> {
    fun onAttach(view: T)
}

interface View {

}