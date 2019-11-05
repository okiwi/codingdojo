package org.okiwi.codingdojo;

/**
 * Created by sam on 2/13/17.
 */
public class FortyTwoRule implements IRule {
    @Override
    public String test(Integer number) {
        if (number == 42) {
            return "life";
        }
        return "";
    }
}
