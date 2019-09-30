package interpreter

open class ASTNode {
    var LineIndex: Int = 0
    var text: String = ""
}

class seqNode(numNodes: Int): ASTNode()  {
    val nodes: Array<ASTNode?> = Array(numNodes) {i -> null}

    private var curNodeIndex = 0

    val curNode: ASTNode? //todo: test, possible bug
        get() = nodes[curNodeIndex]

    fun advance() {
        curNodeIndex += 1
    }
}

class opNode(LineIndex: Int, text: String) : ASTNode(LineIndex, text) {

}

class binOp: opNode {
    op: eBinOp
    arg1, arg2: ASTNode
}

class unOp: opNode {
    op: eUnOp
    arg: ASTNode
}

class AbstractSyntaxTree {
    val root: seqNode
}