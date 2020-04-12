package dev.elvir.morecommunication.ext

 fun <R> R?.orElse(block: () -> R): R {
    return this ?: block()
}