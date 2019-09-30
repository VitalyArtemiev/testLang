package interpreter

public enum class tokenTypeEnum {TBD, startBlock, endBlock, openParenthesis, closeParenthesis, value, variableDeclaration,
    variableName, ifStmt, whileStmt, forStmt,  assignOP, plusOP, minusOP, printVarTable}

public data class  Token (val line: Int, var text: String, var tokenType: tokenTypeEnum = tokenTypeEnum.TBD){
    val tokenized: Boolean
        get() = tokenType == tokenTypeEnum.TBD
}

class Lexer(var path: String) {

    fun lex(): ArrayList<Token> {
        var result = ArrayList<Token>()

        for ((i: Int, line: String) in readF(path).withIndex()) {
            result.addAll(getTokens(line, i))
        }

        return result
    }

    fun readF(path: String): List<String> {
        var f = File(path)
        return f.readLines()
    }
}