using System;
namespace FizzBuzzEngine
{
    public class FortyTwoRule : IRule, IIsFinal
    {
        public FortyTwoRule()
        {
        }

        public string Convert(int number)
        {
            return number == 42 ? "The answer" : "";
        }
    }
}
