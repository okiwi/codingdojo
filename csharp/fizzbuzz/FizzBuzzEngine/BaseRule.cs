using System;
namespace FizzBuzzEngine
{
    public abstract class BaseRule
    {
        protected bool IsMultiple(int number, int divsor)
        {
            return number % divsor == 0;
        }
    }
}
