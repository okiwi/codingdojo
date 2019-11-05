namespace UnitTestFSharp

open NUnit.Framework
open FizzBuzz

module Say =
    let [<Test>] ``say 1 returns '1'``() =
       let expected = Number 1u
       Assert.AreEqual(expected, FizzBuzz.FizzBuzz.say (1u))

    let [<Test>] ``say 3 returns 'Fizz'``() =
        let expected = Replied(Fizz, Number 3u)
        Assert.AreEqual(expected, FizzBuzz.FizzBuzz.say (3u))

    let [<Test>] ``say 6 returns 'Fizz'``() =
        let expected = Replied(Fizz, Number 6u)
        Assert.AreEqual(expected, FizzBuzz.FizzBuzz.say (6u))

    let [<Test>] ``say 5 returns 'Buzz'``() =
        let expected = Replied(Buzz, Number 5u)
        Assert.AreEqual(expected, FizzBuzz.FizzBuzz.say (5u))

    let [<Test>] ``say 15 returns 'FizzBuzz'``() =
        let expected = Replied(Fizz, Replied(Buzz, Number 15u))
        Assert.AreEqual(expected, FizzBuzz.FizzBuzz.say (15u))
