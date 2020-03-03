from unittest import TestCase


def compute_fuel_for_total_mass(mass):
    fuel_for_mass = max(0, mass // 3 - 2)
    if fuel_for_mass == 0:
        fuel_for_fuel = 0
    else:
        fuel_for_fuel = compute_fuel_for_total_mass(fuel_for_mass)
    return fuel_for_mass + fuel_for_fuel

def compute_fuel(module_mass):
    return max(0, module_mass // 3 - 2)


def split_masses(input):
    return list(map(int, input.splitlines()))


def compute_fuel_for_modules(modules):
    require_fuel = map(compute_fuel, modules)

    return sum(require_fuel)


class Test(TestCase):

    def test_computeFuelFor1(self):
        required_fuel = compute_fuel(1)
        self.assertEqual(0, required_fuel)

    def test_computeFuelFor12(self):
        required_fuel = compute_fuel(12)
        self.assertEqual(2, required_fuel)

    def test_computeFuelFor10(self):
        required_fuel = compute_fuel(10)
        self.assertEqual(1, required_fuel)

    def test_computeFuelFor9(self):
        required_fuel = compute_fuel(9)
        self.assertEqual(1, required_fuel)

    def test_computeFuelFor11(self):
        required_fuel = compute_fuel(11)
        self.assertEqual(1, required_fuel)

    def test_computeFuelFor1969(self):
        required_fuel = compute_fuel(1969)
        self.assertEqual(654, required_fuel)

    def test_computeFuelFor100756(self):
        required_fuel = compute_fuel(100756)
        self.assertEqual(33583, required_fuel)

    def test_splitMasses(self):
        input = """104489
69854
93424
103763
119636
130562
121744"""
        self.assertEqual(7, len(split_masses(input)))
        self.assertEqual(104489, split_masses(input)[0])

    def test_computeFuelForModules(self):
        modules = [9,10,11,12]

        expected = 5

        self.assertEqual(5, compute_fuel_for_modules(modules))



    def test_compute_fuel_for_total_mass(self):
        self.assertEqual(50346, compute_fuel_for_total_mass(100756))
