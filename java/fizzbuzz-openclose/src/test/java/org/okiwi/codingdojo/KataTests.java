package org.okiwi.codingdojo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KataTests {

    private IRule buzzRule;
    private IRule fizzRule;
    private IRule fizzBuzzRule;
    private FortyTwoRule fortyTwoRule;
    private List<IRule> rules;
    FizzBuzzEngine engine;

    @Before
    public void setUp() {

        buzzRule = new BuzzRule();
        fizzRule = new FizzRule();
        fizzBuzzRule = new FizzBuzzRule();
        fortyTwoRule = new FortyTwoRule();

        rules = Arrays.asList(
                fortyTwoRule,
                fizzBuzzRule,
                buzzRule,
                fizzRule
                );
        engine = new FizzBuzzEngine(rules);
    }

    @Test
    public void can_say_one() {
        // act
        String one = engine.say(1);

        // assert
        assertThat(one).isEqualTo("1");
    }

    @Test
    public void can_say_fizz() {
        // act
        String fizz = engine.say(3);

        // assert
        assertThat(fizz).isEqualTo("fizz");
    }

    @Test
    public void can_say_buzz() {
        // act
        String buzz = engine.say(5);

        // assert
        assertThat(buzz).isEqualTo("buzz");
    }

    @Test
    public void can_say_fizzbuzz() {
        // act
        String fizzbuzz = engine.say(15);

        // assert
        assertThat(fizzbuzz).isEqualTo("fizzbuzz");
    }

    @Test
    public void can_say_forty_two() {
        // act
        String life = engine.say(42);

        // assert
        assertThat(life).isEqualTo("life");
    }
}
