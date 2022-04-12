package parser.ast.leaves;

import lombok.Getter;
import lombok.Setter;
import org.austral.ingsis.printscript.common.Token;
import parser.ast.AbstractSyntaxTree;

@Setter
@Getter

public abstract class AbstractSyntaxLeaf implements AbstractSyntaxTree {
    Token token;

   @Override
   public boolean isEmpty() {
       return false;
   }

}
