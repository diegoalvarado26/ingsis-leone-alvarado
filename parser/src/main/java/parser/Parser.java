package parser;
import lexer.Lexer;
import parser.ast.AbstractSyntaxTree;
import java.util.List;

public interface Parser {
    List<AbstractSyntaxTree> parse(Lexer lexer) throws Exception;


    }

