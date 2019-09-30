package interpreter

class Parser (val TokenList: ArrayList<Token>) {
    var currentToken: Token = TokenList.first()

    fun parse(): AbstractSyntaxTree {

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