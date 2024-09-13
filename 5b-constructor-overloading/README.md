## Lab 5: Method Overloading, Constructor Overloading, Composition, and Aggregation

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
