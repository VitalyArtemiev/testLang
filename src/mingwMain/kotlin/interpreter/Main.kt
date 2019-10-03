package interpreter
import logger.Logger

var terminalsPath: String = " "
var nonTerminalsPath: String = " "

fun main(args: Array<String>) {
    val logger = Logger("main")

    var pathIndices: Int

    var terminalsText: String? = try {
        val termIndex = args.indexOf("-t") + 1
        terminalsPath = args[termIndex]
        File(terminalsPath).readText()
    } catch (e: IndexOutOfBoundsException) {
        logger.e("terminalsPath arg not found")
        null
    } catch (e: NoSuchFileException ) {
        null
    }

    try {
        val nonTermIndex = args.indexOf("-nt") + 1
        nonTerminalsPath = args[nonTermIndex]
    } catch (e: IndexOutOfBoundsException) {
        logger.e("nonTerminalsPath arg not found")
    }

    var path = "sourceExample"

    val l = Lexer(path)

    var tokens = l.lex()

    val p = Parser(tokens)
}