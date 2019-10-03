package interpreter

import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.toKString
import platform.posix.F_OK
import platform.posix.*

import logger.Logger

data class File(private val fileName: String) {
    val logger = Logger(this)
    fun exists(): Boolean {
        return access(fileName, F_OK) != -1
    }

    fun readText(): String {
        val file = fopen(fileName, "r")
        if (file == null) {
            val errorText = "cannot open input file $fileName"
            logger.e(errorText)
            throw NoSuchFileException(errorText)
        }

        return try {
            var sb: String = ""
            memScoped {
                val bufferLength = 64 * 1024
                val buffer = allocArray<ByteVar>(bufferLength)

                do {
                    val nextLine = fgets(buffer, bufferLength, file)?.toKString()
                    sb += nextLine
                } while (nextLine == null || nextLine.isEmpty())
            }
            sb
        } finally {
            fclose(file)
        }
    }
    // More functions...
}

class NoSuchFileException(message: String?): Exception(message)
class AccessDeniedException(message: String?): Exception(message)