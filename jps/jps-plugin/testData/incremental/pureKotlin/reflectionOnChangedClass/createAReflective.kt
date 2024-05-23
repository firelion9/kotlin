package foo

fun createA(): A {
    val constructor: () -> A = ::A
    return constructor()
}