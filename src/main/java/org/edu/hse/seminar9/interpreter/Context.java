package org.edu.hse.seminar9.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Context {

    Map<String, Integer> variables = new HashMap<>();

    // получаем значение переменной по ее имени
    public Optional<Integer> getVariable(String name) {
        return Optional.ofNullable(variables.get(name));
    }

    public void setVariable(String name, int value) {
        variables.put(name, value);
    }
}
