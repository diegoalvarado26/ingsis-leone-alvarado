package lexer;

import lexer.model.Position;
import lexer.model.Token;
import lexer.model.TokenType;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.*;

import static lexer.model.TokenType.*;

public class Lexer {

    private List<Token> tokens = new ArrayList<>();

    public Lexer() {
    }

    public List<Token> lex(String text) {
        return addTokens(text);
    }

    private List<Token> addTokens(String text) {
        String current = "";
        for (int i = 0; i < text.length(); i++) {
            current += Character.valueOf(text.charAt(i)).toString();
            String nextChar = null;
            String nextNextChar = null;
            if ( i+1 < text.length()) {
              nextChar = Character.valueOf(text.charAt(i + 1)).toString();
            } if(i+2 < text.length()){
                nextNextChar = Character.valueOf(text.charAt(i + 2)).toString();
            }
                for (TokenType type : values()) {
                    if (type.getChecker().check(current) && !isValidWithNextChar(current, nextChar, nextNextChar)) {
                        Token token = new Token(type, current, Position.builder().columnStart(0).columnEnd(0).rowStart(0).rowEnd(0).build());
                        tokens.add(token);
                        current = "";
                    }
                }
        }

        return tokens;
    }

    private boolean isValidWithNextChar(String currentChar, String firstChar, String secondChar){
        String regex = "^([a-zA-Z_$][a-zA-Z\\d_$]*)$";
        String numberRegex = "([0-9]+)$";
        String numberWithDots = "([0-9]+.[0.9]+)";
        Pattern p = Pattern.compile(regex);
        Pattern numberPattern = Pattern.compile(numberRegex);
        Pattern numberWithDotsPattern = Pattern.compile(numberWithDots);

        String currentFirst = currentChar + firstChar;
        String currentFirstSecond= currentFirst + secondChar;

        boolean firstMatch = firstChar!=null && (p.matcher(currentFirst).matches() || (numberPattern.matcher(currentFirst).matches() || numberWithDotsPattern.matcher(currentFirst).matches()));
        boolean secondMatch = secondChar != null && (p.matcher(currentFirstSecond).matches() || (numberPattern.matcher(currentFirstSecond).matches() || numberWithDotsPattern.matcher(currentFirstSecond).matches()));

        return firstMatch || secondMatch;

    }
}

