"""
Compulsorily use the concept of ArrayList to solve this problem. Failure to abide by this rule will result in zero marks.

A list of cars models (comma-separated), will be given in one line.
In the next line, there will be a list of horsepowers, which correspond to the respective cars above.

Populate two Java ArrayLists, one of car models and one of their horsepowers.
Sort the car models by their horsepowers.
As output, use the car model ArrayList's `toString()` method and print.

Hint: If you'd like to learn something new, and make your life slightly easier, consider researching overriding the comparator for the String class.
"""

import random
import test_case

def java_str(arr):
    return "[" + ", ".join(arr) + "]"

def create_testcases():
    car_models = ["BMW", "Audi", "Mercedes", "Toyota", "Honda", "Ford", "Chevrolet", "Nissan", "Volkswagen", "Hyundai", "Kia", "Subaru", "Mazda", "Mitsubishi", "Suzuki", "Ferrari", "Lamborghini", "Porsche", "Bugatti", "Maserati"]

    inputs = []
    outputs = []

    for i in range(10):
        n_cars = random.randint(1, 20)
        cars = random.sample(car_models, n_cars)
        hp = random.sample(range(100, 1000), n_cars)
        inputs.append(",".join(cars) + "\n" + ",".join(map(str, hp)))
        outputs.append(java_str(sorted(cars, key=lambda x: hp[cars.index(x)])))

    test_case.create(inputs, outputs, "arraylist/test_cases")

create_testcases()