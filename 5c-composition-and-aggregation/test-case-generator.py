import random

def generateEmailID():
    email = ""
    for _ in range(random.randint(1, 15)):
        email = email + chr(random.randint(97, 122))
    domain =random.choice(["gmail", "yahoo", "hotmail", "outlook"])
    res = email + "@" + domain + "." + "com"
    return [res, [email, domain, "com"]]

def generateURL():
    url = ""
    for _ in range(random.randint(1, 15)):
        url = url + chr(random.randint(97, 122))
    tld = random.choice(["com", "org", "net", "edu", "gov"])
    path = []
    for words in range(random.randint(1, 4)):
        word = ""
        for _ in range(random.randint(1, 7)):
            word = word + chr(random.randint(97, 122))
        path.append(word)
    path = "/".join(path) + "." + random.choice(["html", "htm", "php", "asp", "aspx", "jsp", "cfm", "cgi"])
    protocol = random.choice(["http", "https"])
    return [protocol + "://" + url + "." + tld + "/" + path, [protocol, url, tld, path]]

def generateCases():
    for _ in range(10):
        file = open(f"test_cases_{_}.txt", "w")
        case, ans = random.choice([generateEmailID(), generateURL()])
        file.write(f"{case}\n")
        file.close()
        file = open(f"solution_{_}.txt", "w")
        if len(ans) == 3:
            file.write(f"username: {ans[0]}\ndomain: {ans[1]}\ntld: {ans[2]}\n")
        else:
            file.write(f"protocol: {ans[0]}\ndomain: {ans[1]}\ntld: {ans[2]}\npath: {ans[3]}\n")
        file.close()

generateCases()