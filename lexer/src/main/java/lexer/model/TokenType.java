package lexer.model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                        String regex = "^([a-zA-Z_$][a-zA-Z\\d_$]*)$";
                        Pattern p = Pattern.compile(regex);
                        if (string == null) return false;

                        Matcher matcher = p.matcher(string);


                        return string.length()<20 && matcher.matches() && !string.equals("const") && !string.equals("let");
                }
        }),
        NUMBER(new Checker() {
                @Override
                public boolean check(String string) {
                        String regex = "([0-9]+)";
                        String regexWithDots = "([0-9]+.[0.9])";
                        Pattern p = Pattern.compile(regex);
                        Pattern dots = Pattern.compile(regexWithDots);
                        if (string == null) return false;

                        Matcher matcher = p.matcher(string);
                        Matcher withDots = dots.matcher(string);


                        return string.length()<20 && (matcher.matches() || withDots.matches() )&& !string.equals("const") && !string.equals("let");
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
