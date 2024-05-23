package foo

open class A
class B : /*p:foo*/A()

fun getA() = /*p:foo*/A()
fun getB() = /*p:foo*/B()

fun getListOfA() = /*p:foo p:foo(A) p:kotlin.collections p:kotlin.collections(List)*/listOf(/*p:foo*/A())
fun getListOfB() = /*p:foo p:foo(B) p:kotlin.collections p:kotlin.collections(List)*/listOf(/*p:foo*/B())

fun useListOfA(a: /*p:foo p:foo(A) p:kotlin.collections*/List</*p:foo*/A>) {}
fun useListOfB(b: /*p:foo p:foo(B) p:kotlin.collections*/List</*p:foo*/B>) {}

fun testInferredType() {
    /*p:foo*/useListOfA(/*p:foo p:foo(A) p:kotlin.collections(List)*/getListOfA())
    /*p:foo*/useListOfA(/*p:foo p:foo(B) p:kotlin.collections(List)*/getListOfB())
    /*p:foo*/useListOfB(/*p:foo p:foo(B) p:kotlin.collections(List)*/getListOfB())
}
