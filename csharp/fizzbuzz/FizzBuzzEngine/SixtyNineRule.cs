using System;
namespace FizzBuzzEngine
{
    public class SixtyNineRule : IRule, IIsFinal
    {
        public SixtyNineRule()
        {
        }

        public string Convert(int number)
        {
            return number == 69 ? "Woopee!" : "";
        }
    }
}
