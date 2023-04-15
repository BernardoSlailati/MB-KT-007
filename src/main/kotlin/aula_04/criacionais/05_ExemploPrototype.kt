package aula_04.criacionais

interface Shape: ShapePrototype {
    val x: Int
    val y: Int
    val color: String
}

interface ShapePrototype {
    fun clone(): Shape
}

// Rectangle e Circle

data class Rectangle(
    val width: Int,
    val height: Int,
    override val x: Int,
    override val y: Int,
    override val color: String
): Shape {

    constructor(source: Rectangle) : this(
        source.width,
        source.height,
        source.x,
        source.y,
        source.color
    )

    override fun clone(): Shape {
        return Rectangle(this)
    }

}

data class Circle(
    val radius: Int,
    override val x: Int,
    override val y: Int,
    override val color: String
): Shape {

    constructor(source: Circle) : this(
        source.radius,
        source.x,
        source.y,
        source.color
    )

    override fun clone(): Shape {
        return Circle(this)
    }

}

data class Triangle(val size: Int, val color: String)


object ShapeRegistry {

    private val cache: MutableMap<String, Shape> = hashMapOf()

    fun addItem(id: String, shape: Shape) {
        cache[id] = shape
    }

    fun getById(id: String): Shape? =
        try {
            cache[id]?.clone()
        } catch (e: Exception) {
            null
        }

    fun getByColor(color: String): Shape? {
        cache.forEach { item ->
            if (item.value.color == color)
                return item.value.clone()
        }
        return null
    }

}

fun main() {

    val redCircle = Circle(
        radius = 8,
        x = 1,
        y = 1,
        color = "red"
    )

    val greenRectangle = Rectangle(
        width = 10,
        height = 5,
        x = 1,
        y = 1,
        color = "green"
    )

    val blueRectangle = Rectangle(
        width = 10,
        height = 5,
        x = 1,
        y = 1,
        color = "blue"
    )

    val redCircleClone: Circle = redCircle.clone() as Circle
    val greenRectangleClone = greenRectangle.clone() as Rectangle


    val greenTriangle = Triangle(size = 4, color = "green")
    val greenTriangleClone = greenTriangle.copy(size = 3)

    with(ShapeRegistry) {
        addItem(id = "Círculo Vermelho", shape = redCircle)
        addItem(id = "Retângulo Verde", shape = greenRectangle)
        addItem(id = "Retângulo Azul", shape = blueRectangle)

        println(getByColor("green"))
        println(getById("Círculo Branco"))
        println(getById("Retângulo Verde"))
    }

}

