import random

def generateName():
    names = []
    for _ in range(random.randint(2, 3)):
        names.append(random.choice(["John", "Jane", "Jack", "Jill", "James", "Jenny", "Jason", "Jasmine", "Jacob", "Jessica", "Justin", "Julia", "Joseph", "Julie", "Joshua", "Juliet", "Jordan", "Jocelyn", "Jared", "Jade", "Jasper", "Jenna", "Jaxon", "Jade", "Jude", "Jasmine", "Jett", "Jocelyn", "Jax", "Jade", "Jaxson", "Jasmine", "Jaxton", "Jade", "Jay", "Jasmine", "Jayce", "Jade", "Jayden", "Jasmine", "Jaylen", "Jade", "Jayson", "Jasmine", "Jeremiah", "Jade", "Jeremy", "Jasmine", "Jerome", "Jade", "Jesse", "Jasmine", "Joel", "Jade", "Jonah", "Jasmine", "Jonas", "Jade", "Jonathan", "Jasmine", "Jordan", "Jade", "Joseph", "Jasmine", "Joshua", "Jade", "Josiah", "Jasmine", "Jude", "Jade", "Julian", "Jasmine", "Julius", "Jade", "Justin", "Jasmine", "Kai", "Jade", "Kaiden", "Jasmine", "Kaleb", "Jade"]))
    return " ".join(names)

def generateEmpID():
    return random.randint(1000, 9999)

def generateJobTitle():
    return random.choice(["Manager", "Engineer", "Analyst", "Developer", "Designer", "Architect", "Consultant", "Administrator", "Executive", "Coordinator"])

def generatePhoneNum():
    return random.randint(1000000000, 9999999999)

def generateCases():
    for _ in range(10):
        file = open(f"test_cases_{_}.txt", "w")
        s = f"{generateName()}\n{random.choice([generateEmpID(),generateJobTitle()])}\n{generatePhoneNum()}" + random.choice(["\n", f" {generatePhoneNum()}\n"])
        file.write(s)
        file.close()
        file = open(f"solution_{_}.txt", "w")
        name, job, phoneNum, _ = s.split("\n")
        s = name + "\n"
        if job.isnumeric():
            s += "Job ID: " + job + "\n"
        else:
            s += job + "\n"
        if " " in phoneNum:
            s += "home: " + phoneNum.split(" ")[0] + " work: " + phoneNum.split(" ")[1] + "\n"
        else:
            s += phoneNum + "\n"
        file.write(s)
        file.close()
    
generateCases()