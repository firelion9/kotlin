fun Explicit() {
    /*p:<root> p:MainClass(Companion)*/MainClass./*p:MainClass*/Companion
}

fun ExplicitMethod() {
    /*p:<root> p:<root>(f) p:MainClass(Companion) p:MainClass(f) p:MainClass.Companion(f)*/MainClass./*p:MainClass*/Companion.f()
}

fun Implicit() {
    /*p:<root> p:MainClass(Companion)*/MainClass
}

fun ImplicitMethod() {
    /*p:<root> p:<root>(f) p:MainClass(Companion) p:MainClass(f) p:MainClass.Companion(f)*/MainClass.f()
}

fun InstanceExplicit() {
    val t = /*p:<root> p:MainClass(Companion)*/MainClass./*p:MainClass*/Companion
}

fun Type(t: /*p:<root> p:MainClass(Companion)*/MainClass.Companion) {

}
