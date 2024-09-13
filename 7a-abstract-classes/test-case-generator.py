import test_case as test_case
import random


inputs = []
outputs = []

def draw_solid_square(x: int) -> str:
    s = ""
    for i in range(x):
        s += "." * x + "\n"
    return s + str(float(x * x))

def draw_hollow_square(x: int) -> str:
    s = ""
    for i in range(x):
        if i == 0 or i == x - 1:
            s += "." * x + "\n"
        else:
            s += "." + " " * (x - 2) + "." + "\n"
    return s + str(float(x * x))

def draw_solid_triangle(x: int) -> str:
    s = ""
    for i in range(x):
        s += "." * (i + 1) + "\n"
    return s + str(float(x * (x) / 2))

def draw_hollow_triangle(x: int) -> str:
    s = ""
    for i in range(x):
        if i == 0 or i == x - 1:
            s += "." * (i + 1) + "\n"
        else:
            if x < 2:
                s += "." * (i + 1) + "\n"
            else:
                s += "." + " " * (i - 1) + "." + "\n"
    return s + str(float(x * (x) / 2))

for i in range(10):
    x = random.randint(1, 20)
    shape = random.choice(["square", "tri"])
    solid = random.choice(["solid", "hollow"])
    inputs.append(shape + " " + str(x) + " " + solid)
    if shape == "square":
        if solid == "solid":
            outputs.append(draw_solid_square(x))
        else:
            outputs.append(draw_hollow_square(x))
    else:
        if solid == "solid":
            outputs.append(draw_solid_triangle(x))
        else:
            outputs.append(draw_hollow_triangle(x))

test_case.create(inputs, outputs, "abstract/test_cases")
