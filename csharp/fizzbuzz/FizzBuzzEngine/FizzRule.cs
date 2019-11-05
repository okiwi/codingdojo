using System;
namespace FizzBuzzEngine
{
    public class FizzRule : BaseRule, IRule
    {
        public FizzRule()
        {
        }

        public string Convert(int number)
        {
            return IsMultiple(number, 3) ? "fizz" : "";
        }
    }
}
