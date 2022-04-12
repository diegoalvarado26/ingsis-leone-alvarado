package parser.ast.branches;

import lombok.Builder;
import lombok.Getter;
import org.austral.ingsis.printscript.common.Token;
import parser.ast.AbstractSyntaxTree;
import parser.ast.leaves.VoidSyntaxLeaf;

@Builder
@Getter

public abstract class AbstractSyntaxBranch implements AbstractSyntaxTree {
   // En principio tendríamos una para cada tipo (e.g. println, suma, etc)
    Token token;
    AbstractSyntaxTree left = new VoidSyntaxLeaf();
    AbstractSyntaxTree right = new VoidSyntaxLeaf();

    @Override
    public boolean isEmpty(){
        return false;
    }

    // Busca si la derecha esta vacía y agrega el AST que se le pasa. Sino se lo agrega al lado derecho del ya existente
    public void addRight(AbstractSyntaxTree tree) {
       if (this.right.isEmpty()) {
           this.right = tree;
       } else {
           right = right.add(tree);
       }
    }

    public void addLeft(AbstractSyntaxTree tree) {
       if (this.left.isEmpty()) {
            this.left = tree;
        } else {
            left = left.add(tree);
        }
    }
}
