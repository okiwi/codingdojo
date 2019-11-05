using System;
namespace FizzBuzzEngine
{
    public class BangRule : BaseRule, IRule
    {
        public BangRule()
        {
        }

        public string Convert(int number)
        {
            return IsMultiple(number, 7) ? "bang" : "";
        }
    }
}
