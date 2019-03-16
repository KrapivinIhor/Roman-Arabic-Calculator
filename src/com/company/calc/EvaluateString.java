package com.company.calc;

class EvaluateString {

    static double evaluate(final String expression) {
        return new Object() {
            int position = -1, chars;

            void nextChar() {
                chars = (++position < expression.length()) ? expression.charAt(position) : -1;
            }

            boolean decoding(int charToEat) {
                while (chars == ' ') nextChar();
                if (chars == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double result = parseExpression();
                if (position < expression.length()) throw new RuntimeException("Unexpected: " + (char) chars);
                return result;
            }

            double parseExpression() {
                double result = parseTerm();
                for (;;) {
                    if      (decoding('+')) result += parseTerm(); // addition
                    else if (decoding('-')) result -= parseTerm(); // subtraction
                    else return result;
                }
            }

            double parseTerm() {
                double result = parseFactor();
                for (;;) {
                    if      (decoding('*')) result *= parseFactor(); // multiplication
                    else if (decoding('/')) result /= parseFactor(); // division
                    else return result;
                }
            }

            double parseFactor() {
                if (decoding('+')) return parseFactor(); // unary plus
                if (decoding('-')) return -parseFactor(); // unary minus

                double result;
                int startPos = this.position;
                if (decoding('(')) { // parentheses
                    result = parseExpression();
                    decoding(')');
                } else if ((chars >= '0' && chars <= '9') || chars == '.') { // numbers
                    while ((chars >= '0' && chars <= '9') || chars == '.') nextChar();
                    result = Double.parseDouble(expression.substring(startPos, this.position));
                } else if (chars >= 'a' && chars <= 'z') { // functions
                    while (chars >= 'a' && chars <= 'z') nextChar();
                    String function = expression.substring(startPos, this.position);
                    result = parseFactor();
                    if (function.equals("sqrt")) result = Math.sqrt(result);
                    else if (function.equals("sin")) result = Math.sin(Math.toRadians(result));
                    else if (function.equals("cos")) result = Math.cos(Math.toRadians(result));
                    else if (function.equals("tan")) result = Math.tan(Math.toRadians(result));
                    else throw new RuntimeException("Unknown function: " + function);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) chars);
                }
                if (decoding('^')) result = Math.pow(result, parseFactor()); // exponentiation
                return result;
            }
        }.parse();
    }
}