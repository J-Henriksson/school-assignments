import java.util.regex.Pattern;

/**
 * The Postfix class implements an evaluator for integer postfix expressions.
 *
 * Postfix notation is a simple way to define and write arithmetic expressions
 * without the need for parentheses or priority rules. For example, the postfix
 * expression "1 2 - 3 4 + *" corresponds to the ordinary infix expression
 * "(1 - 2) * (3 + 4)". The expressions may contain decimal 32-bit integer
 * operands and the four operators +, -, *, and /. Operators and operands must
 * be separated by whitespace.
 *
 * @author  Joel Henriksson
 * @version 2017-12-12
 */
public class Postfix {
    public static class ExpressionException extends Exception {
        public ExpressionException(String message) {
            super(message);
        }
    }

    /**
     * Evaluates the given postfix expression.
     *
     * @param expr  Arithmetic expression in postfix notation
     * @return      The value of the evaluated expression
     * @throws      ExpressionException if the expression is wrong
     */
    public static int evaluate(String expr) throws ExpressionException {
        LinkedList<Integer> stack = new LinkedList<>();
        String []  tokens = expr.trim().split("\\s+");
        for (String element : tokens) {
            if (isInteger(element)) {
                stack.push(Integer.parseInt(element));
            }
            else if (isOperator(element) && stack.size() > 1) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                switch (element) {
                    case "+":
                      stack.push(b + a);
                      break;
                    case "-":
                      stack.push(b - a);
                      break;
                    case "*":
                      stack.push(b * a);
                      break;
                    case "/":
                      if (a == 0) {
                        throw new ExpressionException("Can't divide by zero");
                      }
                      stack.push(b / a);
                      break;
                }

            }
            else {
                throw new ExpressionException("Incorrect operator");
            }
        }
        if (stack.size() != 1) {
            throw new ExpressionException("Invalid expression");
        }
        return stack.top();
    }

    /**
     * Returns true if s is an operator.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * An operator is one of '+', '-', '*', '/'.
     */
    private static boolean isOperator(String s) {
        String operatorPattern = "[-+*/]";
        // Use Pattern.matches() to check if the symbol matches the pattern
        return Pattern.matches(operatorPattern, s);
    }

    /**
     * Returns true if s is an integer.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * We accept two types of integers:
     *
     * - the first type consists of an optional '-'
     *   followed by a non-zero digit
     *   followed by zero or more digits,
     *
     * - the second type consists of an optional '-'
     *   followed by a single '0'.
     */
    private static boolean isInteger(String s) {
        String integerPattern = "-?(0|[1-9]\\d*)";    
        return Pattern.matches(integerPattern, s);
    }
}
