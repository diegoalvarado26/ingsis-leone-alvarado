package parser;
import lexer.Lexer;
import org.austral.ingsis.printscript.common.Token;
import parser.ast.AbstractSyntaxTree;
import java.util.List;

public interface Parser {
    List<AbstractSyntaxTree> parse(Lexer lexer) throws Exception;
    AbstractSyntaxTree parse(List<Token> tokenList);


    }

