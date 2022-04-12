package lexer;

import lexer.model.Position;
import lexer.model.Token;
import lexer.model.TokenType;

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
    @Test
    public void test11(){
        String input = "\"Hello World\"";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.STRING, "\"Hello World\"", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test12(){
        String input = "*";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.MULTIPLY, "*", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test13(){
        String input = "1*1";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.MULTIPLY, "*", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test14(){
        String input = "1 * 1";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.MULTIPLY, "*", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test15(){
        String input = " ";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test16(){
        String input = "1>1 >= 1";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.GREATER, ">", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.GREATER_EQUAL, ">=", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test17(){
        String input = "1=1";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.EQUAL, "=", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test18(){
        String input = "1<1 <= 1";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.LESS, "<", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.LESS_EQUAL, "<=", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test19(){
        String input = "let variable = 1;";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.LET, "let", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.IDENTIFIER, "variable", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.EQUAL, "=", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.SEMICOLON, ";", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test20(){
        String input = "const variable = 1;";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.CONST, "const", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.IDENTIFIER, "variable", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.EQUAL, "=", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.SEMICOLON, ";", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test21(){
        String input = "print(1);";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.PRINT, "print", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.LEFT_PAREN, "(", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.RIGHT_PAREN, ")", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.SEMICOLON, ";", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));

        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test22(){
        String input = "if(1=1) else 1";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.IF, "if", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.LEFT_PAREN, "(", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.EQUAL, "=", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.RIGHT_PAREN, ")", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.ELSE, "else", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
    @Test
    public void test23(){
        String input = "const  constante = 1;";
        List<Token> output = new ArrayList<>();
        output.add(new Token(TokenType.CONST, "const", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.IDENTIFIER, "constante", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.EQUAL, "=", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.WHITESPACE, " ", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.NUMBER, "1", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        output.add(new Token(TokenType.SEMICOLON, ";", Position.builder().rowEnd(0).rowStart(0).columnEnd(0).columnStart(0).build()));
        List<Token> result = new Lexer().lex(input);

        assertArrayEquals(output.toArray(), result.toArray());
    }
}
