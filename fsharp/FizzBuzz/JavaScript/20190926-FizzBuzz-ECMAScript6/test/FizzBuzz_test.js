import {expect} from 'chai'
import FizzBuzz from "../app/FizzBuzz"

describe("FizzBuzz", () => {
  it("1 dit '1'", () => {
    // arrange
    const fizzBuzz = new FizzBuzz()
    const expected = '1'
    // act
    const actual = fizzBuzz.say(1)
    // assert
    expect(actual).to.equal(expected)
  });

  [5, 10].forEach((key) => {
    it(`${key} dit 'Buzz'`, () => {
      // arrange
      const fizzBuzz = new FizzBuzz()
      const expected = 'Buzz'
      // act
      const actual = fizzBuzz.say(key)
      // assert
      expect(actual).to.equal(expected)
    })
  });

  [3, 6].forEach((key) => {
    it(`${key} dit 'Fizz'`, () => {
      // arrange
      const fizzBuzz = new FizzBuzz()
      const expected = 'Fizz'
      // act
      const actual = fizzBuzz.say(key)
      // assert
      expect(actual).to.equal(expected)
    })
  })

  it("15 dit 'FizzBuzz'", () => {
    // arrange
    const fizzBuzz = new FizzBuzz()
    const expected = 'FizzBuzz'
    // act
    const actual = fizzBuzz.say(15)
    // assert
    expect(actual).to.equal(expected)
  });
})
