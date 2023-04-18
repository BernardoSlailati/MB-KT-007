package aulas_04_05_06.criacionais

open class Carro
open class CarroCombustivel: Carro()
open class CarroEletrico: Carro()


interface FabricaCarro {
    fun contruirCarroCombustivel(): CarroCombustivel
    fun construirCarroEletrico(): CarroEletrico
}


class FabricaToyota: FabricaCarro {

    private class Carolla: CarroCombustivel()
    private class Prius: CarroEletrico()

    override fun contruirCarroCombustivel(): CarroCombustivel {
        return Carolla()
    }

    override fun construirCarroEletrico(): CarroEletrico {
        return Prius()
    }

}


class FabricaChevrolet: FabricaCarro {

    private class Onix: CarroCombustivel()
    private class Bolt: CarroEletrico()

    override fun contruirCarroCombustivel(): CarroCombustivel {
        return Onix()
    }

    override fun construirCarroEletrico(): CarroEletrico {
        return Bolt()
    }

}


fun main() {

    val fabricaToyota = FabricaToyota()
    val fabricaChevrolet = FabricaChevrolet()

    val carroCombustivelToyota = fabricaToyota.contruirCarroCombustivel()
    val carroCombustivelChevrolet = fabricaChevrolet.contruirCarroCombustivel()


    val carroEletricoToyota = fabricaToyota.construirCarroEletrico()
    val carroEletricoChevrolet = fabricaChevrolet.construirCarroEletrico()


    println(carroCombustivelToyota)
    println(carroCombustivelChevrolet)
    println(carroEletricoToyota)
    println(carroEletricoChevrolet)

}