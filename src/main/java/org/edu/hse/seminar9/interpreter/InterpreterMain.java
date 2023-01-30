package org.edu.hse.seminar9.interpreter;

import org.edu.hse.seminar9.interpreter.expression.AddExpression;
import org.edu.hse.seminar9.interpreter.expression.Expression;
import org.edu.hse.seminar9.interpreter.expression.NumberExpression;
import org.edu.hse.seminar9.interpreter.expression.SubtractExpression;

public class InterpreterMain {
    public static void main(String[] args) {
        final Context context = new Context();

        int x = 5;
        int y = 8;
        int z = 2;

        context.setVariable("x", x);
        context.setVariable("y", y);
        context.setVariable("z", z);

        // (x + y) - z
        final Expression expression = new SubtractExpression(
                new AddExpression(
                        new NumberExpression("x"),
                        new NumberExpression("y")
                ),
                new NumberExpression("z")
        );

        final int result = expression.interpret(context);

        System.out.println("Result: " + result);
    }
}
