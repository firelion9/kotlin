fun textColor(d: Decoration): Color = when (d) {
    is Colors -> d.textColor
    else -> error("unlucky")
}