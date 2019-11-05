package org.okiwi.codingdojo;

public class BuzzRule implements IRule {
    public BuzzRule() {
    }

    @Override
    public String test(Integer number) {
        if (number % 5 == 0) {
            return "buzz";
        }
        return "";
    }
}