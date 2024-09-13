import test_case
import random


def fibonacci(n: int) -> int:
    fib = [0, 1]
    for i in range(2, n + 1):
        fib.append(fib[i - 1] + fib[i - 2])
    return fib[n - 1]


def ap(a: int, d: int, n: int) -> int:
    return a + (n - 1) * d


def whole(n: int) -> int:
    return n


def five(n: int) -> int:
    return 5 * (n - 1)


input, output = [], []
for _ in range(100):
    n = random.randint(1, 47)
    match random.randint(0, 3):
        case 0:
            input.append("fibonacci " + str(n) + "\n")
            output.append(str(fibonacci(n)) + "\n")
        case 1:
            a, d = random.randint(0, 1000), random.randint(0, 1000)
            input.append("ap " + str(n) + " " + str(a) + " " + str(d) + "\n")
            output.append(str(ap(a, d, n)) + "\n")
        case 2:
            input.append("whole " + str(n) + "\n")
            output.append(str(whole(n)) + "\n")
        case 3:
            input.append("five " + str(n) + "\n")
            output.append(str(five(n)) + "\n")
    test_case.create(input, output, "inheritance_test_cases")
