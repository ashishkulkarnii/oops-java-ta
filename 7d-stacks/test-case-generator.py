import random

with open("stack/testcase.txt", "w") as f:
    for i in range(random.randint(1, 1000)):
        f.write(f"{random.randint(1, 1000)}\n")
