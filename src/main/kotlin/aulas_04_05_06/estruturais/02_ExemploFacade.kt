package aulas_04_05_06.estruturais

import aulas_04_05_06.estruturais.Format.AVI
import aulas_04_05_06.estruturais.Format.MP4

class VideoConverter {

    fun convertVideo(filename: String, format: Format) : File {
        val file = VideoFile(filename)

        val sourceCodec: Codec = CodecFactory.extract(file)
        val destinationCodec: Codec = CodecFactory.create(format)

        val buffer = BitrateReader.read(filename, sourceCodec)
        val result = BitrateReader.convert(buffer, destinationCodec)

        val fixedVideoAudio = AudioMixer.fix(result)

        return File(fixedVideoAudio)
    }

}


open class Codec
// Outros
class OggCompressionCodec : Codec()
// MP4
class MPEG4CompressionCodec : Codec()
// AVI
class MJPEGCompressionCodec : Codec()

class File(buffer: ByteArray)

enum class Format {
    MP4,
    AVI
}

object BitrateReader {
    fun read(filename: String, codec: Codec): ByteArray {
        // ...
        return ByteArray(1024)
    }
    fun convert(buffer: ByteArray, codec: Codec) : ByteArray {
        // ...
        return ByteArray(1024)
    }
}

object AudioMixer {
    fun fix(buffer: ByteArray): ByteArray {
        // ...
        return buffer
    }
}

class VideoFile(filename: String)
object CodecFactory {
    fun extract(file: VideoFile): Codec {
        return Codec()
    }

    fun create(format: Format): Codec {
        return when(format) {
            MP4 -> MPEG4CompressionCodec()
            AVI -> MJPEGCompressionCodec()
            else -> OggCompressionCodec()
        }
    }
}

fun main() {

    val videoConverter = VideoConverter()
    val convertedVideo =
        videoConverter.convertVideo("my_video.avi", MP4)

}