package aulas_03_04_05.estruturais

interface Notifier {
    fun send(message: String)
}

class EmailNotifier : Notifier {
    override fun send(message: String) {
        println("Enviando email... `$message`")
    }
}

open class NotifierDecorator(private val source: Notifier) : Notifier {
    override fun send(message: String) {
        source.send(message)
    }
}

class SMSDecorator(source: Notifier) : NotifierDecorator(source) {
    override fun send(message: String) {
        super.send(message)
        println("Enviando SMS... `$message`")
    }
}

class FacebookDecorator(source: Notifier) : NotifierDecorator(source) {
    override fun send(message: String) {
        super.send(message)
        println("Enviando Facebook... `$message`")
    }
}

class SlackDecorator(source: Notifier) : NotifierDecorator(source) {
    override fun send(message: String) {
        super.send(message)
        println("Enviando Slack... `$message`")
    }
}

fun String.validateCpf(): Boolean {
    return this.length == 11
}

fun main() {

    val funciarioXNotificador = NotifierDecorator(
        SMSDecorator(
            EmailNotifier()
        )
    )

    val funciarioYNotificador = NotifierDecorator(
        FacebookDecorator(
            SlackDecorator(
                EmailNotifier()
            )
        )
    )

    val funciarioZNotificador = NotifierDecorator(
        FacebookDecorator(
            SlackDecorator(
                SMSDecorator(
                    EmailNotifier()
                )
            )
        )
    )

    funciarioZNotificador.send("Olá Funcionário Z!")

}