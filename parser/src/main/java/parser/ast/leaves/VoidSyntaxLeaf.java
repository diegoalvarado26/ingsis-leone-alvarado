package parser.ast.leaves;

import org.austral.ingsis.printscript.common.Token;
import parser.ast.ASTVisitor;
import parser.ast.AbstractSyntaxTree;
import parser.ast.branches.ValueAssignationBranch;

public  class VoidSyntaxLeaf implements AbstractSyntaxTree {

    Token token;
   public String string;

    @Override
    public Token getToken() {
        return token;
    }

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
