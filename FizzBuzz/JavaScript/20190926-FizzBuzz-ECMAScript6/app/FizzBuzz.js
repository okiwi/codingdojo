class FizzBuzz {
  constructor() {
    this.params = {
        15: 'FizzBuzz',
      3: 'Fizz',
      5: 'Buzz',

    };
  }

  say(number) {
    if ((number % 3 === 0) &&
      (number % 5 === 0)) {
      return 'FizzBuzz'
    }
    for (const [key, value] of Object.entries(this.params)) {
      if (number % key === 0) {
        return value
      }
    }
    return number.toString()

  }
}

export default FizzBuzz
