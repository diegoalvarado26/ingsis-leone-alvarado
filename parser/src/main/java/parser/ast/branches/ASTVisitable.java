package parser.ast.branches;

import parser.ast.ASTVisitor;

public interface ASTVisitable {
    void acccept(ASTVisitor visitor);
}
