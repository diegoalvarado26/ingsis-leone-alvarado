package lexer;

import lexer.model.Position;
import lexer.model.Token;
import lexer.model.TokenType;

import java.util.ArrayList;
import java.util.List;

import static lexer.model.TokenType.*;

public class Lexer {

    private List<Token> tokens = new ArrayList<>();

    public Lexer(){}

    public List<Token> lex(String text){
        return addTokens(text);
    }

    private List<Token> addTokens(String text){
        String current = "";
        for (int i = 0; i < text.length(); i++) {
            current += Character.valueOf(text.charAt(i)).toString();
            String nextChar = Character.valueOf(text.charAt(i+1)).toString();
            String nextNextChar = Character.valueOf(text.charAt(i+2)).toString();

            for (TokenType type : values()) {
                if(type.getChecker().check(current) && isInvalidWithNextChar(current, nextChar, nextNextChar)){
                    Token token = new Token(type, current,Position.builder().columnStart(0).columnEnd(0).rowStart(0).rowEnd(0).build());
                    tokens.add(token);
                    current = "";
                }
            }
        }

        return tokens;
    }

}

