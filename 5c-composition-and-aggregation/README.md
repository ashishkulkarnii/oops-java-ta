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
