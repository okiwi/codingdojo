namespace FizzBuzz

type Res =
    | Fizz
    | Buzz

type RuleResult =
    | Number of uint32
    | Replied of Res * RuleResult

module FizzBuzz =
    let say number =
        let rec sayWithRules rulez number  =
            match (rulez, number) with
            | [], Number x -> Number x
            | _, Replied(res, ruleRes)
                -> Replied(res, (sayWithRules rulez ruleRes))
            | rule :: otherRulez, Number x when (rule x) <> Number x
                -> sayWithRules otherRulez (rule x)
            | _ :: otherRulez, x -> sayWithRules otherRulez x
        
        let sayRule rule res number =
            match number with
                | x when rule(x) -> Replied(res, Number x)
                | x -> Number x
                
        let sayBuzz = (sayRule (fun x -> (x % 5u = 0u)) Buzz)
        let sayFizz = (sayRule (fun x -> (x % 3u = 0u)) Fizz)

        sayWithRules [sayFizz ; sayBuzz] (Number number)