package lexer.model;


public enum TokenType {
        MINUS(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("-");
                }
        }),
        PLUS(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("+");
                }
        }),
        CONST(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("const");
                }
        }),
        IDENTIFIER(new Checker() {
                @Override
                public boolean check(String string) {
                        return !string.equals("const") && !string.equals("let");
                }
        });

        private final Checker checker;

        TokenType(Checker checker){
                this.checker = checker;
        }

        public Checker getChecker() {
                return checker;
        }

        public abstract static class Checker{

                public abstract boolean check(String string);

        }

//        MULTIPLY,
//        DIVIDE,
//        GREATER_EQUAL,
//        GREATER,
//        LESS_EQUAL,
//        LESS,
//        STRING,
//        NUMBER,
//        BOOLEAN,
//        PRINT,
//        LET,
//        IF,
//        ELSE,
//        NUMBER_TYPE,
//        STRING_TYPE,
//        BOOLEAN_TYPE,
//        SEMICOLON,
//        COLON,
//        ASSIGNATION,
//        LEFT_PAREN,
//        RIGHT_PAREN,
//        LEFT_CURLY_BRACES,
//        RIGHT_CURLY_BRACES,
//        EOF,
    }
