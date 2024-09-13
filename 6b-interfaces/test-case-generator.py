def fooencrypt(s):
    res = ''
    for i, c in enumerate(s):
        c = chr(ord(c) - i % 2 + 3)
        res += c
    return res

def foodecrypt(s):
    res = ''
    for i, c in enumerate(s):
        c = chr(ord(c) + i % 2 - 3)
        res += c
    return res

def barencrypt(s):
    res = s[0]
    for i, c in list(enumerate(s))[1:]:
        c = chr(ord(c) - ord(s[i-1]) + 80)
        res += c
    return res

def bardecrypt(s):
    res = s[0]
    for i, c in list(enumerate(s))[1:]:
        c = chr(ord(c) + ord(s[i-1]) - 80)
        res += c
    return res


import random
import test_case

random.seed(0)

inputs, outputs = [], []
for _ in range(10):
    std = random.choice(["foo", "bar"])
    ed = random.choice(["en", "de"])
    if std == "foo" and ed == "en":
        input = ''.join([chr(random.randint(65, 90)) for _ in range(random.randint(1, 65))])
        output = fooencrypt(input)
    elif std == "foo" and ed == "de":
        input = ''.join([chr(random.randint(65, 90)) for _ in range(random.randint(1, 65))])
        input = fooencrypt(input)
        output = foodecrypt(input)
    elif std == "bar" and ed == "en":
        input = ''.join([chr(random.randint(65, 90)) for _ in range(random.randint(1, 65))])
        output = barencrypt(input)
    elif std == "bar" and ed == "de":
        input = ''.join([chr(random.randint(65, 90)) for _ in range(random.randint(1, 65))])
        input = barencrypt(input)
        output = bardecrypt(input)
    input_str = f"{std} {ed} {input}"
    inputs.append(input_str)
    outputs.append(output)
    print(input_str, output, sep="\n", end="\n\n")

test_case.create(inputs, outputs, "interface_test_cases")
