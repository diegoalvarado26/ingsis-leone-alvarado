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
    @Test
    public void test05(){
        String input = "const";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.CONST, "const", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test06(){
        String input = "Mati";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.IDENTIFIER, "Mati", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test07(){
        String input = "aa";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.IDENTIFIER, "aa", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }

    @Test
    public void test08(){
        String input = "100";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.NUMBER, "100", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }

    @Test
    public void test09(){
        String input = "100.0";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.NUMBER, "100.0", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test10(){
        String input = "100.100";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.NUMBER, "100.100", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
//    @Test
//    public void test11(){
//        String input = "\"Hello World\"";
//        List<Token> output = new ArrayList<>();
//        output.add(new Token(TokenType.IDENTIFIER, "aa", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
//
//        List<Token> result = new Lexer().lex(input);
//
//        assertArrayEquals(output.toArray(), result.toArray());
//    }

}
