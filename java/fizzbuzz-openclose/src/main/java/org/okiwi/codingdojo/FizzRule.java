package org.okiwi.codingdojo;

public class FizzRule implements IRule {
    public FizzRule() {
    }

    @Override
    public String test(Integer number) {
        if (number % 3 == 0) {
            return "fizz";
        }
        return "";
    }
}