namespace FizzBuzz

type GameResult =
  | Number of int
  | Symbol of string
  | None
  static member (+) (a: GameResult, b: GameResult) =
      match (a, b) with
      | _, None -> a
      | None, _ -> b
      | Number a, Number b -> Number(a + b)
      | Symbol a, Number _ -> Symbol a
      | Number _, Symbol b -> Symbol b
      | Symbol a, Symbol b -> Symbol(a + b)

module FizzBuzz =
    let say (number: int) =
        let applicableRules = [ (3, Symbol "Fizz"); (5, Symbol "Buzz") ]

        let applyRule (ruly, result) =
            match ruly with
            | true -> result
            | false -> None

        let rec sayWithRules (rules, num, ruleWasApplied) =
            match (rules, num, ruleWasApplied) with
            | ([], num, false) -> Number num
            | ([], _, true) -> None
            | ((denominator, result) :: tail, num, _) ->
                let ruly = (number % denominator = 0)
                applyRule (ruly, result)
                + sayWithRules (tail, num, ruly || ruleWasApplied)

        sayWithRules (applicableRules, number, false)
