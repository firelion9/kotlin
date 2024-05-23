package foo

class C

fun lambdaConsumer(fn: /*p:foo(A) p:kotlin(Function1)*/(/*p:foo*/A)->/*p:foo*/Unit) {}
fun extensionConsumer(fn: /*p:foo p:kotlin(Function1)*/A.()->/*p:foo*/Unit) {}

fun testLambdaParameterType() {
    /*p:foo*/lambdaConsumer /*p:foo(A) p:kotlin(Function1)*/{ /*p:foo(A)*/it }
    /*p:foo*/extensionConsumer /*p:foo(A) p:kotlin(Function1)*/{ this }
}
