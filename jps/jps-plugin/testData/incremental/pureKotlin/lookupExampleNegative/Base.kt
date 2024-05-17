open class Base(private val x: String) {
    constructor(x: Int) : this(x.toString())
}
