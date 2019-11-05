class FizzBuzzMotor:
    def transform(self, number):
        answer = ''
        if number == 42 :
            return "reponseuniverselle"
        if number % 3 is 0 :
            answer += "fizz"
        if number % 5 is 0 :
            answer += "buzz"
        if number % 7 is 0 :
            answer += "bang"
        if answer is '' :
            answer = str(number)

        return answer
