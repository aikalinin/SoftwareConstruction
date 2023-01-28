package org.edu.hse.seminar9.interpreter.expression;

import lombok.RequiredArgsConstructor;
import org.edu.hse.seminar9.interpreter.Context;

import java.text.MessageFormat;

@RequiredArgsConstructor
public class NumberExpression implements Expression {

    private final String name;

    @Override
    public int interpret(Context context) {
        return context
                .getVariable(name)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(
                            MessageFormat.format(
                                    "Context doesn''t have variable {0}.",
                                    name
                            ));
                });
    }
}
