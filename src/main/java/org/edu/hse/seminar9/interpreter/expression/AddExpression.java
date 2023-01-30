package org.edu.hse.seminar9.interpreter.expression;

import lombok.RequiredArgsConstructor;
import org.edu.hse.seminar9.interpreter.Context;

@RequiredArgsConstructor
public class AddExpression implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    @Override
    public int interpret(Context context) {
        return leftExpression.interpret(context) + rightExpression.interpret(context);
    }
}
