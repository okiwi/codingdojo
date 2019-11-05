using NUnit.Framework;
using System;
using FizzBuzzEngine;

namespace FizzBuzzEngineTests
{
    [TestFixture()]
    public class FizzBuzzTests
    {
        private Engine engine;
        [SetUp()]
        public void setUp()
        {
            engine = new Engine();
        }

        [Test()]
        public void CanSayOne()
        {
            // arrange
            // act
            var one = engine.Say(1);
            // assert
            Assert.AreEqual("1", one);
        }

        [Test()]
        public void CanSayFizz()
        {
            // arrange
            // act
            var fizz = engine.Say(3);
            // assert
            Assert.AreEqual("fizz", fizz);
        }

        [Test()]
        public void CanSayBuzz()
        {
            // arrange
            // act
            var buzz = engine.Say(5);
            // assert
            Assert.AreEqual("buzz", buzz);
        }

        [Test()]
        public void CanSayFizzBuzz()
        {
            // arrange
            // act
            var fizzbuzz = engine.Say(3 * 5);
            // assert
            Assert.AreEqual("fizzbuzz", fizzbuzz);
        }

        [Test()]
        public void FizzRuleCanSayFizz()
        {
            // arrange
            var fizzRule = new FizzRule();
            // act
            var fizz = fizzRule.Convert(3);
            // assert
            Assert.AreEqual("fizz", fizz);
        }

        [Test()]
        public void BuzzRuleCanSayBuzz()
        {
            // arrange
            var buzzRule = new BuzzRule();
            // act
            var buzz = buzzRule.Convert(5);
            // assert
            Assert.AreEqual("buzz", buzz);
        }

        [Test()]
        public void CanSayFizzBuzzBang()
        {
            // arrange
            engine.AddRule(new BangRule());
            // act
            var fizzbuzzbang = engine.Say(3 * 5 * 7);
            // assert
            Assert.AreEqual("fizzbuzzbang", fizzbuzzbang);
        }

        [Test()]
        public void CanSayTheAnswerToEverything()
        {   
            // arrange
            engine.AddRule(new FortyTwoRule());
            // act
            var theAnswer = engine.Say(42);
            // assert
            Assert.AreEqual("The answer", theAnswer);
        }

        [Test()]
        public void FortyTwoRuleImplementsIIsFinal()
        {
            // arrange
            var fortyTwoRule = new FortyTwoRule();
            // act
            // assert
            Assert.IsTrue(fortyTwoRule is IIsFinal);
        }

        [Test()]
        public void CanSayWoopeeForSixtyNine()
        {
            // arrange
            engine.AddRule(new SixtyNineRule());
            // act
            var woopee = engine.Say(69);
            // assert
            Assert.AreEqual("Woopee!", woopee);
        }


    }
}
