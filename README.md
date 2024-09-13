# oops-java-ta
This repository contains assignments and files I created during my stint as an undergraduate TA (teaching assistant) for the 6th-semester course Object-Oriented Analysis and Design with Java (UE21CS352B).


## Lab 1: Use-case Modeling

### Problem Statement

Draw a use-case model to describe the interactions between a retail investor, stockbroker and stock exchange.
An investor logs in to their demat account (or signs up) with their stockbroker, and can place buy or sell orders (at a certain price) on any number of shares of any company listed on the stock exchange.
The order is given to the stock exchange via the broker, provided the user has sufficient balance in their trading account.
It is important to note that the orders can only be placed during market trading hours.

<details><summary>Solution</summary>

### Use-case Diagram

![Use-case diagram describing the given problem statement](1-use-case-modeling/use-case-diagram.drawio.svg)

</details>

## Lab 2: Class Diagrams

Prepare a detailed class diagram for XYZ Bank, including all classes, their methods and attributes (with visibility notation), relevant relationships (dependencies, generalizations, associations) with cardinalities, enumeration, etc. as described by the case study given below.

### XYZ Bank Case Study

- XYZ Bank is a large banking company, with many branches across various locations. Some details regarding each branch, such as date of inception, IFSC code, address and phone number must be recorded to the system. There must be a method to allow for the opening of new branches.
- A customer is a person (senior citizen or regular), group of people, or firm having an account or deposit with the bank.
- An account can be of three types: savings, checking, or credit. Savings and checking accounts allow withdrawals and deposits, and offer a rate of interest on balance. Credit accounts have a credit limit, must be paid off at the end of each month, and have a penalty rate of interest, calculated monthly.
- A deposit (fixed or recurring) holds the attributes principal amount, rate of interest, tenure, and in case of recurring deposit, the amount that is additionally invested per month. Upon reaching the end of tenure, the amount is sent to a bank account number, which is given during time of opening.
- Each account and deposit is associated with a single branch, but the system allows transferring to a new branch.
- Every branch has employees. The system logs their basic details, an employee ID, and salary. The employees are necessarily account-holders at the same branch.

<details><summary>Solution</summary>

### Class Diagram

![Class diagram describing the given problem statement](2-class-diagrams/class-diagram.drawio.svg)

</details>

## Lab 3: Activity and State Diagrams

### Activity Diagram Problem Statement

A user logs in (or signs up) to Zomato to order food. Before the order is sent to the restaurant, the user must make the payment.
The order is sent to a restaurant, and if the restaurant accepts the order and begins its preparation. If the order is rejected, the user is refunded their money.
When the food is ready, it is picked up by a delivery agent and couriered to the user’s address.
Until the food is delivered, the user cannot make another purchase.

<details><summary>Solution</summary>

### Activity Diagram

![Activity diagram describing the given problem statement](3-activity-and-state-diagrams/activity-diagram.drawio.svg)

</details>

### State Diagram Problem Statement

The delivery agent logs in to their version of the Zomato app, where they must wait until they get a delivery job.
The agent verifies themself at the restaurant, picks up the order, and delivers it to the address given to them.
While they are enroute, if the customer cancels their order, the agent must return the order to the restaurant.
The agent once again waits for their next job, until they log out.

<details><summary>Solution</summary>

### State Diagram

![State diagram describing the given problem statement](3-activity-and-state-diagrams/state-diagram.drawio.svg)

</details>

## Lab 5: Method Overloading, Constructor Overloading, Composition, and Aggregation

### [Method Overloading Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-5/challenges/method-overloading-ooadj)

Create a class that stores employee details, named `Employee`. An object of `Employee` is instantiated using the employee's name.
There is a method of `Employee` called `storeNumber()`, which saves the employee's phone number(s).
The employee can have 1 or 2 phone numbers.
There is another method `writeJob()`, which either takes in the employee's job title (string), or the employee's job ID (integer).
Use method overloading to create `storeNumber()` and `writeJob()`.

Given all the employee details, print `<employee name>`, followed by their designation (the `<job title>` or `Job ID: <job ID>`) on the next line, followed by either `<phone number>` or `home:<phone number 1> work:<phone number 2>` on the next line.

Make sure not to add extra whitespaces.

The input given will be as follows:
```
<Employee name>
<phone number 1> <phone number 2 (optional)>
<job ID or job title>
```

The output must be as follows:
```
<Employee name>
<job title> (or) Job ID: <job ID>
<phone number> (or) home:<phone number 1> work:<phone number 2>
```

<details><summary>Solution</summary>

### Code

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class SignUp {
    String email = "";
    long phone_num = -1;
    
    SignUp(String contact) {
        this.email = contact;
    }
    SignUp(long contact) {
        this.phone_num = contact;
    }
    String get_contact() {
        if(this.phone_num == -1) {
            return this.email;
        }
        else {
            long sum;
            for(sum=0; this.phone_num!=0; this.phone_num=this.phone_num/10) {  
                sum = sum + this.phone_num % 10;
            }
            return Long.toString(sum);
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        s.close();
        String[] contacts = input.split(",");
        for(String c: contacts) {
            if(c.contains("@")) {
                SignUp x = new SignUp(c);
                System.out.println(x.get_contact());
            }
            else {
                SignUp x = new SignUp(Long.parseLong(c));
                System.out.println(x.get_contact());
            }
        }
    }
}
```

</details>

### [Constructor Overloading Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-5/challenges/constructor-overloading-ooadj)

A company is creating a sign up page, where a new user can sign in by entering their name and contact. Contact can be in the form of an email ID, or a phone number. Create a class `SignUp` that uses constructor overloading in such a way that an object of the class can be instantiated with the user's name, and either their email (string) or phone number (long integer).

`SignUp` also has a method `get_contact()` that when called returns a string that is:

- the sum of all digits of the phone number, in case the phone number was used as contact.
- the email ID, in case email ID was used as contact.

The input will be a list of comma-separated contacts. Each contact is a new sign-up: instantiate an object of `SignUp`, call `get_contact`, and print each result in a new line. Make sure you are not printing any whitespaces.

The email IDs contain no digits.

The input will look like this:
```
9824250932,abc@xyz.com,xyz@abc.com,abc_def@example.com,1231234567,4443332221
```

The output should look like this:
```
44
abc@xyz.com
xyz@abc.com
abc_def@example.com
34
28
```

<details><summary>Solution</summary>

### Code

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*;

class Employee {
    String name = "";
    String num = "";
    String job = "";
    Employee(String name) {
        this.name = name;
    }
    void writejob(int id) {
        this.job = "Job ID: " + String.valueOf(id);
    }
    void writejob(String job) {
        this.job = job;
    }
    void writenum(long num) {
        this.num = String.valueOf(num);
    }
    void writenum(long n1, long n2) {
        this.num = "home: " + String.valueOf(n1) + " work: " + String.valueOf(n2);
    }
    void res() {
        System.out.println(this.name);
        System.out.println(this.job);
        System.out.println(this.num);
        
    }
}

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        Employee e = new Employee(name);
        String job = s.nextLine();
        if(Character.isDigit(job.charAt(0))) {
            e.writejob(Integer.parseInt(job));
        }
        else {
            e.writejob(job);
        }
        String phno = s.nextLine();
        s.close();
        if(phno.contains(" ")) {
            long num1 = Long.parseLong(phno.split(" ")[0]);
            long num2 = Long.parseLong(phno.split(" ")[1]);
            e.writenum(num1, num2);
        }
        else {
            e.writenum(Long.parseLong(phno));
        }
        e.res();
    }
}
```

</details>

### [Composition and Aggregation Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-5/challenges/composition-and-aggregation)

Create a system that can handle two kinds of inputs:

- Email ID
- URL

In case of a URL, create an instance of the `URL` class, and in case of an email ID, create an object of the `EmailID` class.

The email class has attributes (xyz@gmail.com):

- username (xyz)
- domain (gmail)
- top-level domain (com)

The URL class has attributes (https://example.com/path/to/resource.html):

- protocol (https)
- domain (example)
- top-level domain (com)
- path (path/to/resource.html)

Given an input of either a URl or Email ID, write a solution that instantiates the correct class, and calls the `print` method of each class. The print method's behaviour can be described by the output format, given below:

The input can be of the following types:

1. `https://example.com/path/to/resource.html`
2. `xyz@gmail.com`

The output for `URL` class's `print()` method:

```
protocol: https
domain: example
top-level domain: com
path: path/to/resource.html
```

The output for `EmailID` class's `print()` method:

```
username: xyz
domain: gmail
top-level domain: com
```

<details><summary>Solution</summary>

### Code

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class EmailID {
    String username = "";
    String domain = "";
    String tld = "";
    
    EmailID(String email) {
        this.username = email.split("@")[0];
        this.domain = email.split("@")[1].split("[.]")[0];
        this.tld = email.split("@")[1].split("[.]")[1];
    }
    
    void print() {
        System.out.println("username: " + this.username);
        System.out.println("domain: " + this.domain);
        System.out.println("tld: " + this.tld);
    }
}

class URL {
    String protocol = "";
    String domain = "";
    String tld = "";
    String path = "";
    
    URL(String url) {
        this.protocol = url.split("://")[0];
        this.domain = url.split("://", 2)[1].split("[.]")[0];
        this.tld = url.split("://")[1].split("[.]", 2)[1].split("/", 2)[0];
        this.path = url.split("://")[1].split("[.]", 2)[1].split("/", 2)[1];
    }
    
    void print() {
        System.out.println("protocol: " + this.protocol);
        System.out.println("domain: " + this.domain);
        System.out.println("tld: " + this.tld);
        System.out.println("path: " + this.path);
    }
}

class Handler {
    EmailID email = null;
    URL url = null;
    Boolean is_url = false;
    
    Handler(String x) {
        if(x.contains("@")) {
            this.email = new EmailID(x);
        }
        else {
            this.url = new URL(x);
            this.is_url = true;
        }
    }
    
    void print() {
        if(this.is_url) {
            this.url.print();
        }
        else {
            this.email.print();
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        String x = s.nextLine();
        s.close();
        Handler sys = new Handler(x);
        sys.print();
    }
}
```

</details>

## Lab 6: Inheritance and Interfaces

### [Inheritance Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-6/challenges/inheritance-ooadj)

In this problem, you will be required to use the concept of inheritance (`class X extends class Y`).

Create an abstract class `Sequence` which has the method `getNthNumber`.

1. Create a class `Fibonacci` that extends `Sequence`. The first 2 numbers in the Fibonacci are `0` and `1`, and `Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)`.
2. Create a class `ArithmeticProgression` that adds the variables `first_term` and `difference`. Use these variables to compute the answer for `getNthNumber` using the AP nth term formula.
	- Create a class `WholeNumbers` that extends `ArithmeticProgression`. This is an arithmetic progression with `first_term=0` and `difference=1`.
	- Create a class `MultiplesOfFive` that extends `ArithmeticProgression`, and this sequence starts at `0`.

Make sure you follow the same naming conventions, since keyword matching will be used to validate whether you have used the concepts of inheritance and abstract class.

The input will be one line starting with the type of sequence: `fibonacci`, `ap`, `whole` or `five`. Followed by a space, we will define `n`. In the case of arithmetic progression, this will be followed by the first term and difference, all separated by a single space.

Examples:

- `fibonacci <n>`
- `ap <n> <first_term> <difference>`

Constraints:
- `1 <= n <= 47`
- `-10^3 <= first_term, difference <= 10^3`

The output must be the nth number of the requested sequence.

<details><summary>Solution</summary>

### Code

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

abstract class Sequence {
    int getNthNumber(int n) {
        return n;
    };
}

class Fibonacci extends Sequence {
    int getNthNumber(int n) {
        if(n == 1) {
            return 0;
        }
        else if(n == 2) {
            return 1;
        }
        else {
            int a = 0, b = 1, c = a + b;
            for(int i = 3; i <= n; ++i) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}

class ArithmeticProgression extends Sequence {
    int a = 0, d = 0;
    
    ArithmeticProgression(int a, int d) {
        this.a = a;
        this.d = d;
    }
    
    int getNthNumber(int n) {
        return this.a + (n - 1) * this.d;
    }
}

class WholeNumbers extends ArithmeticProgression {
    WholeNumbers() {
        super(0, 1);
    }
}

class MultiplesOfFive extends ArithmeticProgression {
    MultiplesOfFive() {
        super(0, 5);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String seq_type = input.split(" ")[0];
        int n = Integer.parseInt(input.split(" ")[1]);
        if(seq_type.equals("ap")) {
            int a = Integer.parseInt(input.split(" ")[2]), d = Integer.parseInt(input.split(" ")[3]);
            ArithmeticProgression ap = new ArithmeticProgression(a, d);
            System.out.println(ap.getNthNumber(n));
        }
        else if(seq_type.equals("fibonacci")) {
            Fibonacci fib = new Fibonacci();
            System.out.println(fib.getNthNumber(n));
        }
        else if(seq_type.equals("whole")) {
            WholeNumbers whole = new WholeNumbers();
            System.out.println(whole.getNthNumber(n));
        }
        else if(seq_type.equals("five")) {
            MultiplesOfFive five = new MultiplesOfFive();
            System.out.println(five.getNthNumber(n));
        }
    }
}
```

</details>

### [Interfaces Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-6/challenges/interfaces-ooadj)

Compulsorily use the concepts of interfaces to solve this problem. Failure to abide by this rule will result in zero marks.

Create an interface `Encryption` that has two methods: `encrypt()` and `decrypt()`. This form of encryption deals with encrypting strings.

There are two standards of encryption: `FooEncryption`, and `BarEncryption`. These will be represented as classes implementing `Encryption`.

*FooEncryption* of a string `s` can be defined by the following equation:

`s[i] -> ascii_char(ascii_number(s[i]) - (i % 2) + 3)`

*BarEncryption* of a string `s` can be defined by the following equation:

`s[i] -> ascii_char((ascii_number(s[i]) - ascii_number(s[i-1]) + 80)` if i >= 1, else

`s[i] -> s[i]`

The input will be given to you as follows:

`<encryption type: foo or bar> <encrypt or decrypt: en or de> <input string>`

Examples:
- `foo en HELLOWORLD`
- `bar de HELLOWORLD`

Constraints:
- `1 <= length(input_string) <= 65`
- `input_string` consists of only capital letters.

Output must be the output string of either encryption or decryption using the standard specified in the input

Example outputs:
- `KGONRYRTOF`
- `H9DAKSNYKF`

<details><summary>Solution</summary>

### Code

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface Encryption {
    public void encrypt();
    public void decrypt();
}

class FooEncryption implements Encryption {
    String str;
    
    FooEncryption(String str) {
        this.str = str;
    }
    
    public void encrypt() {
        String res = "";
        for(int i = 0; i < this.str.length(); ++i) {
            char c = (char) (((int) this.str.charAt(i)) - (i % 2) + 3);
            res = res + c;
        }
        this.str = res;
    }
    
    public void decrypt() {
        String res = "";
        for(int i = 0; i < this.str.length(); ++i) {
            char c = (char) (((int) this.str.charAt(i)) + (i % 2) - 3);
            res = res + c;
        }
        this.str = res;
    }
}

class BarEncryption implements Encryption {
    String str;
    
    BarEncryption(String str) {
        this.str = str;
    }
    
    public void encrypt() {
        String res = String.valueOf(this.str.charAt(0));
        for(int i = 1; i < this.str.length(); ++i) {
            char c = (char) (((int) this.str.charAt(i)) - ((int) this.str.charAt(i - 1)) + 80);
            res = res + c;
        }
        this.str = res;   
    }
    
    public void decrypt() {
        String res = String.valueOf(this.str.charAt(0));
        for(int i = 1; i < this.str.length(); ++i) {
            char c = (char) (((int) this.str.charAt(i)) + ((int) this.str.charAt(i - 1)) - 80);
            res = res + c;
        }
        this.str = res;   
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String fb = input.split(" ")[0], ed = input.split(" ")[1], str = input.split(" ")[2];
        if(fb.equals("foo")) {
            FooEncryption x = new FooEncryption(str);
            if(ed.equals("en")) {
                x.encrypt();
                System.out.println(x.str);
            }
            else {
                x.decrypt();
                System.out.println(x.str);
            }
        }
        else {
            BarEncryption x = new BarEncryption(str);
            if(ed.equals("en")) {
                x.encrypt();
                System.out.println(x.str);
            }
            else {
                x.decrypt();
                System.out.println(x.str);
            }
        }
    }
}
```

</details>

