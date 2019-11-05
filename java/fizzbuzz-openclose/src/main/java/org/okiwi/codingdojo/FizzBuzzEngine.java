package org.okiwi.codingdojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzzEngine {
    private List<IRule> rules;

    public FizzBuzzEngine(List<IRule> rules) {
        this.rules = rules;
    }

    public String say(Integer number) {
        for (IRule rule : rules) {
            String traduction = rule.test(number);
            if (!"".equals(traduction)) return traduction;
        }
        return number.toString();
    }
}
