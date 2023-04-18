package aulas_04_05_06.comportamentais

interface MusicPlayerState {
    fun play()
    fun pause()
    fun stop()
}

class PlayingState : MusicPlayerState {
    override fun play() {
        println("Música já está tocando!")
    }

    override fun pause() {
        println("Música pausada.")
    }

    override fun stop() {
        println("Parando a música...")
    }

}

class PausedState : MusicPlayerState {
    override fun play() {
        println("Retomando música...")
    }

    override fun pause() {
        println("Música já está pausada!")
    }

    override fun stop() {
        println("Parando a música...")
    }

}

class StoppedState : MusicPlayerState {
    override fun play() {
        println("Iniciando a música...")
    }

    override fun pause() {
        println("A música está parada!")
    }

    override fun stop() {
        println("A música já está parada!")
    }

}


class MusicPlayer {

    private var state: MusicPlayerState = StoppedState()

    private fun changeState(newState: MusicPlayerState) {
        this.state = newState
    }

    fun play() {
        state.play()
        changeState(PlayingState())
    }

    fun pause() {
        state.pause()
        changeState(PausedState())
    }

    fun stop() {
        state.stop()
        changeState(StoppedState())
    }

}

fun main() {

    val musicPlayer = MusicPlayer()

    with(musicPlayer) {
        play()
        pause()
        stop()
        stop()
        pause()
        play()
        play()
    }

}