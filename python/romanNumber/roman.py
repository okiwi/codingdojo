def to_roman(num):
    """
    Should return I
    >>> to_roman(1)
    'I'

    Should return II
    >>> to_roman(2)
    'II'

    >>> to_roman(5)
    'V'

    >>> to_roman(4)
    'IV'

    >>> to_roman(6)
    'VI'

    >>> to_roman(8)
    'VIII'

    >>> to_roman(9)
    'IX'

    >>> to_roman(10)
    'X'

    >>> to_roman(14)
    'XIV'

    >>> to_roman(15)
    'XV'

    >>> to_roman(18)
    'XVIII'

    >>> to_roman(19)
    'XIX'

    >>> to_roman(22)
    'XXII'

    >>> to_roman(32)
    'XXXII'

    >>> to_roman(42)
    'XLII'
    """
    roman_numeral = ""
    num, roman_numeral = get_letters((50,40),( "L","XL"), num, roman_numeral)
    num, roman_numeral = get_letters((10,9),( "X","IX"), num, roman_numeral)
    num, roman_numeral = get_letters((5,4),( "V","IV"), num, roman_numeral)

        
    if num % 5 in [1,2,3] :
        for i in range(0,num) :
            roman_numeral += "I"
    return roman_numeral

def get_letters(nums, letters, left, roman_numeral) :
    big, small = nums
    over, under = letters
    while left >= big :
        if left >= big :
            roman_numeral += over
            left -= big
    if left >= small :
        roman_numeral += under
        left -= small
    return left, roman_numeral