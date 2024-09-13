# oops-java-ta
This repository contains assignments and files I created during my stint as an undergraduate TA (teaching assistant) for the 6th-semester course Object-Oriented Analysis and Design with Java (UE21CS352B).

## Contents:

<!-- TOC start (generated with https://github.com/derlin/bitdowntoc) -->

   * [Lab 1: Use-case Modeling](#lab-1-use-case-modeling)
   * [Lab 2: Class Diagrams](#lab-2-class-diagrams)
   * [Lab 3: Activity and State Diagrams](#lab-3-activity-and-state-diagrams)
   * [Lab 5: Method Overloading, Constructor Overloading, Composition, and Aggregation](#lab-5-method-overloading-constructor-overloading-composition-and-aggregation)
      + [Method Overloading](#method-overloading-problem-statement)
      + [Constructor Overloading](#constructor-overloading-problem-statement)
      + [Composition and Aggregation](#composition-and-aggregation-problem-statement)
   * [Lab 6: Inheritance and Interfaces](#lab-6-inheritance-and-interfaces)
      + [Inheritance](#inheritance-problem-statement)
      + [Interfaces](#interfaces-problem-statement)
   * [Lab 7: Abstract Classes, ArrayLists, Linked Lists, and Stacks](#lab-7-abstract-classes-arraylists-linked-lists-and-stacks)
      + [Abstract Classes](#abstract-classes-problem-statement)
      + [ArrayLists](#arraylists-problem-statement)
      + [Linked Lists](#linked-lists-problem-statement)
      + [Stacks](#stacks-problem-statement)
   * [Lab 8: Multithreading and Serialization](#lab-8-multithreading-and-serialization)
      + [Multithreading](#multithreading-problem-statement)
      + [Serialization](#serialization-problem-statement)
   * [Lab 9: MVC Architecture](#lab-9-mvc-architecture)

<!-- TOC end -->

<!-- TOC --><a name="oops-java-ta"></a>

<!-- TOC --><a name="lab-1-use-case-modeling"></a>
## Lab 1: Use-case Modeling

<!-- TOC --><a name="problem-statement"></a>
### Problem Statement

Draw a use-case model to describe the interactions between a retail investor, stockbroker and stock exchange.
An investor logs in to their demat account (or signs up) with their stockbroker, and can place buy or sell orders (at a certain price) on any number of shares of any company listed on the stock exchange.
The order is given to the stock exchange via the broker, provided the user has sufficient balance in their trading account.
It is important to note that the orders can only be placed during market trading hours.

<details><summary>Solution</summary>

<!-- TOC --><a name="use-case-diagram"></a>
### Use-case Diagram

![Use-case diagram describing the given problem statement](1-use-case-modeling/use-case-diagram.drawio.svg)

</details>

<!-- TOC --><a name="lab-2-class-diagrams"></a>
## Lab 2: Class Diagrams

Prepare a detailed class diagram for XYZ Bank, including all classes, their methods and attributes (with visibility notation), relevant relationships (dependencies, generalizations, associations) with cardinalities, enumeration, etc. as described by the case study given below.

<!-- TOC --><a name="xyz-bank-case-study"></a>
### XYZ Bank Case Study

- XYZ Bank is a large banking company, with many branches across various locations. Some details regarding each branch, such as date of inception, IFSC code, address and phone number must be recorded to the system. There must be a method to allow for the opening of new branches.
- A customer is a person (senior citizen or regular), group of people, or firm having an account or deposit with the bank.
- An account can be of three types: savings, checking, or credit. Savings and checking accounts allow withdrawals and deposits, and offer a rate of interest on balance. Credit accounts have a credit limit, must be paid off at the end of each month, and have a penalty rate of interest, calculated monthly.
- A deposit (fixed or recurring) holds the attributes principal amount, rate of interest, tenure, and in case of recurring deposit, the amount that is additionally invested per month. Upon reaching the end of tenure, the amount is sent to a bank account number, which is given during time of opening.
- Each account and deposit is associated with a single branch, but the system allows transferring to a new branch.
- Every branch has employees. The system logs their basic details, an employee ID, and salary. The employees are necessarily account-holders at the same branch.

<details><summary>Solution</summary>

<!-- TOC --><a name="class-diagram"></a>
### Class Diagram

![Class diagram describing the given problem statement](2-class-diagrams/class-diagram.drawio.svg)

</details>

<!-- TOC --><a name="lab-3-activity-and-state-diagrams"></a>
## Lab 3: Activity and State Diagrams

<!-- TOC --><a name="activity-diagram-problem-statement"></a>
### Activity Diagram Problem Statement

A user logs in (or signs up) to Zomato to order food. Before the order is sent to the restaurant, the user must make the payment.
The order is sent to a restaurant, and if the restaurant accepts the order and begins its preparation. If the order is rejected, the user is refunded their money.
When the food is ready, it is picked up by a delivery agent and couriered to the user’s address.
Until the food is delivered, the user cannot make another purchase.

<details><summary>Solution</summary>

<!-- TOC --><a name="activity-diagram"></a>
### Activity Diagram

![Activity diagram describing the given problem statement](3-activity-and-state-diagrams/activity-diagram.drawio.svg)

</details>

<!-- TOC --><a name="state-diagram-problem-statement"></a>
### State Diagram Problem Statement

The delivery agent logs in to their version of the Zomato app, where they must wait until they get a delivery job.
The agent verifies themself at the restaurant, picks up the order, and delivers it to the address given to them.
While they are enroute, if the customer cancels their order, the agent must return the order to the restaurant.
The agent once again waits for their next job, until they log out.

<details><summary>Solution</summary>

<!-- TOC --><a name="state-diagram"></a>
### State Diagram

![State diagram describing the given problem statement](3-activity-and-state-diagrams/state-diagram.drawio.svg)

</details>

<!-- TOC --><a name="lab-5-method-overloading-constructor-overloading-composition-and-aggregation"></a>
## Lab 5: Method Overloading, Constructor Overloading, Composition, and Aggregation

<!-- TOC --><a name="method-overloading-problem-statement"></a>
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

<!-- TOC --><a name="code"></a>
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

<!-- TOC --><a name="constructor-overloading-problem-statement"></a>
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

<!-- TOC --><a name="code-1"></a>
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

<!-- TOC --><a name="composition-and-aggregation-problem-statement"></a>
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

<!-- TOC --><a name="code-2"></a>
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

<!-- TOC --><a name="lab-6-inheritance-and-interfaces"></a>
## Lab 6: Inheritance and Interfaces

<!-- TOC --><a name="inheritance-problem-statement"></a>
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

<!-- TOC --><a name="code-3"></a>
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

<!-- TOC --><a name="interfaces-problem-statement"></a>
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

<!-- TOC --><a name="code-4"></a>
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

<!-- TOC --><a name="lab-7-abstract-classes-arraylists-linked-lists-and-stacks"></a>
## Lab 7: Abstract Classes, ArrayLists, Linked Lists, and Stacks

<!-- TOC --><a name="abstract-classes-problem-statement"></a>
### [Abstract Classes Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-7/challenges/abstract-class-ooadj)

Compulsorily use the concept of abstract classes to solve this problem. Failure to abide by this rule will result in zero marks.

Create an abstract class called `Shape`. Create classes `Square` and `Triangle` that extend `Shape`. Each class must have two methods: `drawSolid()`, `drawHollow()` and `getArea()`, and one integer variables `x`. An object of either of these classes must be instantiated using `x`.

Draw the shapes using `.` (period). Examples are given below.

After drawing, print the area of the shape using `getArea()`. (`getArea()` returns a floating-point value.)

Input Format:
`<square or tri> <x> <solid or hollow>`

Constraints:
- `1 <= x <= 20`

Output Examples:

```
square 5 hollow:
.....
.   .
.   .
.   .
.....
25.0
```

```
tri 5 hollow
.
..
. .
.  .
.....
12.5
```

<details><summary>Solution</summary>

```java
// import java.io.*;
import java.util.*;

abstract class Shape {
    int x;

    Shape(int x) {
        this.x = x;
    }

    abstract void drawSolid();

    abstract void drawHollow();

    abstract double getArea();
}

class Square extends Shape {
    Square(int x) {
        super(x);
    }

    void drawSolid() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }

    void drawHollow() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (i == 0 || i == x - 1 || j == 0 || j == x - 1) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    double getArea() {
        return x * x;
    }
}

class Triangle extends Shape {
    Triangle(int x) {
        super(x);
    }

    void drawSolid() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }

    void drawHollow() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == 0 || i == x - 1 || j == 0 || j == i) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    double getArea() {
        return 0.5 * x * x;
    }
}

public class Solution {
    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner sc = new Scanner(System.in);
        String shape = sc.next();
        int x = sc.nextInt();
        String type = sc.next();

        if (shape.equals("square")) {
            Square s = new Square(x);
            if (type.equals("solid")) {
                s.drawSolid();
            } else {
                s.drawHollow();
            }
            System.out.println(s.getArea());
        } else {
            Triangle t = new Triangle(x);
            if (type.equals("solid")) {
                t.drawSolid();
            } else {
                t.drawHollow();
            }
            System.out.println(t.getArea());
        }
        sc.close();
    }
}
```

</details>

<!-- TOC --><a name="arraylists-problem-statement"></a>
### [ArrayLists Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-7/challenges/arraylist-ooadj)

Compulsorily use the concept of ArrayList to solve this problem. Failure to abide by this rule will result in zero marks.

A list of cars models (comma-separated), will be given in one line.
In the next line, there will be a list of horsepowers, which correspond to the respective cars above.

Populate two Java ArrayLists, one of car models and one of their horsepowers.
Sort the car models by their horsepowers.
As output, use the car model ArrayList's `toString()` method and print.

Input Example:
```
Mustang,Miata,Z
650,150,400
```

Constraints:
- `1 <= n <= 100`, where `n` is the number of car models.

Every car's name is unique.

Output Example:
```
[Miata, Z, Mustang]
```

<details><summary>Solution</summary>

<!-- TOC --><a name="code-5"></a>
### Code

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cars = sc.nextLine().split(",");
        String[] horsepowers = sc.nextLine().split(",");
        ArrayList<String> carModels = new ArrayList<String>(Arrays.asList(cars));
        ArrayList<String> carHorsepowers = new ArrayList<String>(Arrays.asList(horsepowers));
        ArrayList<Integer> carHorsepowersInt = new ArrayList<Integer>();
        for (String s : carHorsepowers) {
            carHorsepowersInt.add(Integer.parseInt(s));
        }
        for (int i = 0; i < carHorsepowersInt.size(); i++) {
            for (int j = i + 1; j < carHorsepowersInt.size(); j++) {
                if (carHorsepowersInt.get(i) > carHorsepowersInt.get(j)) {
                    int temp = carHorsepowersInt.get(i);
                    carHorsepowersInt.set(i, carHorsepowersInt.get(j));
                    carHorsepowersInt.set(j, temp);
                    String temp2 = carModels.get(i);
                    carModels.set(i, carModels.get(j));
                    carModels.set(j, temp2);
                }
            }
        }
        System.out.println(carModels.toString());
    }
}
```

</details>

<!-- TOC --><a name="linked-lists-problem-statement"></a>
### [Linked Lists Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-7/challenges/linked-list-ooadj)

Compulsorily use the concept of Linked List to solve this problem. Failure to abide by this rule will result in zero marks.

The input will be a single line of words, separated by single spaces.

Create a linked list, and based on each input, perform an action on this linked list:

1. If the word is a number, then add it to the end list.
2. If the word is `+`, then add all the existing elements in the list, and add this sum to the beginning of the list.
3. If the word is `-`, then subtract the last element of the list from the 2nd last element of the list, and add it to the end of the list.
4. If the word is `d`, then add a number equal to the first element to the end of the list.
5. Any of the above actions is not possible, then ignore the input word and move on to the next one.

Finally, print the list using it's `toString()` method.

Input Example:
```
12 13 2 4 + - + d d
```

Constraints:
- Number of words, `n < 100`.

Output Example:
```
[60, 31, 12, 13, 2, 4, -2, 60, 60]
```

<details><summary>Solution</summary>

<!-- TOC --><a name="code-6"></a>
### Code

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<Integer>();
        String[] input = sc.nextLine().split(" ");
        sc.close();
        for (String s : input) {
            if (s.equals("+")) {
                if (list.size() < 1) {
                    continue;
                }
                int sum = 0;
                for (int i : list) {
                    sum += i;
                }
                list.addFirst(sum);
            } else if (s.equals("-")) {
                if (list.size() < 2) {
                    continue;
                }
                int last = list.removeLast();
                int secondLast = list.getLast();
                list.addLast(last);
                list.addLast(secondLast - last);
            } else if (s.equals("d")) {
                if (list.size() < 1) {
                    continue;
                }
                list.addLast(list.getFirst());
            } else {
                list.addLast(Integer.parseInt(s));
            }
        }
        System.out.println(list.toString());
    }
}
```

</details>

<!-- TOC --><a name="stacks-problem-statement"></a>
### [Stacks Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-7/challenges/stack-ooadj)

Compulsorily use the concept of Stack to solve this problem. Failure to abide by this rule will result in zero marks.

You will be given a list of numbers, separated by newlines, as your input. Using only two stacks, and no built-in sorting methods, ensure that the main stack is sorted such that the top is the largest number.

Finally, use the toString() method and print the contents of the stack.

_Hint:_
The logic is as follows (don't read it if you want a challenge, but reading it won't make it super easy either):
- As you read numbers, push them onto the stack.
- If a number you are pushing onto the stack is lesser than the top, then keep popping elements (into temporary stack) until you are able to push the current number onto the stack.
- Return all temp stack elements to the main stack, and continue.

Input Format:
- One number per line, upto 1000 lines.

Constraints:
- Number of numbers <= 1000

Output Format:
- System.out.println(stack.toString())

<details><summary>Solution</summary>

<!-- TOC --><a name="code-7"></a>
### Code

```java
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> mainStack = new Stack<Integer>();
        Stack<Integer> tempStack = new Stack<Integer>();
        while (sc.hasNext()) {
            int num = sc.nextInt();
            while (!mainStack.isEmpty() && num < mainStack.peek()) {
                tempStack.push(mainStack.pop());
            }
            mainStack.push(num);
            while (!tempStack.isEmpty()) {
                mainStack.push(tempStack.pop());
            }
        }
        System.out.println(mainStack.toString());
    }
}
```

</details>

<!-- TOC --><a name="lab-8-multithreading-and-serialization"></a>
## Lab 8: Multithreading and Serialization

<!-- TOC --><a name="multithreading-problem-statement"></a>
### Multithreading Problem Statement

There is a restaurant that needs to assign all of its orders to its chefs. Each dish has a specific amount of time it takes to be prepared, and each chef can only work on one dish at a time. Use multithreading to get the sequence of completion of the orders, assuming they are being concurrently prepared by all the chefs.

Display messages when an order is assigned to the chef, when the order is in progress, and when the order is ready. In the implementation, it would make things convenient to create a fixed thread pool with the number of threads equal to the number of chefs. You can use the sleep method to simulate the preparation of a dish.

Note that based on the way you assign orders to a chef, and the number of chefs you have in your restaurant, you may have orders completed in a different order. In this example output, I have cyclically assigned orders to each of the 3 total chefs.

<!-- TOC --><a name="input"></a>
#### Input
```
Burger 6 minutes
Salad 3 minutes
Sundae 4 minutes
Pizza 8 minutes
Pasta 7 minutes
Steak 9 minutes
Soup 2 minutes
```

<!-- TOC --><a name="output"></a>
#### Output
```
Order #1 assigned to Chef #1
Order #2 assigned to Chef #2
Order #3 assigned to Chef #3
Order #4 assigned to Chef #1
Order #5 assigned to Chef #2
Order #6 assigned to Chef #3
Order #7 assigned to Chef #1
Order #7 for Soup in progress
Order #3 for Ice Cream Sundae in progress
Order #2 for Salad in progress
Order #1 for Burger in progress
Order #7 is ready.
Order #5 for Pasta in progress
Order #2 is ready.
Order #6 for Steak in progress
Order #4 for Pizza in progress
Order #3 is ready.
Order #5 is ready.
Order #6 is ready.
Order #4 is ready.
Order #1 is ready.
```

<!-- TOC --><a name="serialization-problem-statement"></a>
### Serialization Problem Statement

Create a command-line application for saving contacts.

A contact must contain a person’s name, email address and phone number. The application must have methods for the following:
1.	Add a new contact.
2.	View all contacts.
3.	Edit an existing contact.
4.	Delete an existing contact.

Make sure the edge cases (deleting or editing an existing contact) are handled properly.

Use serialization for data persistence, so that each time the program is invoked, it reads from a locally-stored address book, and every time the program is exited, the new state of the address book overwrites the previous save.

Look into `ObjectInputStream` and `FileInputStream`, and `ObjectOutputStream` and `FileOutputStream` for reading from and writing to the local save of the address book. These classes are imported when you `import java.io.*`.

<!-- TOC --><a name="example-interaction"></a>
#### Example Interaction
```
Welcome to Contacts App!

1. Add a new contact
2. View all contacts
3. Edit an existing contact
4. Delete an existing contact
5. Exit

Enter your choice: 1
Enter name: John Doe
Enter phone number: 1234567890
Enter email: john@example.com
Contact added successfully!

Enter your choice: 1
Enter name: Jane Smith
Enter phone number: 9876543210
Enter email: jane@example.com
Contact added successfully!

Enter your choice: 2
Contacts:
1. Name: John Doe, Phone: 1234567890, Email: john@example.com
2. Name: Jane Smith, Phone: 9876543210, Email: jane@example.com

Enter your choice: 3
Select a contact to edit:
1. Name: John Doe, Phone: 1234567890, Email: john@example.com
2. Name: Jane Smith, Phone: 9876543210, Email: jane@example.com
Enter index of contact to edit: 1
Enter updated details:
Enter name: John Deer
Enter phone number: 1231231234
Enter email: john.deer@example.com
Contact updated successfully!

Enter your choice: 2
Contacts:
1. Name: John Deer, Phone: 1231231234, Email: john.deer@example.com
2. Name: Jane Smith, Phone: 9876543210, Email: jane@example.com

Enter your choice: 4
Select a contact to delete:
1. Name: John Deer, Phone: 1231231234, Email: john.deer@example.com
2. Name: Jane Smith, Phone: 9876543210, Email: jane@example.com
Enter index of contact to delete: 2
Contact deleted successfully!

Enter your choice: 2
Contacts:
1. Name: John Deer, Phone: 1231231234, Email: john.deer@example.com

Enter your choice: 5
Exiting... Contacts saved.
```

<!-- TOC --><a name="lab-9-mvc-architecture"></a>
## Lab 9: MVC Architecture

The MVC is one of the most widely used architecture patterns for application and web development. MVC stands for Model View Controller:
- **Model**: Contains the data
- **View**: Contains the presentation logic
- **Controller**: Contains the backend code

To complete this week’s lab, use any of the following frameworks:
- Spring
- Grails
- Vaadin
- Play
- Struts
- Java Server Faces

Last year, when I was in your place, I found that creating an entire application, along with a GUI using a Java web-app framework (such as *Spring Boot*) was a pretty daunting task–especially to complete within a single lab session.

To make things easier for you, I have created template code using *Vaadin* with all the required classes and methods, you only need to fill them in. Use [this guide](https://vaadin.com/docs/latest/guide/quick-start) to set up *Vaadin* on your system.

From [here](9-mvc), download `code.zip` and extract it into any directory. You will find the main MVC files in `mvc\src\main\java\com\example\application\views\main`. Once you have filled in all the methods, `CD` into the `mvc` folder, and run `mvnw` on Windows, or `./mvnw` on Unix to run the project. You can also use the quick start project in the guide page to get started.

In case you decide to use *Vaadin*, look into the following components:
- [Grid](https://vaadin.com/docs/latest/components/grid)
- [Button](https://vaadin.com/docs/latest/components/button)
- [TextField](https://vaadin.com/docs/latest/components/text-field)
- [Dialog](https://vaadin.com/docs/latest/components/dialog)

<!-- TOC --><a name="problem-statement-1"></a>
### Problem Statement

Create an employee directory by storing each employee’s name using a HashMap, where the key is their ID and value is their name. Create another HashMap that determines the employees who are under a specific employee. Here, the key will be an employee ID, and the value will be a List of reporting employee IDs.

In the UI, have methods to display all employees, add an employee, get an employee’s subordinates’ names, and add a subordinate to an employee.

<!-- TOC --><a name="solution"></a>
### Solution

[mvc folder](9-mvc/mvc/)
