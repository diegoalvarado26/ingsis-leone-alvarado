package parser;

import lexer.Lexer;
import org.austral.ingsis.printscript.common.Token;
import parser.ast.AbstractSyntaxTree;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser{

    @Override
    public List<AbstractSyntaxTree> parse(Lexer lexer) throws Exception {
        return null;
    }

    @Override
    public AbstractSyntaxTree parse(List<Token> tokenList) {
        List<AbstractSyntaxTree> abstractSyntaxTrees = new ArrayList<>();
        return null;
    }
}
