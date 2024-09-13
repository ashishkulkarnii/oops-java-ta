## Lab 6: Inheritance and Interfaces

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
