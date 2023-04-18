package aulas_04_05_06.criacionais

import aulas_04_05_06.criacionais.ConfirmDialogType.*

open class Dialog(
    val icon: String,
    val title: String,
    val subtitle: String,
    val yesAction: () -> Unit,
    val noAction: () -> Unit
)

class ConfirmCreatedMessageDialog : Dialog(
    icon = "ic_add",
    title = "Deseja realmente criar essa mensagem?",
    subtitle = "Ao confirmar, a mensagem será enviada automaticamente.",
    yesAction = { println("Mensagem enviada!") },
    noAction = { println("Cancelado envio da mensagem.") }
)

class ConfirmDeletedMessageDialog : Dialog(
    icon = "ic_delete",
    title = "Deseja realmente deletar essa mensagem?",
    subtitle = "Ao confirmar, a mensagem será excluída automaticamente.",
    yesAction = { println("Mensagem excluída!") },
    noAction = { println("Cancelada a ação de deletar a mensagem.") }
)

class ConfirmEditedMessageDialog(editedMessage: String) : Dialog(
    icon = "ic_edit",
    title = "Deseja realmente editar essa mensagem?",
    subtitle = "\"$editedMessage\"",
    yesAction = { println("Mensagem editada!") },
    noAction = { println("Cancelada a ação de editar a mensagem.") }
)

sealed class ConfirmDialogType {
    object Created : ConfirmDialogType()
    object Deleted : ConfirmDialogType()
    class Edited(val editedMessage: String) : ConfirmDialogType()
}

object ConfirmDialogFactory {

    fun createDialog(confirmDialogType: ConfirmDialogType): Dialog {
        return when (confirmDialogType) {
            Created -> ConfirmCreatedMessageDialog()
            Deleted -> ConfirmDeletedMessageDialog()
            is Edited -> ConfirmEditedMessageDialog(editedMessage = confirmDialogType.editedMessage)
        }
    }

}

fun main() {

    val confirmCreatedMessageDialog = ConfirmDialogFactory.createDialog(confirmDialogType = Created)
    val confirmDeletedMessageDialog = ConfirmDialogFactory.createDialog(confirmDialogType = Deleted)
    val confirmEditedMessageDialog =
        ConfirmDialogFactory.createDialog(confirmDialogType = Edited(editedMessage = "Olá Mundo!"))

    val listConfirmDialogs = listOf(
        confirmCreatedMessageDialog,
        confirmDeletedMessageDialog,
        confirmEditedMessageDialog
    )

    listConfirmDialogs.forEach {
        println(it.title + "\n" + it.subtitle)
        println("\n\n")
    }

}
