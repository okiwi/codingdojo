package org.okiwi.codingdojo;

/**
 * Created by sam on 2/13/17.
 */
public class FizzBuzzRule implements IRule {
    @Override
    public String test(Integer number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "fizzbuzz";
        }
        return "";
    }
}
