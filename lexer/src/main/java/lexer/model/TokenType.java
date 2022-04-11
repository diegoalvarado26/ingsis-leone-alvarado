package lexer.model;


import org.checkerframework.checker.units.qual.C;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum TokenType {
        WHITESPACE(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals(" ");
                }
        }),
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
        MULTIPLY(new Checker() {
                        @Override
                        public boolean check(String string) {
                                return string.equals("*");
                        }
        }),
        DIVIDE(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("/");
                }
        }),
        EQUAL(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("=");
                }
        }),
        GREATER_EQUAL(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals(">=");
                }
        }),
        GREATER(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals(">");
                }
        }),
        LESS_EQUAL(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("<=");
                }
        }),
        LESS(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("<");
                }
        }),
        CONST(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("const");
                }
        }),
        PRINT(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("print");
                }
        }),
        LET(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("let");
                }
        }),
        LEFT_PAREN(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("(");
                }
        }),
        RIGHT_PAREN(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals(")");
                }
        }),
        SEMICOLON(new Checker() {
                       @Override
                       public boolean check(String string) {
                               return string.equals(";");
                       }
               }),
        IF(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("if");
                }
        }),
        ELSE(new Checker() {
                @Override
                public boolean check(String string) {
                        return string.equals("else");
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
                        String regexWithDots = "([0-9]+[.][0-9]+)";
                        Pattern p = Pattern.compile(regex);
                        Pattern dots = Pattern.compile(regexWithDots);
                        if (string == null) return false;

                        Matcher matcher = p.matcher(string);
                        Matcher withDots = dots.matcher(string);


                        return string.length()<20 && (matcher.matches() || withDots.matches() )&& !string.equals("const") && !string.equals("let");
                }
        }),
        STRING(new Checker() {
                @Override
                public boolean check(String string) {
                        String regex = "\"([^\"]+)\"";
                        Pattern p = Pattern.compile(regex);
                        if (string == null) return false;

                        Matcher matcher = p.matcher(string);


                        return matcher.matches() && !string.equals("const") && !string.equals("let");
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
//        NUMBER_TYPE,
//        STRING_TYPE,
//        BOOLEAN_TYPE,
//        COLON,
//        ASSIGNATION,
//        LEFT_CURLY_BRACES,
//        RIGHT_CURLY_BRACES,
//        EOF,
    }
