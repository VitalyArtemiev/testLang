package logger

import com.soywiz.klock.DateTime

class Logger (val obj: Any? = null, val name: String = "", var showTime: Boolean = true, var showName: Boolean = true) {
    val logName = {
        if (obj != null) {
            obj::class.simpleName
        }
        else
            name
    }
    fun i(message: String) {
        val s = construct(message)
        println("[INFO]@$s")
    }

    fun e(message: String) {
        val s = construct(message)
        println("[ERROR]@$s")
    }

    fun d(message: String) {
        val s = construct(message)
        println("[DEBUG]@$s")
    }

    fun l(message: String) {
        val s = construct(message)
        println(s)
    }

    fun construct(message: String): String {
        var result = ""
        if (showTime) {
            result +=  DateTime.nowLocal().toString("h:m:s") + " - "
        }

        if (showName) {
            result += "$logName - "
        }

        result += message
        return result
    }

    fun p(message: String){
        println(message)
    }
}