from unittest import TestCase

from NombreLatin import add


class TestAdd(TestCase):
    def test_add(self):
        self.assertEqual("II", add("I", "I"))
        self.assertEqual("III", add("II", "I"))

    def test_add_IV(self):
        self.assertEqual("IV", add("II", "II"))

    def test_V(self):
        self.assertEqual("V", add("III", "II"))
        self.assertEqual("V", add("IV", "I"))
        self.assertEqual("V", add("I", "IV"))

    def test_VI(self):
        self.assertEqual("VI", add("V", "I"))
        self.assertEqual("VI", add("I", "V"))

    def test_VII(self):
        self.assertEqual("VII", add("I", "VI"))
        self.assertEqual("VII", add("IV", "III"))

    def test_VIII(self):
        self.assertEqual("VIII", add("I", "VII"))
        self.assertEqual("VIII", add("VI", "II"))
        self.assertEqual("VIII", add("IV", "IV"))
        self.assertEqual("VIII", add("IV", "II", "II"))

    def test_params_are_valids(self):
        self.assertRaises(ValueError, add, "IIII")
        self.assertRaises(ValueError, add, "azaz")


