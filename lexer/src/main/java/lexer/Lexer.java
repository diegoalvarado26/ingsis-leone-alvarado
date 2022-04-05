package lexer;

import lexer.model.Position;
import lexer.model.Token;

import java.util.ArrayList;
import java.util.List;

import static lexer.model.TokenType.MINUS;
import static lexer.model.TokenType.PLUS;

public class Lexer {

    private List<Token> tokens = new ArrayList<>();

    public Lexer(){}

    public List<Token> lex(String text){
        return addTokens(text);
    }

    private List<Token> addTokens(String text){

        for (int i = 0; i < text.length(); i++) {
            String current = Character.valueOf(text.charAt(i)).toString();
            if(current.equals(MINUS.getRep())){
                Token token = new Token(MINUS, current,Position.builder().columnStart(0).columnEnd(0).rowStart(0).rowEnd(0).build());
                tokens.add(token);
            }
            if(current.equals(PLUS.getRep())){
                Token token = new Token(PLUS, current,Position.builder().columnStart(0).columnEnd(0).rowStart(0).rowEnd(0).build());
                tokens.add(token);
            }
        }

        return tokens;
    }


}
