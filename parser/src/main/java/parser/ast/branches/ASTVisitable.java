package parser.ast.branches;

import parser.ast.ASTVisitor;

public interface ASTVisitable {
    void accept(ASTVisitor visitor);
}
