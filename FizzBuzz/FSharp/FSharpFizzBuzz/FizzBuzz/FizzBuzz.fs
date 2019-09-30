namespace FizzBuzz
open System

module FizzBuzz =
    let say (number: int) =
        let applicableRules = [(3, "Fizz"); (5, "Buzz")]
        
        let applyRule (ruly, result) =
            match ruly with
            | true -> result
            | false -> ""
            
        let rec sayWithRules (rules, num, ruleWasApplied) =
            match (rules, num, ruleWasApplied) with
            | ([], num, false) -> string num
            | ([], _, true) -> String.Empty
            | ((denominator, result) :: tail, num, _) ->
                let ruly = (number%denominator = 0)
                applyRule(ruly, result)
                + sayWithRules(tail, num, ruly || ruleWasApplied)
        
        sayWithRules(applicableRules, number, false)
