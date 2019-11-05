import re


def add(*romans_numbers):
    if "IIII" in romans_numbers:
        raise ValueError
    roman_numbers_as_Is = [_roman_number_to_I(check_valid_char(roman_number)) for roman_number in romans_numbers]
    nombres_concaténés = "".join(roman_numbers_as_Is)

    nombres_concaténés = Is_to_roman(nombres_concaténés)
    return nombres_concaténés


def check_valid_char(roman_number):
    if not re.match(r'[IV]+', roman_number):
        raise ValueError
    return roman_number


def Is_to_roman(nombres_concaténés):
    if nombres_concaténés[:5] == "IIIII":
        nombres_concaténés = "V" + nombres_concaténés[5:]
    if nombres_concaténés == "IIII":
        nombres_concaténés = "IV"
    return nombres_concaténés


def _roman_number_to_I(roman_number: str) -> str:

    if roman_number == "IV":
        return "IIII"

    return roman_number.replace("V", "IIIII")
