package parser.ast;
import org.austral.ingsis.printscript.common.Token;
import parser.ast.branches.ASTVisitable;
import parser.ast.branches.ValueAssignationBranch;

public interface AbstractSyntaxTree extends ASTVisitable {

    // TODO Diego Lombok e interfaces
    Token getToken();
    void setToken(Token token);
    AbstractSyntaxTree add(AbstractSyntaxTree tree);

    AbstractSyntaxTree addValueAssignation(ValueAssignationBranch tree);
    boolean isEmpty();


}
