package parser.ast.branches;

import lombok.Builder;
import org.austral.ingsis.printscript.common.Token;
import parser.ast.ASTVisitor;
import parser.ast.AbstractSyntaxTree;

@Builder
public class ValueAssignationBranch extends AbstractSyntaxBranch {

    @Override
    public void setToken(Token token) {

    }

    @Override
    public AbstractSyntaxTree add(AbstractSyntaxTree tree) {
        return null;
    }

    @Override
    public AbstractSyntaxTree addValueAssignation(ValueAssignationBranch branch) {
        return branch;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void accept(ASTVisitor visitor) {

    }
}
