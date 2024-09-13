## Lab 5: Method Overloading, Constructor Overloading, Composition, and Aggregation

### [Composition and Aggregation Problem Statement](https://www.hackerrank.com/contests/ooadj-lab-week-5/challenges/composition-and-aggregation)

Create a system that can handle two kinds of inputs:

- Email ID
- URL

In case of a URL, create an instance of the `URL` class, and in case of an email ID, create an object of the `EmailID` class.

The email class has attributes (xyz@example.com):

- username (xyz)
- domain (example)
- top-level domain (com)

The URL class has attributes (https://example.com/path/to/resource.html):

- protocol (https)
- domain (example)
- top-level domain (com)
- path (path/to/resource.html)

Given an input of either a URl or Email ID, write a solution that instantiates the correct class, and calls the `print` method of each class. The print method's behaviour can be described by the output format, given below:

The input can be of the following types:

1. `https://example.com/path/to/resource.html`
2. `xyz@example.com`

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
domain: example
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
