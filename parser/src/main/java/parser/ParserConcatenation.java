package parser;

import lexer.Lexer;
import org.austral.ingsis.printscript.common.Token;

import java.util.List;

public class ParserConcatenation {

    public Lexer lexer;
    public List<Token> tokens;

    public ParserConcatenation(Lexer lexer) {
        this.lexer = lexer;
    }
    public void consume(List<Token> tokens){

    }

}
