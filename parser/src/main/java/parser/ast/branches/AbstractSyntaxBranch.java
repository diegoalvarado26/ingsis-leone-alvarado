package parser.ast.branches;

import lombok.Builder;
import lombok.Getter;
import org.austral.ingsis.printscript.common.Token;
import parser.ast.AbstractSyntaxTree;

@Builder
@Getter

public abstract class AbstractSyntaxBranch implements AbstractSyntaxTree {
   // En principio tendríamos una para cada tipo (e.g. println, suma, etc)
    Token token;
}
