import random

def random_no():
    num = ""
    for _ in range(10):
        num = num + str(random.randint(0, 9))
    return int(num)

def random_email():
    email = ""
    for _ in range(random.randint(1, 15)):
        email = email + chr(random.randint(97, 122))
    email = email + random.choice(["@gmail.com", "@yahoo.com", "@hotmail.com", "@outlook.com"])
    return email

def solve(x):
    if type(x) == str:
        return x
    else:
        s = 0
        for i in str(x):
            s += int(i)
        return str(s)

file = open("test_cases.txt", "w")
s = ""
sol = []
for _ in range(10):
    l = []
    for _ in range(random.randint(1, 100)):
        l.append(random.choice([random_email(), random_no()]))
    sol.append("\n".join([solve(i) for i in l]) + "\n")
        
    s += ",".join(map(str, l)) + "\n"
file.write(s)
file.close()

for i in range(len(sol)):
    file = open(f"solution{i}.txt", "w")
    file.write(sol[i])
