package interpreter

open class stackNode {
    companion object {
        var lastId: Long = 0
        fun getUniqId(): Long {
            return lastId ++
        }
    }
}

class scopeDelimiter: stackNode()

open class identifier(name: String):stackNode() {
    var id = getUniqId()
}

class constant(val name: String, val value: Number): identifier(name ) {

}

class variable(val name: String, val value: Number): stackNode() {

}



class Parser (val TokenList: ArrayList<Token>) {
    var curTokenIndex: Int = 0

    fun peek() = TokenList[curTokenIndex]

    fun next(): Token {
        val result = TokenList[curTokenIndex]
        curTokenIndex++
        return result
    }

    private var checkPointIndex: Int = 0
    fun checkPoint() {
        checkPointIndex = curTokenIndex
    }

    fun revert(): Token {
        curTokenIndex = checkPointIndex
        return TokenList[curTokenIndex]
    }


    fun parse(TokenList: ArrayList<Token>): AbstractSyntaxTree {
        program()

    }

    fun several(f: () -> Unit, expected: Array  <Token>) {
        var t = next()
        while (expected.contains(t)) {
            //f.invoke()
            f()
            t = next()
        }
    }

    fun program() {

    }

    fun block() {
        consume(tokenTypeEnum.startBlock)
        several( statement,  )

        consume(tokenTypeEnum.endBlock)
    }

    fun statement() : Unit {

    }

    fun function() {

    }

    val AST: AbstractSyntaxTree =

}

class Crawler (startNode: ASTNode) {
    val nodeStack: MutableList<ASTNode> = listOf(startNode).toMutableList()

    val curNode: ASTNode
        get() {
           return nodeStack.last()
        }

    fun fuckGoBack() {
        nodeStack.removeAt(nodeStack.size - 1)
    }
}