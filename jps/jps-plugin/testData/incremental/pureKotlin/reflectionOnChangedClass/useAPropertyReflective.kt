package foo

fun useAProperty() {
    val a = createA()
    val prop = a::x
    println(prop())
}