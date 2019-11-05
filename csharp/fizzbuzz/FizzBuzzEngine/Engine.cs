using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Linq;

namespace FizzBuzzEngine
{
    public class Engine
    {

        private ICollection<IRule> rules;

        public Engine()
        {
            rules = new HashSet<IRule> {
                new FizzRule(),
                new BuzzRule()
            };
        }

        public string Say(int number)
        {
            string result = "";
            result = CheckFinalRules(number);
            result = CheckAllRules(number, result);
            return result;
        }

        private string CheckAllRules(int number, string result)
        {
            if (result != "") return result; // unless we already have a result
            foreach (IRule rule in rules)
            {
                string intermedResult = "";
                intermedResult = rule.Convert(number);
                if (rule is IIsFinal && intermedResult != "")
                {
                    return intermedResult;
                }
                else
                {
                    result += intermedResult;
                }

            }
            if (!HasValue(result))
            {
                result = number.ToString();
            }
            return result;
        }

        private string CheckFinalRules(int number)
        {
            string result = "";
            var finalRules = from r in rules where r is IIsFinal select r;

            foreach (var rule in finalRules)
            {
                result = rule.Convert(number);
            }
            return result;
        }

        private bool HasValue(string result)
        {
            return !string.IsNullOrEmpty(result);
        }

        public void AddRule(IRule rule)
        {
            rules.Add(rule);
        }
    }
}