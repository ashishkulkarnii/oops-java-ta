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
