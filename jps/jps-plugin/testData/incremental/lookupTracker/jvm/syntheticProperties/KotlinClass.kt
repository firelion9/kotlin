package foo

/*p:<root>(JavaClass)*/import JavaClass

class KotlinClass : /*p:<root> p:foo*/JavaClass() {
    override fun getFoo() = 2
    fun setFoo(i: /*p:foo*/Int) {}
}
