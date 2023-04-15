package aulas_03_04_05.criacionais

data class House(
    val walls: Int,
    val doors: Int,
    val windows: Int,
    val roofType: String,
    val garageCarAmount: Int
) {

    class Builder {

        private var walls: Int = 0
        private var doors: Int = 0
        private var windows: Int = 0
        private var roofType: String = ""
        private var garageCarAmount: Int = 0

        fun buildWalls(walls: Int) = apply {
            this.walls = walls
        }

        fun buildDoors(doors: Int) = apply {
            this.doors = doors
        }

        fun buildWindows(windows: Int) = apply {
            this.windows = windows
        }

        fun buildRoof(roofType: String) = apply {
            this.roofType = roofType
        }

        fun buildGarage(garageCarAmount: Int) = apply {
            this.garageCarAmount = garageCarAmount
        }

        fun build(): House {
            return House(
                walls = walls,
                doors = doors,
                windows = windows,
                roofType = roofType,
                garageCarAmount = garageCarAmount
            )
        }

    }


}

fun main() {

    val house: House = House.Builder()
        .buildWalls(8)
        .buildRoof("Telhas")
        .buildGarage(1)
        .buildDoors(6)
        .build()

    println(house)

}

