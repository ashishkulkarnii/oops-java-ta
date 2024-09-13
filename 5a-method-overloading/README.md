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