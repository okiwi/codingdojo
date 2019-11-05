from main import FizzBuzzMotor
import unittest


class TestMain(unittest.TestCase):
    def setUp(self) :
        self.fb = FizzBuzzMotor()

    def test_if_3_then_fizz(self):
        self.assertEqual(self.fb.transform(3), 'fizz')

    def test_if_5_then_buzz(self):
        self.assertEqual(self.fb.transform(5), 'buzz')

    def test_if_15_then_fizzbuzz(self):
        self.assertEqual(self.fb.transform(15), 'fizzbuzz')

    def test_if_1_then_1(self):
        self.assertEqual(self.fb.transform(1), '1')

    def test_if_30_then_fizzbuzz(self):
        self.assertEqual(self.fb.transform(30), 'fizzbuzz')

    def test_if_7_then_bang(self):
        self.assertEqual(self.fb.transform(7), 'bang')

    def test_if_21_then_fizzbang(self):
        self.assertEqual(self.fb.transform(21), 'fizzbang')

    def test_if_35_then_buzzbang(self):
        self.assertEqual(self.fb.transform(35), 'buzzbang')

    def test_if_105_then_fizzbuzzbang(self):
        self.assertEqual(self.fb.transform(105), 'fizzbuzzbang')

    def test_if_42_then_reponseuniverselle(self):
        self.assertEqual(self.fb.transform(42), 'reponseuniverselle')

if __name__ == '__main__':
    unittest.main()
