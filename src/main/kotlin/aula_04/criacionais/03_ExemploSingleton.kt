package aula_04.criacionais

data class Table(val name: String)

object Database {

    private val table1: Table = Table("tabela_1")
    private val table2: Table = Table("tabela_2")
    private val table3: Table = Table("tabela_3")

    fun executeSql(sql: String) {
        print("Comando SQL executado: `$sql`")
    }
}

fun main() {

    Database.executeSql("SELECT * ...")

}