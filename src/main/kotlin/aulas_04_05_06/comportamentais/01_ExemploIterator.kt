package aulas_04_05_06.comportamentais

// iterador para ler de forma reversa os itens de uma lista
class ReversedList<T>(vararg elements: T) : Iterator<T> {

    private val list = elements.asList()

    private val size = elements.size
    private var currentPos = size

    override fun hasNext(): Boolean {
        return (currentPos - 1 >= 0)
    }

    override fun next(): T {
        return if (hasNext()) {
            currentPos--
            list[currentPos]
        } else
            throw IndexOutOfBoundsException()
    }

}

fun main() {

    val reversedListInt = ReversedList(1, 2, 3, 4, 5)
    val reversedListString = ReversedList("a", "b", "c", "d", "e")

    while (reversedListInt.hasNext()) {
        println(reversedListInt.next())
    }

    val list = listOf(1, 2, 3)
    list.iterator()
    val mutableList = mutableListOf(1, 2, 3)
    mutableList.iterator()
    val hashMap = hashMapOf(1 to 1)
    hashMap.iterator()
    val mutableSet = mutableSetOf(1, 2, 3)
    mutableSet.iterator()

}

