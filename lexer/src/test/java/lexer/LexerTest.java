package lexer;

import lexer.model.Position;
import lexer.model.Token;
import lexer.model.TokenType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class LexerTest {


    @Test
    public void test01(){
        String input = "-";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.MINUS, "-", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test02(){
        String input = "--";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.MINUS, "-", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.MINUS, "-", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test03(){
        String input = "+";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.PLUS, "+", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test04(){
        String input = "+-+";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.PLUS, "+", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.MINUS, "-", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.PLUS, "+", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
}
