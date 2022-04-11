package parser.ast;
import org.austral.ingsis.printscript.common.Token;
import parser.ast.branches.ASTVisitable;

public interface AbstractSyntaxTree extends ASTVisitable {

    void setToken(Token token);
    AbstractSyntaxTree add(AbstractSyntaxTree tree);

    AbstractSyntaxTree addValueAssignation(AbstractSyntaxTree tree);
    AbstractSyntaxTree addTypeAssignation(AbstractSyntaxTree tree);


}
