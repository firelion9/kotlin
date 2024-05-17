interface Content

class IconContent(val icon: Icon) : Content

class Icon

class Button(val content: Content, val textColor: Color)
