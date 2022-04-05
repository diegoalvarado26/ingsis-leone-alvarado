package lexer.model;

import java.util.Objects;

public class Token {
    // TODO lombokear esto.
    public TokenType tokenType;
    public String value;
    public Position position;

    public Token(TokenType tokenType, String value, Position position) {
        this.tokenType = tokenType;
        this.value = value;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return tokenType == token.tokenType && Objects.equals(value, token.value) && Objects.equals(position, token.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokenType, value, position);
    }
}



