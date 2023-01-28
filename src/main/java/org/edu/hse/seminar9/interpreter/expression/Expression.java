package org.edu.hse.seminar9.interpreter.expression;

import org.edu.hse.seminar9.interpreter.Context;

public interface Expression {
    int interpret(Context context);
}
