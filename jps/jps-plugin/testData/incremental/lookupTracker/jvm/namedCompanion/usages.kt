fun Explicit() {
    /*p:<root> p:MainClass(Name)*/MainClass./*p:MainClass*/Name
}

fun ExplicitMethod() {
    /*p:<root> p:<root>(f) p:MainClass(Name) p:MainClass.Name(f)*/MainClass./*p:MainClass*/Name.f()
}

fun Implicit() {
    /*p:<root> p:MainClass(Name)*/MainClass
}

fun ImplicitMethod() {
    /*p:<root> p:<root>(f) p:MainClass(Name) p:MainClass(f) p:MainClass.Name(f)*/MainClass.f()
}

fun InstanceExplicit() {
    val t = /*p:<root> p:MainClass(Name)*/MainClass./*p:MainClass*/Name
}

fun Type(t: /*p:<root> p:MainClass(Name)*/MainClass.Name) {

}
