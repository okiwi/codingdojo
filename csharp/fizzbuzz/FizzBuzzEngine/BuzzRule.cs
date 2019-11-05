namespace FizzBuzzEngine
{
    public class BuzzRule : BaseRule, IRule
    {
        public BuzzRule()
        {
        }

        public string Convert(int number)
        {
            return IsMultiple(number, 5) ? "buzz" : "";
        }
    }
}