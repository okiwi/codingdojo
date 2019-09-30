namespace UnitTestFSharp

open NUnit.Framework

module Say =
    let [<Test>] ``say 1 returns '1'``() =
       let expected = "1"
       Assert.AreEqual(expected, FizzBuzz.FizzBuzz.say (1))

    let [<Test>] ``say 3 returns 'Fizz'``() =
        let expected = "Fizz"
        Assert.AreEqual(expected, FizzBuzz.FizzBuzz.say (3))

    let [<Test>] ``say 6 returns 'Fizz'``() =
        let expected = "Fizz"
        Assert.AreEqual(expected, FizzBuzz.FizzBuzz.say (6))
        
    let [<Test>] ``say 5 returns 'Buzz'``() =
        let expected = "Buzz"
        Assert.AreEqual(expected, FizzBuzz.FizzBuzz.say (5))
    
    let [<Test>] ``say 15 returns 'FizzBuzz'``() =
        let expected = "FizzBuzz"
        Assert.AreEqual(expected, FizzBuzz.FizzBuzz.say (15))